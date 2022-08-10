package com.codermy.myspringsecurityplus.admin.service.impl;

import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.SecurityUtils;
import com.codermy.myspringsecurityplus.fore.dao.ArticleSaveDao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.admin.service.ArticleSaveService;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import com.codermy.myspringsecurityplus.fore.vo.params.ArticleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class ArticleSaveServiceImpl implements ArticleSaveService {
    @Autowired
    private ArticleSaveDao articleSaveDao;

    //插入文章
    @Override
    @Transactional
    public int insertArticleSave(Article article) {
        return articleSaveDao.insertArticleSave(article);
    }

}
