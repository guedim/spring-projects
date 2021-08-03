package com.guedim.tc.item.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guedim.tc.item.config.UserProperties;
import com.guedim.tc.item.model.Item;
import com.guedim.tc.item.model.ItemCreateResponse;
import com.guedim.tc.item.model.ItemResponse;
import com.guedim.tc.item.model.User;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping(value = "items")
public class ItemController {

    private static final ObjectMapper mapper = new ObjectMapper();
    private final ConcurrentMap<String, Item> itemStore = new ConcurrentHashMap<>();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisCommands<String, String> redisCommands;

    @Autowired
    private UserProperties userProps;

    @PostMapping
    @SneakyThrows
    public ItemCreateResponse create(@RequestBody Item request) {

        //get user from Redis if any
        String userJson = redisCommands.get("user:" + request.getUserId());
        if (userJson == null) {

            //get user from User service
            String url = "http://" + userProps.getHost() + ":" + userProps.getPort();
            ResponseEntity<User> response = restTemplate.getForEntity(
                    url + "/users/{id}", User.class, request.getUserId());

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new IllegalArgumentException("User does not exist " + request.getUserId());
            }

            //store user to Redis
            redisCommands.set("user:" + request.getUserId(),
                    mapper.writeValueAsString(response.getBody()));
        }

        //store item into memory
        String id = UUID.randomUUID().toString();
        Item item = new Item(id, request.getCategory(), request.getDesc(), request.getUserId());
        itemStore.put(id, item);

        return new ItemCreateResponse(id);
    }

    @GetMapping("/{id}")
    @SneakyThrows
    public ItemResponse get(@PathVariable String id) {
        Item item = itemStore.get(id);
        if (item == null) {
            throw new IllegalStateException("Item does not exist " + id);
        }

        String userJson = redisCommands.get("user:" + item.getUserId());
        User user = mapper.readValue(userJson, User.class);
        return new ItemResponse(id, item.getCategory(), item.getDesc(), user);
    }
}
