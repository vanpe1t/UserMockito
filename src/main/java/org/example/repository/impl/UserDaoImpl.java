package org.example.repository.impl;

import org.example.model.UserAlreadyAddedException;
import org.example.model.User;
import org.example.repository.UserDao;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class UserDaoImpl implements UserDao {
    HashSet<User> users = new HashSet<>();

    public UserDaoImpl() {
        addUsers();
    }

    private void addUsers() {
        users.add(new User("User"));
        users.add(new User("NewUser"));
    }
    @Override
    public User getUserByName(String name) {
        return  users.stream()
                    .filter(thisUser -> thisUser.getName().equals(name))
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public HashSet<User> findAllUsers() {
        return users;
    }

    @Override
    public void add(User user) throws UserAlreadyAddedException {
        if (users.contains(user)) {
            throw new UserAlreadyAddedException();
        }
        users.add(user);
    }

    @Override
    public Boolean checkUserExist(User user) {
        return users.contains(user);
    }


}
