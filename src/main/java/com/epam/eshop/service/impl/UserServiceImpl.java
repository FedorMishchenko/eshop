package com.epam.eshop.service.impl;

import com.epam.eshop.domain.UserEntity;
import com.epam.eshop.repository.UserRepository;
import com.epam.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService<UserEntity,String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getById(String id) {
        return null;
    }

    @Override
    public void save(UserEntity entity) {

    }

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
