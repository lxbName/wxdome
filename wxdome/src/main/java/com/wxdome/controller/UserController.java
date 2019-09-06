package com.wxdome.controller;

import com.wxdome.common.ResultUtils;
import com.wxdome.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wxdome.entity.User;


import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/findAll")
    public Object getAll(){
        List<User> userList= userService.findAll();
        return ResultUtils.success(userList);
    }


    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    public Object userLogin(@RequestParam("wxcount") String wxcount,@RequestParam("password") String password){
        System.out.println("账号："+wxcount);
        System.out.println("密码："+password);
        List<User> userList = new ArrayList<>();
        if("".equals(wxcount) && "".equals(password)){
            return ResultUtils.fail();
        } else {
            userList = userService.login(wxcount,password);
            if(userList.size() == 0 || "".equals(userList)){
                return ResultUtils.fail();
            }
        }
        return ResultUtils.success(userList);
    }

    @RequestMapping(value = "/userRegister",method = {RequestMethod.POST,RequestMethod.GET})
    public Object userAdd(@RequestBody User user){
        System.out.println("user==="+user);
        userService.save(user);
        return ResultUtils.success("保存成功");
    }

    @RequestMapping(value = "/selectPhone",method= {RequestMethod.POST,RequestMethod.GET})
    public Object selectPhone(@RequestParam("phone") String phone){
        String phoneEx = userService.selectPhone(phone);
        String state = "1";  //已注册
        if(phoneEx == null && "".equals(phoneEx)){
            state = "0";  //未注册
        }
        return ResultUtils.success(state);
    }
}
