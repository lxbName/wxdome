package com.wxdome.service;

import com.wxdome.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<User> login(String wxcount,String password);

    String selectPhone(String phone);
}
