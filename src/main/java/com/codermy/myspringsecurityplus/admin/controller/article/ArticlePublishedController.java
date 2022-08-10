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
@RequestMapping("/api/article/published")
@Api(tags = "系统：文章审核")
public class ArticlePublishedController {

    @GetMapping("/index")
    @ApiOperation(value = "返回已发布文章页面")
    public String published(){
        return "article/published/published";
    }
}
