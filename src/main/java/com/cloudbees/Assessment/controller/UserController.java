package com.cloudbees.Assessment.controller;

import com.cloudbees.Assessment.entity.Ticket;
import com.cloudbees.Assessment.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void addReceipt(String user, Ticket ticket) {
        userService.addReceipt(user, ticket);
    }

    @GetMapping("/getReceipt")
    public String getReceipt(@RequestParam String firstName) {
        return userService.getReceipt(firstName).toString();
    }
}
