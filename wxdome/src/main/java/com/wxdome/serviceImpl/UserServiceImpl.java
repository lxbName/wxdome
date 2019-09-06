package com.wxdome.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxdome.mapper.userMapper;
import com.wxdome.service.UserService;
import org.springframework.stereotype.Service;
import com.wxdome.entity.User;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<userMapper,User> implements UserService {

    @Override
    public List<User> findAll(){
        return baseMapper.findAll();
    }

    @Override
    public List<User> login(String wxcount, String password) {
        System.out.println("账号1111=== "+wxcount);
        System.out.println("密码1111=== "+password);
        return baseMapper.userSelect(wxcount,password);
    }

    @Override
    public String selectPhone(String phone){
        System.out.println("电话号码=== "+phone);
        return baseMapper.selectPhone(phone);
    }
}
