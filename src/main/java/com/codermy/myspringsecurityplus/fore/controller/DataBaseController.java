package com.codermy.myspringsecurityplus.fore.controller;


import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.fore.service.ArticleForeService;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import com.codermy.myspringsecurityplus.fore.service.TagService;
import com.codermy.myspringsecurityplus.fore.vo.ArticleVo;
import com.codermy.myspringsecurityplus.fore.vo.params.PageAndArticleParam;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("main/blog")
public class DataBaseController {
    @Autowired
    private ArticleForeService articleForeService;

    @GetMapping("")
    @ApiOperation(value = "返回数据库页面")
    public String database(Model model){
        return "main/blog";
    }


    @PostMapping("/list")
    @ResponseBody
    @ApiOperation(value = "发布文章列表")
    @MyLog("查询已发布文章")
    public Result getArticleAll(@RequestBody PageAndArticleParam pageAndArticleParam){
        PageTableRequest pageTableRequest=pageAndArticleParam.getPageTableRequest();
        ArticleQueryDto articleQueryDto=pageAndArticleParam.getArticleQueryDto();
        System.out.println(articleForeService.getArticleAll(pageTableRequest.getOffset(), pageTableRequest.getLimit(), articleQueryDto));
        //这个是那个service所必须要的,这里是空，默认为查询所有
        return articleForeService.getArticleAll(pageTableRequest.getOffset(), pageTableRequest.getLimit(), articleQueryDto);
    }


}
