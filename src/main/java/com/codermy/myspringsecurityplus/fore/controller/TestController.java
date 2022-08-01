package com.codermy.myspringsecurityplus.fore.controller;

import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.ArticleTypeService;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    public ArticleTypeService articleTypeService;

    @GetMapping("/1")
    @ResponseBody
    @MyLog("查询资产类型")
    public Result<List<ArticleType>> getTypeAll(){
        List<ArticleType> list = articleTypeService.selectTypeAll();
        return Result.ok().data(list);
    }

}
