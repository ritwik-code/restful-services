package com.practice.restwebservices.restfulservices.helloworld;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    public static List<User> users = new ArrayList();
    public static int id;
    static {
        users.add(new User(id++,"Ritwik", LocalDate.now().minusYears(30)));
        users.add(new User(id++,"Treatwik", LocalDate.now().minusYears(20)));
        users.add(new User(id++,"Prithwik", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(Integer id){
        return UserDao.users.stream().filter(user -> {
            if (user.getId().equals(id))
                return true;
            return false;
        }).findFirst().orElse(null);
    }

    public User addOne(User user){
        User createdUser = new User(++id, user.getName(), user.getAge());
        users.add(createdUser);
        return createdUser;
    }

    public void deleteOne(Integer id){
        users.remove(findOne(id));
    }
}
