package com.kmpclst.Kmpclst_demoSpringBoot.controller;

import com.kmpclst.Kmpclst_demoSpringBoot.model.Friend;
import com.kmpclst.Kmpclst_demoSpringBoot.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyRESTcontroller {
    @Autowired
    private FriendService friendService;

    @GetMapping("/readfriend")
    public List<Friend> read(){
        return friendService.Find();
    }

    @GetMapping("/readfriend/{name}")
    public Optional<Friend> readByName(@PathVariable String name) {
        return friendService.FindByName(name);
    }

    @PostMapping("/createfriend")
    public Friend create(Friend friend) {
        return friendService.AddFriend(friend);
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
