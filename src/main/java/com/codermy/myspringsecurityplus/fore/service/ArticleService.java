package com.codermy.myspringsecurityplus.fore.service;

import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;

public interface ArticleService {


    /**
     * 新增文章类型
     *
     * @param article 文章信息
     * @return 结果
     */
    int insertArticle(Article article);

}
