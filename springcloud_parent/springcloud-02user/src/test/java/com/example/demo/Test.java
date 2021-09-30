package com.example.demo;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.service.UserInfoService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@SpringBootTest//springboot整合了junit之后的一个注解；
class Test {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @org.junit.jupiter.api.Test
    public void testQueryList(){
        List<UserInfo> users = userInfoMapper.selectList(null);
        System.out.println(users);
    }
    @org.junit.jupiter.api.Test
    public void testadd(){
        UserInfo userInfo = new UserInfo("2","ty2",new Date(),"女","山西");
        int i = userInfoMapper.insert(userInfo);
        System.out.println(i);
    }
    @org.junit.jupiter.api.Test
    public void testupdate(){
        UserInfo userInfo = userInfoMapper.selectById(1);
        userInfo.setName("txy");
        userInfo.setBir(new Date());
        userInfo.setSex("女");
        userInfo.setAddress("山西");
        int i = userInfoMapper.updateById(userInfo);
        System.out.println(i);
    }
    @org.junit.jupiter.api.Test
    public void testdelete(){
        int i = userInfoMapper.deleteById(3);
        System.out.println(i);
    }

}
