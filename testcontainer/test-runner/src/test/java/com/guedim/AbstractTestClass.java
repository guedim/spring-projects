package com.guedim;

import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractTestClass {

    @SneakyThrows
    public  <R> R post(String url, Object req, Class<R> clazz) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> request = new HttpEntity<>(new ObjectMapper().writeValueAsString(req), headers);
        ResponseEntity<R> response = new RestTemplate().postForEntity(url, request, clazz);
        return response.getBody();
    }
}
