package com.codermy.myspringsecurityplus.admin.controller.article;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author 吃喝不愁
 * @createTime 2022/7/19
 */

@Controller
@RequestMapping("/api/article/locate")
@Api(tags = "系统：地区类型")
public class ArticleLocateController {


    @GetMapping("/index")
    @ApiOperation(value = "返回地区页面")
    public String verify(){
        return "article/locate/locate";
    }
}
