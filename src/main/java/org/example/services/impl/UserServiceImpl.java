package org.example.services.impl;

import org.example.model.User;
import org.example.repository.UserDao;
import org.example.repository.impl.UserDaoImpl;
import org.example.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Boolean checkUserExist(User user) {
        return userDao.checkUserExist(user);
    }
}
