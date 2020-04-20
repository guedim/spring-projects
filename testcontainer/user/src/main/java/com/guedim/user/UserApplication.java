package com.guedim.user;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @RestController
    @RequestMapping(value = "users")
    class UserController {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @PostMapping
        public UserCreateResponse create(@RequestBody User request) {
            String id = UUID.randomUUID().toString();
            jdbcTemplate.update("INSERT INTO users (id, name, email) VALUES (?, ?, ?)",
                    id, request.getName(), request.getEmail());
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
}

@Value
class User {
    String id;
    String name;
    String email;
}

@Value
class UserCreateResponse {
    private final String id;
}
