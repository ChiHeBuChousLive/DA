package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.vo.params.ArticleParam;

public interface ArticleSaveService {


    /**
     * 新增文章
     *
     * @param article 文章信息
     * @return 结果
     */
    int insertArticleSave(Article article);

}
