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
import com.codermy.myspringsecurityplus.fore.vo.params.ArticleParam;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("main/edit")
public class EditController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleBodyService articleBodyService;

    @Autowired
    private UserService userService;



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

        //articleBody添加
        //注意！我们在articleBody的mapper里设置了添加完成后自动设置uuid和返回
        //主键id的配置useGeneratedKeys="true" keyProperty="id"
        //插入后直接用get方法直接拿到bodyid,要不然是null
        ArticleBody articleBody=new ArticleBody();
        articleBody.setContent(articleParam.getContent());
        articleBody.setContentHtml(articleParam.getContentHtml());

        articleBodyService.insertArticleBody(articleBody);


        //article添加
        Article article=new Article();
        //id在插入数据库的时候自己添加
        article.setTitle(articleParam.getTitle());
        article.setSummary(articleParam.getSummary());
        article.setPreciseLocate(articleParam.getPreciseLocate());
        article.setContact(articleParam.getContact());
        article.setArea(articleParam.getArea());
        //article.setAuthorId();
        //注意！这里的getBodyID在mybatis自动插入回调了
        article.setBodyId(articleBody.getBodyId());
        article.setTypeId(articleParam.getType());
        article.setFinancialTypeId(articleParam.getFinancialType());
        article.setLocateId(articleParam.getLocate());
        article.setWeight(1);
        //creatdate插入数据库的时候加的了
        //获得当前用户信息
        MyUser myUser=userService.getUserByName(SecurityUtils.getCurrentUsername());
        article.setAuthorId(myUser.getUserId());

        //tag
        ArticleTag articleTag=new ArticleTag();
        Long articleId=article.getId();


        return Result.ok().message("发布成功！");
    }


    @PostMapping("/test")
    @ResponseBody
    public Result currentUserName(@RequestBody ArticleParam articleParam) {
        System.out.println(articleParam);
        return Result.ok();
    }
}
