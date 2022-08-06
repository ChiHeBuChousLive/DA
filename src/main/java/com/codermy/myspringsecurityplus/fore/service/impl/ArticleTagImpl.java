package com.codermy.myspringsecurityplus.fore.service.impl;

import cn.hutool.core.convert.Convert;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.fore.dao.ArticleDao;
import com.codermy.myspringsecurityplus.fore.dao.ArticleTagDao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
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
public class ArticleTagImpl implements ArticleTagService {
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
        return articleTagDao.selectArticleTag();
    }

    @Override
    @Transactional
    public int deleteArticleTagByIds(String ids) throws MyException {
        Integer[] articleTagIds = Convert.toIntArray(ids);
        return articleTagDao.deleteArticleTagByIds(articleTagIds);
    }
}
