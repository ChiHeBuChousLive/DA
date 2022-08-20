package com.codermy.myspringsecurityplus.fore.service;

import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;

import java.util.List;

public interface ArticleTagService {
    /**
     * 新增文章标签类型
     *
     * @param articleTag 文章标签信息
     * @return 结果
     */
    int insertArticleTag(ArticleTag articleTag);

    /**
     * 查询所有类型
     *
     * @return 类型列表
     */
    List<ArticleTag> selectArticleTagAll();

    /**
     * 批量删除文章标签信息
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws MyException 异常
     */
    int deleteArticleTagByIds(String ids) throws MyException;

    /**
     * 查询所有与articleId相关的tag
     *
     * @return 类型列表
     */
    List<ArticleTag> selectArticleTagByArticleId(Long articleId);

}
