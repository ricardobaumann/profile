package com.github.ricbau.profile.controllers;

import com.github.ricbau.profile.output.Pong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public Pong ping() {
        return new Pong("bar");
    }

}
