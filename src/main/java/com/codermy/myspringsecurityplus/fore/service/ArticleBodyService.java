package com.codermy.myspringsecurityplus.fore.service;

import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;

public interface ArticleBodyService {

    /**
     * 新增文章体类型
     *
     * @param articleBody 文章体信息
     * @return 结果
     */
    int insertArticleBody(ArticleBody articleBody);

    ArticleBody getArticleBodyById(Long articleBodyId);

}
