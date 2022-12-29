package com.codermy.myspringsecurityplus.fore.controller;

import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.fore.service.ArticleForeService;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import com.codermy.myspringsecurityplus.fore.service.TagService;
import com.codermy.myspringsecurityplus.fore.vo.ArticleVo;
import com.codermy.myspringsecurityplus.fore.vo.params.PageAndArticleParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main/blog-single-post")
public class BlogSinglePostController {

    @Autowired
    private ArticleForeService articleForeService;
    @Autowired
    private ArticleBodyService articleBodyService;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private TagService tagService;

    @GetMapping("/test")
    @ApiOperation(value = "单独文章首页")
    public String blog(Model model){
        System.out.println("跳转到这了");
        System.out.println("controller跳转！");
        return "main/blog-single-post";
    }

    @GetMapping("getArticleById")
    @ApiOperation(value = "单独文章首页")
    public Result getArticleById(@RequestBody PageAndArticleParam pageAndArticleParam){
        return null;
    }

    @GetMapping("")
    @ApiOperation(value = "跳转到单个文章页面")
    public String redirect(Model model, String id){
        System.out.println(id);
        //article传过去,这边要转换成articleVo
        ArticleVo articleVo= articleForeService.getArticleById(id);
        model.addAttribute("ArticleVo",articleVo);
        System.out.println(articleVo);

        //articleBody
        model.addAttribute("ArticleBody",articleBodyService.getArticleBodyById(articleVo.getBodyId()));

        System.out.println(articleBodyService.getArticleBodyById(articleVo.getBodyId()));
        //tag传过去
        //articleTag
        List<String> articleTags=new ArrayList<>();
        Long articleId=Long.valueOf(id);
        List<ArticleTag> articleTagList= articleTagService.selectArticleTagByArticleId(articleId);
        //有数据才把遍历填入articleTags
        if (articleTagList!=null) {
            for (ArticleTag articleTag : articleTagList) {
                articleTags.add(tagService.getTagNameById(articleTag.getTagId()));
            }
        }
        model.addAttribute("Tags",articleTags);
        System.out.println(articleTags);
        return "main/blog-single-post";
    }


}
