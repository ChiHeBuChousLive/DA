package com.codermy.myspringsecurityplus.admin.controller.article;


import cn.hutool.core.convert.Convert;
import com.codermy.myspringsecurityplus.admin.dto.ArticleDto;
import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.admin.entity.MyJob;
import com.codermy.myspringsecurityplus.admin.service.ArticleService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import com.codermy.myspringsecurityplus.fore.service.TagService;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吃喝不愁
 * @createTime 2022/7/19
 */
@Controller
@RequestMapping("/api/article/published")
@Api(tags = "系统：文章审核")
public class ArticlePublishedController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleBodyService articleBodyService;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private TagService tagService;

    @GetMapping("/index")
    @ApiOperation(value = "返回已发布文章页面")
    public String published(){
        return "article/published/published";
    }


    @GetMapping
    @ResponseBody
    @ApiOperation(value = "发布文章列表")
    @MyLog("查询已发布文章")
    public Result getArticleAll(PageTableRequest pageTableRequest, ArticleQueryDto articleQueryDto){
        pageTableRequest.countOffset();
        return articleService.getArticleAll(pageTableRequest.getOffset(), pageTableRequest.getLimit(), articleQueryDto);
    }


    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "废除文章")
    public Result<Article> deleteArticle(String ids) {
        try {
            articleService.deleteArticleByIds(ids);
            return Result.ok().message("删除成功");
        }catch (MyException e){
            return Result.error().message(e.getMsg()).code(e.getCode());
        }
    }

    @GetMapping(value = "/content")
    @ApiOperation(value = "具体文章页面")
    public String content(Model model, ArticleDto articleDto) {
       Long articleId = Long.parseLong(articleDto.getArticleId());
       //article传过去,这边要转换成articleDto
       Article article= articleService.getArticleById(articleId);
       //转换成articleDto
       articleDto.setArticleId( String.valueOf(article.getArticleId()));
       articleDto.setWeight(article.getWeight());

       model.addAttribute("ArticleDto",articleDto);
        System.out.println(articleDto);
        //将summary单独传过去吧
        model.addAttribute("summary",article.getSummary());
        //articleBody
        model.addAttribute("ArticleBody",articleBodyService.getArticleBodyById(article.getBodyId()));

        //tag传过去
        //articleTag
        List<String> articleTags=new ArrayList<>();
        List<ArticleTag> articleTagList= articleTagService.selectArticleTagByArticleId(articleId);
        //有数据才把遍历填入articleTags
        if (articleTagList!=null) {
            for (ArticleTag articleTag : articleTagList) {
                articleTags.add(tagService.getTagNameById(articleTag.getTagId()));
            }
        }
        model.addAttribute("Tags",articleTags);
        return "article/published/published-content";
    }

    @GetMapping("/setWeight")
    @ApiOperation(value = "设置权重页面")
    public String addJob(Model model,String ids){

//        model.addAttribute("MyJob",new MyJob());
        return "article/published/published-setWeight";
    }

    //单个修改文章权重
    /**
     * 用户状态修改
     */
    @MyLog("修改文章权重")
    @PutMapping("/changeWeight")
    @ResponseBody
    @ApiOperation(value = "修改文章权重")
    public Result changeWeight(@RequestBody ArticleDto articleDto)
    {
        Article article=new Article();
        article.setArticleId(Convert.toLong(articleDto.getArticleId()));
        article.setWeight(articleDto.getWeight());
        int i=articleService.changeWeight(article);
        return Result.judge(i,"修改");
    }


//    @PostMapping
//    @ResponseBody
//    @ApiOperation(value = "添加岗位")
//    @PreAuthorize("hasAnyAuthority('job:add')")
//    @MyLog("添加岗位")
//    public Result saveJob(@RequestBody MyJob myJob){
//        if (UserConstants.JOB_NAME_NOT_UNIQUE.equals(jobService.checkJobNameUnique(myJob))) {
//            return Result.error().message("新增岗位'" + myJob.getJobName() + "'失败，岗位名称已存在");
//        }
//        return Result.judge(jobService.insertJob(myJob),"添加岗位");
//    }


//    @PutMapping
//    @ResponseBody
//    @ApiOperation(value = "修改岗位")
//    @PreAuthorize("hasAnyAuthority('job:edit')")
//    @MyLog("修改岗位")
//    public Result updateJob(@RequestBody MyJob myJob){
//        if (UserConstants.JOB_NAME_NOT_UNIQUE.equals(jobService.checkJobNameUnique(myJob))) {
//            return Result.error().message("修改岗位'" + myJob.getJobName() + "'失败，岗位名称已存在");
//        }
//        return Result.judge(jobService.updateJob(myJob),"修改岗位");
//    }
//    /**
//     * 用户状态修改
//     */
//    @MyLog("修改岗位状态")
//    @PutMapping("/changeStatus")
//    @ResponseBody
//    @ApiOperation(value = "修改岗位状态")
//    @PreAuthorize("hasAnyAuthority('job:edit')")
//    public Result changeStatus(@RequestBody MyJob myJob)
//    {
//        int i = jobService.changeStatus(myJob);
//        return Result.judge(i,"修改");
//    }


}
