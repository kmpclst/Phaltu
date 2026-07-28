package com.kmpclst.Kmpclst_demoSpringBoot.repository;

import com.kmpclst.Kmpclst_demoSpringBoot.model.Friend;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FriendRepo {
    private List<Friend> friends = Arrays.asList(
    new Friend("Khan", "New York", 25),
    new Friend("John", "Los Angeles", 30),
    new Friend("Alice", "Chicago", 28),
    new Friend("Bob", "Houston", 35)
);
    public List<Friend> find() {
//        for (Friend friend : friends) {
//            if (friend.getName().equalsIgnoreCase(name)) {
//                return friend.getCity();
//            }
//        }
        return friends;
    }

    public void addFriend(String name, String city, Integer age) {
        Friend newFriend = new Friend(name, city, age);
        friends.add(newFriend);
    }

    public void deleteFriend(String name) {
        friends.removeIf(friend -> friend.getName().equalsIgnoreCase(name));
    }

    public void updateFriend(String name, String city, Integer age) {
        for (Friend friend : friends) {
            if (friend.getName().equalsIgnoreCase(name)) {
                friend.setCity(city);
                friend.setAge(age);
                break;
            }
        }
    }
}
