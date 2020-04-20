package com.guedim;

import lombok.SneakyThrows;
import lombok.Value;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import com.guedim.ext.item.ItemInfo;
import com.guedim.ext.item.ItemService;
import com.guedim.ext.postgres.Postgres;
import com.guedim.ext.redis.Redis;
import com.guedim.ext.user.UserInfo;
import com.guedim.ext.user.UserService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.IsNot.not;

@Redis
@Postgres
@UserService
@ItemService
class EndToEndTest {

    @Test
    void testFlow(UserInfo userInfo, ItemInfo itemInfo) {
        //create user
        User user = new User("", "guedim", "guedim@gmail.com");
        String userUrl = "http://localhost:" + userInfo.getPort() + "/users";
        UserCreateResponse userCreateResponse = post(userUrl, user, UserCreateResponse.class);
        assertThat(userCreateResponse.getId(), not(isEmptyString()));

        //create item for user above
        Item item = new Item("", "T-shirt", "XS", userCreateResponse.getId());
        String itemUrl = "http://localhost:" + itemInfo.getPort() + "/items";
        ItemCreateResponse itemCreateResponse = post(itemUrl, item, ItemCreateResponse.class);
        assertThat(itemCreateResponse.getId(), not(isEmptyString()));

        //get item with user info embedded
        ItemResponse itemResponse = new RestTemplate().getForEntity(itemUrl + "/" + itemCreateResponse.getId(), ItemResponse.class).getBody();
        assertThat(itemResponse.getCategory(), equalTo("T-shirt"));
        assertThat(itemResponse.getUser().getName(), equalTo("guedim"));
    }


    @SneakyThrows
    private <R> R post(String url, Object req, Class<R> clazz) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> request = new HttpEntity<>(new ObjectMapper().writeValueAsString(req), headers);
        ResponseEntity<R> response = new RestTemplate().postForEntity(url, request, clazz);
        return response.getBody();
    }

}


@Value
class User {
    String id;
    String name;
    String email;
}

@Value
class UserCreateResponse {
    String id;
}

@Value
class Item {
    String id;
    String category;
    String desc;
    String userId;
}

@Value
class ItemCreateResponse {
    String id;
}

@Value
class ItemResponse {
    String id;
    String category;
    String desc;
    User user;
}