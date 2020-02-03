package com.epam.eshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService <T,I>{

    T getById(I id);

    T save(T entity);

    Page<T> findUsers(String fullName, String role, Pageable pageable);

    void deleteById(I id);
}
