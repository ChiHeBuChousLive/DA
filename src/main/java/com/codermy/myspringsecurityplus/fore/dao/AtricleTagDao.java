package com.codermy.myspringsecurityplus.fore.dao;

import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AtricleTagDao {


    /**
     * 新增文章和标签信息
     * @param articleTag 文章标签信息
     * @return 结果
     */
    int insertArticleTag(ArticleTag articleTag);

}
