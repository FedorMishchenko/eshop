package com.epam.eshop.service.impl;

import com.epam.eshop.domain.UserEntity;
import com.epam.eshop.repository.UserRepository;
import com.epam.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService<UserEntity,String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getById(String id) {
        return null;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return null;
    }

    @Override
    public Page<UserEntity> findUsers(String fullName, String role, Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
