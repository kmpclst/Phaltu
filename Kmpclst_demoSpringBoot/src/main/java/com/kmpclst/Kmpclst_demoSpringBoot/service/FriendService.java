package com.kmpclst.Kmpclst_demoSpringBoot.service;

import com.kmpclst.Kmpclst_demoSpringBoot.model.Friend;
import com.kmpclst.Kmpclst_demoSpringBoot.repository.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FriendService {
    @Autowired
    private FriendRepo friendRepo;

    public List<Friend> Find() {
        return friendRepo.findAll();
    }

    public Optional<Friend> FindByName(String name) {
        return friendRepo.findByName(name);
    }

    public void AddFriend(Friend friend) {
        friendRepo.save(friend);
    }

    public void DeleteFriend(String name) {
        friendRepo.deleteByName(name);
    }

    public void UpdateFriend(String name, String city, Integer age) {
        friendRepo.updateByName(name, city, age);
    }
}
