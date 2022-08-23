package com.codermy.myspringsecurityplus.fore.service.impl;

import cn.hutool.core.convert.Convert;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.fore.dao.ArticleTagDao;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class ArticleTagServiceImpl implements ArticleTagService {
    @Autowired
    private ArticleTagDao articleTagDao;
    //插入文章
    @Override
    @Transactional
    public int insertArticleTag(ArticleTag articleTag) {
        return articleTagDao.insertArticleTag(articleTag);
    }

    @Override
    public List<ArticleTag> selectArticleTagAll() {
        return articleTagDao.selectArticleTagAll();
    }

    @Override
    @Transactional
    public int deleteArticleTagByArticleIds(Long[] ids) throws MyException {
        return articleTagDao.deleteArticleTagByArticleIds(ids);
    }

    @Override
    public List<ArticleTag> selectArticleTagByArticleId(Long articleId) {
        return articleTagDao.selectArticleTagByArticleId(articleId);
    }
}
