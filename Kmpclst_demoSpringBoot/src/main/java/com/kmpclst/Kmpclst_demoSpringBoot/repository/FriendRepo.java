package com.kmpclst.Kmpclst_demoSpringBoot.repository;

import com.kmpclst.Kmpclst_demoSpringBoot.model.Friend;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FriendRepo {

//    private List<Friend> friends = Arrays.asList(
//    new Friend("Khan", "Karakorum", 75),
//    new Friend("Alice", "New York", 30),
//    new Friend("Mark", "Berlin", 25)
//);
//    public List<Friend> find() {
////        for (Friend friend : friends) {
////            if (friend.getName().equalsIgnoreCase(name)) {
////                return friend.getCity();
////            }
////        }
//        return friends;
//    }
//
//    public void addFriend(String name, String city, Integer age) {
//        Friend newFriend = new Friend(name, city, age);
//        friends.add(newFriend);
//    }
//
//    public void deleteFriend(String name) {
//        friends.removeIf(friend -> friend.getName().equalsIgnoreCase(name));
//    }
//
//    public void updateFriend(String name, String city, Integer age) {
//        for (Friend friend : friends) {
//            if (friend.getName().equalsIgnoreCase(name)) {
//                friend.setCity(city);
//                friend.setAge(age);
//                break;
//            }
//        }
//    }

    private JdbcTemplate jdbc;

    public FriendRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private RowMapper<Friend> friendRowMapper = (rs, rowNum) -> new Friend(
            rs.getString("name"),
            rs.getString("city"),
            rs.getInt("age")
    );

    public List<Friend> findAll() {
        return jdbc.query("SELECT * FROM friend ORDER BY name", friendRowMapper);
    }

    public Optional<Friend> findByName(String name) {
        var results = jdbc.query(
                "SELECT * FROM friend WHERE name = ?",
                friendRowMapper,
                name
        );
        System.out.println("Updated! Done...");
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    public void save(Friend friend) {
        jdbc.update(
                "INSERT INTO friend (name, city, age) VALUES (?, ?, ?)",
                friend.getName(),
                friend.getCity(),
                friend.getAge()
        );
    }

    public void deleteByName(String name) {
        jdbc.update(
                "DELETE FROM friend WHERE name = ?",
                name
        );
    }

    public void updateByName(String name, String city, Integer age) {
        jdbc.update(
                "UPDATE friend SET city = ?, age = ? WHERE name = ?",
                city,
                age,
                name
        );
    }
}