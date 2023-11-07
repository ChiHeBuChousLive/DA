package com.codermy.myspringsecurityplus.fore.controller;

import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.JobService;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
@Api(tags = "系统：用户注册")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @PostMapping("/post")
    @ResponseBody
    @ApiOperation(value = "注册用户")
    @MyLog("注册用户")
    //RequestBody注解用来匹配前端传过来的资源
    public Result<MyUser> saveUser(@RequestBody MyUser myUser){
        //验证手机号存不存在
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(myUser))){
            return Result.error().message("手机号已存在");
        }
        //验证用户名有没有存在
        if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkUserNameUnique(myUser))){
            return Result.error().message("用户名已存在");
        }
        //验证邮箱
        if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkUserEmailUnique(myUser))){
            return Result.error().message("邮箱已存在");
        }
        System.out.println(myUser);
        //一个下载下来的密码加密工具
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
        myUser.setStatus(1);
        return userService.save(myUser,2);
    }

    @GetMapping("")
    @ApiOperation(value = "添加用户页面")
    //这个controller用来转到登录页面
    public String addUser(Model model){
        model.addAttribute("myUser",new MyUser());
        return "register";
    }


    @PostMapping("/test")
    public Result currentUserName() {
        return Result.ok();
    }



}
