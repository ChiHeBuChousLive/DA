package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.admin.dto.ArticleDto;
import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.vo.ArticleVo;

import java.util.List;

public interface ArticleService {

    /**
     * 返回文章
     * @param offectPosition
     * @param limit
     * @param articleQueryDto
     * @return
     */
    Result<ArticleDto> getArticleAll(Integer offectPosition, Integer limit, ArticleQueryDto articleQueryDto);

//    /**
//     * 新增文章信息
//     * @param article 文章信息
//     * @return 结果
//     */
//    int insertArticle(Article article);


    /**
     * 通过id获得文章信息
     * @param articleId
     * @return
     */
    Article getArticleById(Long articleId);

    /**
     * 批量删除文章信息
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws MyException 异常
     */
    int deleteArticleByIds(String ids) throws MyException;


    /**
     * 查询所有文章
     *
     * @return 文章列表
     */
    List<Article> selectArticleAll();

        /**
     * 修改文章权重
     * @param article
     * @return
     */
    int changeWeight(Article article);

    //    /**
//     * 根据用户ID查询文章
//     *
//     * @param userId 用户ID
//     * @return 文章列表
//     */
//    List<Article> selectArticlesByUserId(Integer userId);


}
