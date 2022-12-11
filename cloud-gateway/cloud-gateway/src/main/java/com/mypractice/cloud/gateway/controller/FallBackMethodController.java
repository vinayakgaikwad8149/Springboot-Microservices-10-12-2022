package com.mypractice.cloud.gateway.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {

        return "User service is taking longer than expected" +
                "please try again later";
    }
    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBack() {

        return "department service is taking longer than expected" +
                "please try again later";
    }
}
