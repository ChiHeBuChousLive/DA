package com.codermy.myspringsecurityplus.admin.controller.article;

import com.codermy.myspringsecurityplus.admin.service.ArticleLocateService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.fore.entity.ArticleLocate;
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
@RequestMapping("/api/article/locate")
@Api(tags = "系统：地区类型")
public class ArticleLocateController {

    @Autowired
    private ArticleLocateService articleLocateService;


    @GetMapping("/index")
    @ApiOperation(value = "返回地区页面")
    public String verify(){
        return "article/locate/locate";
    }


    @GetMapping
    @ResponseBody
    @ApiOperation(value = "地区类型列表")
    @MyLog("查询地区类型")
    public Result getLocateAll(PageTableRequest pageTableRequest){
        pageTableRequest.countOffset();
        return articleLocateService.getLocateAll(pageTableRequest.getOffset(),pageTableRequest.getLimit());
    }
    @GetMapping("/test")
    @ResponseBody
    @ApiOperation(value = "地区类型列表")
    @MyLog("查询地区类型")
    public List<ArticleLocate> Test(){
        return articleLocateService.selectLocateAll();
    }




    @GetMapping("/add")
    @ApiOperation(value = "添加地区类型页面")
    public String addJob(Model model){
        model.addAttribute("ArticleLocate",new ArticleLocate());
        return "article/locate/locate-add";
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "添加地区类型")
    @MyLog("添加地区类型")
    public Result insertLocate(@RequestBody ArticleLocate articleLocate){
        if (UserConstants.NOT_UNIQUE.equals(articleLocateService.checkLocateNameUnique(articleLocate))) {
            return Result.error().message("新增地区类型'" + articleLocate.getLocateName() + "'失败，地区类型名称已存在");
        }
        return Result.judge(articleLocateService.insertLocate(articleLocate),"添加地区类型");
    }

    @GetMapping(value = "/edit")
    @ApiOperation(value = "修改地区类型页面")
    public String editLocate(Model model, ArticleLocate locate) {
        //这里转化成Integar，前台和后台的数据结构有点不一样
        model.addAttribute("ArticleLocate",articleLocateService.getLocateById(locate.getLocateId()));
        return "article/locate/locate-edit";
    }
    @PutMapping
    @ResponseBody
    @ApiOperation(value = "修改地区类型")
    @MyLog("修改地区类型")
    public Result updateLocate(@RequestBody ArticleLocate locate){
        if (UserConstants.NOT_UNIQUE.equals(articleLocateService.checkLocateNameUnique(locate))) {
            return Result.error().message("修改地区类型'" + locate.getLocateName() + "'失败，地区类型名称已存在");
        }
        return Result.judge(articleLocateService.updateLocate(locate),"修改地区类型");
    }


    @DeleteMapping
    @ResponseBody
    @ApiOperation(value = "删除地区类型")
    @MyLog("删除地区类型")
    public Result<ArticleLocate> deleteLocate(String ids) {
        try {
            articleLocateService.deleteLocateByIds(ids);
            return Result.ok().message("删除成功");
        }catch (MyException e){
            return Result.error().message(e.getMsg()).code(e.getCode());
        }
    }
//

}
