package com.wxdome.controller;

import com.alibaba.fastjson.JSONObject;
import com.wxdome.common.ResultUtils;
import com.wxdome.serviceImpl.UserServiceImpl;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wxdome.entity.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
        if(phoneEx == null || "".equals(phoneEx)){
            state = "0";  //未注册
        }
        return ResultUtils.success(state);
    }

    @RequestMapping(value = "/sendSms",method = {RequestMethod.POST,RequestMethod.GET})
    public Object sendSms(@RequestParam("phone") String phone){

        try {
            JSONObject json = null;
            //生成6位随机码
            String verifyCode = String.valueOf(new Random().nextInt(899999)+100000);
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","102654","854d0449-55fc-4283-98fc-c547ad0ab878");
            String result = client.send(phone,"您的验证码为：" + verifyCode +"，该码有效期为5分钟，该码只能使用一次！小程序测试");
            json = JSONObject.parseObject(result);
            //code: 发送状态，0为成功。非0为发送失败
            if(json.getIntValue("code") != 0){
                return ResultUtils.fail("验证码短信发送失败");
            } else {
                return ResultUtils.success(verifyCode);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtils.success();
    }
}
