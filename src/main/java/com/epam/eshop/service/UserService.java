package com.epam.eshop.service;

import java.util.List;

public interface UserService <T,I>{

    T getById(I id);

    void save(T entity);

    List<T> getAll();

    void deleteById(I id);
}
