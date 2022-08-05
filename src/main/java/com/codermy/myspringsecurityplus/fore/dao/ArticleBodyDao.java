package com.codermy.myspringsecurityplus.fore.dao;

import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleBodyDao {


    /**
     * 新增文章体信息
     * @param articleBody 文章体信息
     * @return 结果
     */
    int insertArticleBody(ArticleBody articleBody);
}
