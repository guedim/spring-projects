package com.guedim.wiremock;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="userFeignClient")
public interface UserFeignClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
    String getUsers();

}
