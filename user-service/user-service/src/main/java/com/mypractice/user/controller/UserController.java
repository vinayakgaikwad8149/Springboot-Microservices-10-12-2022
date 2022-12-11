package com.mypractice.user.controller;

import com.mypractice.user.entity.User;
import com.mypractice.user.service.UserService;
import com.mypractice.user.valueObject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside the save user of usercontroller");
        return userService.saveUser(user);
    }
   @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside the save user of getUserWithDepartment");
        return userService.getUserWithDepartment(userId);
    }
}
