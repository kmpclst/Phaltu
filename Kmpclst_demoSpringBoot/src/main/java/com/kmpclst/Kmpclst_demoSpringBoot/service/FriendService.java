package com.kmpclst.Kmpclst_demoSpringBoot.service;

import com.kmpclst.Kmpclst_demoSpringBoot.model.Friend;
import com.kmpclst.Kmpclst_demoSpringBoot.repository.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendService {
    @Autowired
    private FriendRepo friendRepo;

    public List<Friend> Find() {
        return friendRepo.find();
    }

    public void AddFriend(String name, String city, Integer age) {
        friendRepo.addFriend(name, city, age);
    }

    public void DeleteFriend(String name) {
        friendRepo.deleteFriend(name);
    }

    public void UpdateFriend(String name, String city, Integer age) {
        friendRepo.updateFriend(name, city, age);
    }
}
