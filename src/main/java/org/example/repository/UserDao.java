package org.example.repository;

import org.example.model.UserAlreadyAddedException;
import org.example.model.User;

import java.util.HashSet;

public interface UserDao {

    public User getUserByName(String name);

    public void add(User user) throws UserAlreadyAddedException;

    public HashSet<User> findAllUsers();

    Boolean checkUserExist(User user);
}
