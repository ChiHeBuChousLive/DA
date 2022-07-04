package com.codermy.myspringsecurityplus.fore.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tan
 * @createTime 2022/7/4
 */
@Controller
@RequestMapping("/main")
@Api(tags = "系统：菜单路由")
public class ForeController {

    @GetMapping("/index")
    @ApiOperation(value = "前台首页")
    public String console(){
        return "main/index";
    }

}
