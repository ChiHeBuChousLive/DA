package com.codermy.myspringsecurityplus.fore.service;

import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.vo.params.ArticleParam;

public interface ArticleSaveForeService {


    /**
     * 新增文章
     *
     * @param article 文章信息
     * @return 结果
     */
    int insertArticleSave(Article article);

    /**
     * 新增文章到暂存表中（编辑页面用）
     *
     * @param articleParam 文章信息
     * @return 结果
     */
    int publicArticleSave(ArticleParam articleParam);

}
