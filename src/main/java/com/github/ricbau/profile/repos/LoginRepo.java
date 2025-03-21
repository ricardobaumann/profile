package com.github.ricbau.profile.repos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(value = "login", url = "http://localhost:8080")
public interface LoginRepo {

    @GetMapping("/v1/login/{token}")
    UserInfo getByToken(@PathVariable String token);

}
