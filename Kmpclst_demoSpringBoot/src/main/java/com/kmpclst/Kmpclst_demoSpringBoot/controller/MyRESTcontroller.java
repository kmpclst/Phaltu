package com.kmpclst.Kmpclst_demoSpringBoot.controller;

import com.kmpclst.Kmpclst_demoSpringBoot.model.Friend;
import com.kmpclst.Kmpclst_demoSpringBoot.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MyRESTcontroller {
    @Autowired
    private FriendService friendService;

    @GetMapping("/readfriend")
    public List<Friend> read(){
        return friendService.Find();
    }

    @PostMapping("/createfriend")
    public void create(String name, String city, Integer age) {
        friendService.AddFriend(name, city, age);
    }

    @DeleteMapping("/deletefriend")
    public void delete(String name) {
        friendService.DeleteFriend(name);
    }

    @PutMapping("/updatefriend/{name}")
    public void update(@PathVariable String name, String city, Integer age) {
        friendService.UpdateFriend(name, city, age);
    }
}
