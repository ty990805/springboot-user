package com.example.demo.controller;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import com.example.demo.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @ApiOperation(value = "添加")
    @PostMapping("/addOrUpdate")
    public Result add(@RequestBody UserInfo userInfo) {
        Result result = new Result();
        try {
            if (StringUtils.isEmpty(userInfo.getId())){
                userInfoService.save(userInfo);
                result.setMsg("添加用户信息成功");
            }else{
                userInfoService.updateById(userInfo);
                result.setMsg("编辑用户信息成功");
            }
        }catch (Exception e){
            result.setStatus(false);
            result.setMsg("保存用户信息失败");
        }
        return result;
    }

    @ApiOperation(value = "删除")
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        Result result = new Result();
        try {
            userInfoService.removeById(id);
            result.setMsg("删除用户信息成功");
        }catch (Exception e){
            result.setStatus(false);
            result.setMsg("删除用户信息失败");
        }
        return result;
    }

//    @ApiOperation(value = "修改")
//    @PostMapping("/update")
//    public Result update(@RequestBody UserInfo userInfo) {
//        Result result = new Result();
//        try {
//            userInfoService.updateById(userInfo);
//            result.setMsg("编辑用户信息成功");
//        }catch (Exception e){
//            result.setStatus(false);
//            result.setMsg("编辑用户信息失败");
//        }
//        return result;
//    }

    @ApiOperation(value = "查询")
    @GetMapping("/get/{id}")
    public UserInfo get(@PathVariable Long id) {
        return userInfoService.getById(id);
    }

    @ApiOperation(value = "获取")
    @GetMapping("/list")
    public List<UserInfo> list() {
        return userInfoService.list();
    }


}