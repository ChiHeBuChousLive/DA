package com.codermy.myspringsecurityplus.admin.controller.article;


import com.codermy.myspringsecurityplus.admin.service.ArticleFinancialTypeService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.fore.entity.ArticleFinancialType;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 吃喝不愁
 * @createTime 2022/7/19
 */

@Controller
@RequestMapping("/api/article/financialType")
@Api(tags = "系统：财产类型")
public class ArticleFinancialTypeController {

    @Autowired
    private ArticleFinancialTypeService articleFinancialTypeService;

    @GetMapping("/index")
    @ApiOperation(value = "返回财产类型页面")
    public String verify(){
        return "article/financialType/financialType";
    }


    @GetMapping
    @ResponseBody
    @ApiOperation(value = "财产类型列表")
    @MyLog("查询财产类型")
    public Result getFinancialTypeAll(PageTableRequest pageTableRequest){
        pageTableRequest.countOffset();
        return articleFinancialTypeService.getFinancialTypeAll(pageTableRequest.getOffset(),pageTableRequest.getLimit());
    }
    @GetMapping("/test")
    @ResponseBody
    @ApiOperation(value = "财产类型列表")
    @MyLog("查询财产类型")
    public List<ArticleFinancialType> Test(){
        return articleFinancialTypeService.selectFinancialTypeAll();
    }




    @GetMapping("/add")
    @ApiOperation(value = "添加财产类型页面")
    public String addJob(Model model){
        model.addAttribute("ArticleFinancialType",new ArticleFinancialType());
        return "article/financialType/financialType-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加财产类型")
    @MyLog("添加财产类型")
    public Result insertFinancialType(@RequestBody ArticleFinancialType articleFinancialType){
        if (UserConstants.NOT_UNIQUE.equals(articleFinancialTypeService.checkFinancialTypeNameUnique(articleFinancialType))) {
            return Result.error().message("新增财产类型'" + articleFinancialType.getFinancialTypeName() + "'失败，财产类型名称已存在");
        }
        return Result.judge(articleFinancialTypeService.insertFinancialType(articleFinancialType),"添加财产类型");
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改财产类型页面")
    public String editFinancialType(Model model, ArticleFinancialType financialType) {
        //这里转化成Integar，前台和后台的数据结构有点不一样
        model.addAttribute("ArticleFinancialType",articleFinancialTypeService.getFinancialTypeById(financialType.getFinancialTypeId()));
        return "article/financialType/financialType-edit";
    }
    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改财产类型")
    @MyLog("修改财产类型")
    public Result updateFinancialType(@RequestBody ArticleFinancialType financialType){
        if (UserConstants.NOT_UNIQUE.equals(articleFinancialTypeService.checkFinancialTypeNameUnique(financialType))) {
            return Result.error().message("修改财产类型'" + financialType.getFinancialTypeName() + "'失败，财产类型名称已存在");
        }
        return Result.judge(articleFinancialTypeService.updateFinancialType(financialType),"修改财产类型");
    }


    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除财产类型")
    @MyLog("删除财产类型")
    public Result<ArticleFinancialType> deleteFinancialType(String ids) {
        try {
            articleFinancialTypeService.deleteFinancialTypeByIds(ids);
            return Result.ok().message("删除成功");
        }catch (MyException e){
            return Result.error().message(e.getMsg()).code(e.getCode());
        }
    }
//



}
