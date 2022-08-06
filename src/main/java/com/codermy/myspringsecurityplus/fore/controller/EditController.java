package com.codermy.myspringsecurityplus.fore.controller;

import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.SecurityUtils;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.entity.Tag;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.fore.service.ArticleService;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import com.codermy.myspringsecurityplus.fore.vo.params.ArticleParam;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("main/edit")
public class EditController {
    @Autowired
    private ArticleService articleService;


    @GetMapping("")
    @ApiOperation(value = "文章编辑页面")
    public String edit(Model model){
        model.addAttribute("articleParam",new ArticleParam());
        return "/main/edit";
    }

//    @PostMapping("/post")
//    @ResponseBody
//    @ApiOperation(value = "提交文章")
//    @MyLog("提交文章")
//    public Result postArticle(@RequestBody ArticleParam articleParam){
//
//        return Result.judge();
//    }

    @PostMapping("/post")
    @ResponseBody
    @ApiOperation(value = "提交文章")
    @MyLog("提交文章")
    public Result postArticle(@RequestBody ArticleParam articleParam){

        articleService.insertArticleSave(articleParam);
        return Result.ok().message("发布成功！");
    }


    @PostMapping("/test")
    @ResponseBody
    public Result currentUserName(@RequestBody ArticleParam articleParam) {
        articleService.insertArticleSave(articleParam);
        return Result.ok().message("文章发布成功！");
    }
}
