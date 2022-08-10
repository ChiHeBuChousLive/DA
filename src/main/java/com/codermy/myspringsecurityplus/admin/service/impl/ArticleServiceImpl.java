package com.codermy.myspringsecurityplus.admin.service.impl;

import cn.hutool.core.convert.Convert;
import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.fore.dao.ArticleDao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.admin.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public Result<Article> getArticleAll(Integer offectPosition, Integer limit, ArticleQueryDto articleQueryDto) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<Article> fuzzyArticle = articleDao.getFuzzyArticle(articleQueryDto);
        return Result.ok().count(page.getTotal()).data(fuzzyArticle).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public int insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public int deleteArticleByIds(String ids) throws MyException {
        Integer[] articleIds = Convert.toIntArray(ids);
        return articleDao.deleteArticleByIds(articleIds);
    }

    @Override
    public List<Article> selectArticleAll() {
        return articleDao.selectArticleAll();
    }
}
