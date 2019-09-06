package com.wxdome.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id //主键注释
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //主键自增
    @Column(name = "id") //对应表中列
    private int id;

    @Column(name = "wxname") //微信名称
    private String wxname;

    @Column(name = "wxcount")
    private String wxcount; //微信账号

    @Column(name= "password")
    private String password; //登录密码

    @Column(name= "phone")
    private String phone; //手机号码

    @Column(name= "code")
    private String code; //验证码

    @Column(name= "passwordAgain")
    private String passwordAgain; //重复密码

    public User(){}

    public User(int id,String wxname,String wxcount,String password,String phone,String code,String passwordAgain){
        this.id = id;
        this.wxname = wxname;
        this.wxcount = wxcount;
        this.password = password;
        this.phone = phone;
        this.code = code;
        this.passwordAgain = passwordAgain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxname() {
        return wxname;
    }

    public void setWxname(String wxname) {
        this.wxname = wxname;
    }

    public String getWxcount() {
        return wxcount;
    }

    public void setWxcount(String wxcount) {
        this.wxcount = wxcount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }
}
