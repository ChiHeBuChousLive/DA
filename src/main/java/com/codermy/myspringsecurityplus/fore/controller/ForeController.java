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
    public String index(){
        return "main/index";
    }

    @GetMapping("/about")
    @ApiOperation(value = "前台首页")
    public String about(){
        return "main/about";
    }

    @GetMapping("/blog")
    @ApiOperation(value = "前台首页")
    public String blogs(){
        return "main/blog";
    }

    @GetMapping("/blog-single-post")
    @ApiOperation(value = "前台首页")
    public String blog(){
        return "main/blog-single-post";
    }

    @GetMapping("/contact")
    @ApiOperation(value = "前台首页")
    public String contact(){
        return "main/contact";
    }

    @GetMapping("/error")
    @ApiOperation(value = "前台首页")
    public String error(){
        return "main/error";
    }

    @GetMapping("/portfolio")
    @ApiOperation(value = "前台首页")
    public String portfolio(){
        return "main/portfolio";
    }

    @GetMapping("/pricing")
    @ApiOperation(value = "前台首页")
    public String pricing(){
        return "main/pricing";
    }

    @GetMapping("/services")
    @ApiOperation(value = "前台首页")
    public String services(){
        return "main/services";
    }

}
