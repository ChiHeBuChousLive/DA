package com.codermy.myspringsecurityplus.admin.controller.article;

import com.codermy.myspringsecurityplus.admin.entity.MyJob;
import com.codermy.myspringsecurityplus.admin.service.ArticleTypeService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 吃喝不愁
 * @createTime 2022/7/19
 */
@Controller
@RequestMapping("/api/article/type")
@Api(tags = "系统：资产类型")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;


    @GetMapping("/index")
    @ApiOperation(value = "返回资产类型页面")
    public String verify(){
        return "article/type/type";
    }


    @GetMapping
    @ResponseBody
    @ApiOperation(value = "资产类型列表")
    @MyLog("查询资产类型")
    public Result getTypeAll(PageTableRequest pageTableRequest){
        pageTableRequest.countOffset();
        return articleTypeService.getTypeAll(pageTableRequest.getOffset(),pageTableRequest.getLimit());
    }
    @GetMapping("/test")
    @ResponseBody
    @ApiOperation(value = "资产类型列表")
    @MyLog("查询资产类型")
    public List<ArticleType> Test(){
        return articleTypeService.selectTypeAll();
    }




    @GetMapping("/add")
    @ApiOperation(value = "添加资产类型页面")
    public String addJob(Model model){
        model.addAttribute("ArticleType",new ArticleType());
        return "article/type/type-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加资产类型")
    @MyLog("添加资产类型")
    public Result insertType(@RequestBody ArticleType articleType){
        if (UserConstants.NOT_UNIQUE.equals(articleTypeService.checkTypeNameUnique(articleType))) {
            return Result.error().message("新增资产类型'" + articleType.getTypeName() + "'失败，资产类型名称已存在");
        }
        return Result.judge(articleTypeService.insertType(articleType),"添加资产类型");
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改资产类型页面")
    public String editType(Model model, ArticleType type) {
        //这里转化成Integar，前台和后台的数据结构有点不一样
        model.addAttribute("ArticleType",articleTypeService.getTypeById(type.getTypeId().intValue()));
        return "article/type/type-edit";
    }
    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改资产类型")
    @MyLog("修改资产类型")
    public Result updateType(@RequestBody ArticleType type){
        if (UserConstants.NOT_UNIQUE.equals(articleTypeService.checkTypeNameUnique(type))) {
            return Result.error().message("修改资产类型'" + type.getTypeName() + "'失败，资产类型名称已存在");
        }
        return Result.judge(articleTypeService.updateType(type),"修改资产类型");
    }


    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除资产类型")
    @MyLog("删除资产类型")
    public Result<ArticleType> deleteType(String ids) {
        try {
            articleTypeService.deleteTypeByIds(ids);
            return Result.ok().message("删除成功");
        }catch (MyException e){
            return Result.error().message(e.getMsg()).code(e.getCode());
        }
    }
//

}
