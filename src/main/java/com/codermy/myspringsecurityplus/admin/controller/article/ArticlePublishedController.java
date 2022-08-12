package com.codermy.myspringsecurityplus.admin.controller.article;


import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.admin.service.ArticleService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.PageTableRequest;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.log.aop.MyLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(articleQueryDto);
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

//    @GetMapping("/add")
//    @ApiOperation(value = "添加岗位页面")
//    @PreAuthorize("hasAnyAuthority('job:add')")
//    public String addJob(Model model){
//        model.addAttribute("MyJob",new MyJob());
//        return "/system/job/job-add";
//    }

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

//    @GetMapping(value = "/edit")
//    @ApiOperation(value = "修改岗位页面")
//    @PreAuthorize("hasAnyAuthority('job:edit')")
//    public String editRole(Model model, MyJob job) {
//        model.addAttribute("MyJob",jobService.getJobById(job.getJobId()));
//        return "system/job/job-edit";
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
