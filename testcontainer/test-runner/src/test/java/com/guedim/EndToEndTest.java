package com.guedim;

import com.guedim.ext.item.ItemInfo;
import com.guedim.ext.item.ItemService;
import com.guedim.ext.kafka.Kafka;
import com.guedim.ext.postgres.Postgres;
import com.guedim.ext.redis.Redis;
import com.guedim.ext.user.UserInfo;
import com.guedim.ext.user.UserService;
import com.guedim.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.IsNot.not;

@Kafka
@Redis
@Postgres
@UserService
@ItemService
public class EndToEndTest extends AbstractTestClass {

    @Test
    void testFlow(UserInfo userInfo, ItemInfo itemInfo) throws InterruptedException {

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
}


