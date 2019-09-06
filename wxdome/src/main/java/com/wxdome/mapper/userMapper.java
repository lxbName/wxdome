package com.wxdome.mapper;

import com.wxdome.common.ParentMapper;
import com.wxdome.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userMapper extends ParentMapper<User> {

    public List<User> userSelect(@Param("wxcount") String wxcount, @Param("password") String password);

    public List<User> findAll();

    public String selectPhone(@Param("phone") String phone);
}
