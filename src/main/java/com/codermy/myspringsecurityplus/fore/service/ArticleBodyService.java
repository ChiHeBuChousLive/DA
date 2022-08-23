package com.codermy.myspringsecurityplus.fore.service;

import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
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

    /**
     * 批量删除文章体信息
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws MyException 异常
     */
    int deleteArticleBodyByIds(Long[] ids) throws MyException;

}
