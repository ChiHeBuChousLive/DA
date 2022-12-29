package com.codermy.myspringsecurityplus.fore.service;


import com.codermy.myspringsecurityplus.admin.dto.ArticleDto;
import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.vo.ArticleVo;

public interface ArticleForeService {


    /**
     * 返回文章
     * @param offectPosition
     * @param limit
     * @param articleQueryDto
     * @return
     */
    Result<ArticleVo> getArticleAll(Integer offectPosition, Integer limit, ArticleQueryDto articleQueryDto);


    /**
     * 根据id返回文章
     * @param articleId
     * @return
     */
    ArticleVo getArticleById(String articleId);


}
