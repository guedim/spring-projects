package com.guedim.spring.lemondemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guedim.spring.lemondemo.domain.User;
import com.naturalprogrammer.spring.lemon.LemonController;

@RestController
@RequestMapping("/api/core")
public class MyController extends LemonController<User, Long> {

}