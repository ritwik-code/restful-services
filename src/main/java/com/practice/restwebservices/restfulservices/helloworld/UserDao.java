package com.practice.restwebservices.restfulservices.helloworld;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {
//    public static List<User> users = new ArrayList();
//    public static int id;
//
//    static {
//        users.add(new User(id++, "Ritwik", LocalDate.now().minusYears(30)));
//        users.add(new User(id++, "Treatwik", LocalDate.now().minusYears(20)));
//        users.add(new User(id++, "Prithwik", LocalDate.now().minusYears(10)));
//    }
//
//    public List<User> findAll() {
//        return users;
//    }
//
//    public User findOne(Integer id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return UserDao.users.stream().filter(predicate).findFirst().orElse(null);
//    }
//
//    public User addOne(User user) {
//        User createdUser = new User(++id, user.getName(), user.getBirthDate());
//        users.add(createdUser);
//        return createdUser;
//    }
//
//    public void deleteById(Integer id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        users.removeIf(predicate);
//    }
}
