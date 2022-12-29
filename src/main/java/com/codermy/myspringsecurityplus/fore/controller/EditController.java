package com.codermy.myspringsecurityplus.fore.controller;

import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.service.ArticleSaveForeService;
import com.codermy.myspringsecurityplus.fore.vo.params.ArticleParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("main/edit")
public class EditController {
    @Autowired
    private ArticleSaveForeService articleSaveForeService;


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
    public Result postArticle(@RequestBody ArticleParam articleParam){
        int verify= articleSaveForeService.publicArticleSave(articleParam);
        if(verify==0){
            return Result.error().message("文章内容太短！");
        }
        return Result.ok().message("发布成功！");
    }


    @PostMapping("/test")
    @ResponseBody
    public Result currentUserName(@RequestBody ArticleParam articleParam) {
        int verify=articleSaveForeService.publicArticleSave(articleParam);
        if(verify==0){
            return Result.error().message("文章内容太短！");
        }
        return Result.ok().message("文章发布成功！");
    }
}
