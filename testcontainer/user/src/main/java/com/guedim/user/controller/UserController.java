package com.guedim.user.controller;

import com.guedim.user.config.KafkaProducer;
import com.guedim.user.model.User;
import com.guedim.user.model.UserCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "users")
public class UserController {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Autowired
        private KafkaProducer producer;

        @PostMapping
        public UserCreateResponse create(@RequestBody User request) {
            String id = UUID.randomUUID().toString();

            // Postgres dependency
            jdbcTemplate.update("INSERT INTO users (id, name, email) VALUES (?, ?, ?)",
                    id, request.getName(), request.getEmail());

            // Kafka Dependency
            producer.send(request.toString());

            return new UserCreateResponse(id);
        }

        @GetMapping("/{id}")
        public User get(@PathVariable String id) {
            return jdbcTemplate.queryForObject("SELECT id, name, email " +
                            "FROM users WHERE id = ?", new Object[]{id},
                    (rs, rowNum) -> new User(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getString("email")));
        }
}
