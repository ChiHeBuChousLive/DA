package com.codermy.myspringsecurityplus.fore.service.impl;

import com.codermy.myspringsecurityplus.fore.dao.ArticleBodyDao;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class ArticleBodyServiceImpl implements ArticleBodyService {

    @Autowired
    private ArticleBodyDao articleBodyDao;


    @Override
    @Transactional
    public int insertArticleBody(ArticleBody articleBody) {
        return articleBodyDao.insertArticleBody(articleBody);
    }

    @Override
    public ArticleBody getArticleBodyById(Long articleBodyId) {
        return articleBodyDao.getArticleBodyById(articleBodyId);
    }
}
