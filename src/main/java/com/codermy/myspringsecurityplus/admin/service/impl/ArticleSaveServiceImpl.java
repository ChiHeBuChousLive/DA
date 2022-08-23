package com.codermy.myspringsecurityplus.admin.service.impl;

import cn.hutool.core.convert.Convert;
import com.codermy.myspringsecurityplus.admin.dto.ArticleDto;
import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.admin.service.*;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.fore.dao.ArticleSaveDao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class ArticleSaveServiceImpl implements ArticleSaveService {
    @Autowired
    private ArticleSaveDao articleSaveDao;
    @Autowired
    ArticleTypeService articleTypeService;
    @Autowired
    ArticleFinancialTypeService articleFinancialTypeService;
    @Autowired
    ArticleLocateService articleLocateService;
    @Autowired
    ArticleBodyService articleBodyService;
    @Autowired
    ArticleTagService articleTagService;

    //插入文章
    @Override
    @Transactional
    public int insertArticleSave(Article article) {
        return articleSaveDao.insertArticleSave(article);
    }


    @Override
    public Result<ArticleDto> getArticleSaveAll(Integer offectPosition, Integer limit, ArticleQueryDto articleQueryDto) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<Article> fuzzyArticle = articleSaveDao.getFuzzyArticleSave(articleQueryDto);
        List<ArticleDto> fuzzyArticleDto=new ArrayList<ArticleDto>();
        for (Article article : fuzzyArticle) {
            //相同查询
            //id从long转换成String
            ArticleDto articleDto=new ArticleDto();
            articleDto.setArticleId(String.valueOf(article.getArticleId()));
            articleDto.setTitle(article.getTitle());
            articleDto.setAuthorId(article.getAuthorId());

            articleDto.setCreateDate(article.getCreateDate());
            articleDto.setWeight(article.getWeight());
            articleDto.setPreciseLocation(article.getPreciseLocation());
            articleDto.setContact(article.getContact());
            articleDto.setArea(article.getArea());
            //关联查询
            articleDto.setType(articleTypeService.getTypeById(article.getTypeId()).getTypeName());
            articleDto.setLocate(articleLocateService.getLocateById(article.getLocateId()).getLocateName());
            articleDto.setFinancialType(articleFinancialTypeService.getFinancialTypeById(article.getFinancialTypeId()).getFinancialTypeName());
            fuzzyArticleDto.add(articleDto);

        }

        return Result.ok().count(page.getTotal()).data(fuzzyArticleDto).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    public Article getArticleSaveById(Long articleId) {
            return articleSaveDao.getArticleSaveById(articleId);
    }

    @Override
    public int deleteArticleSaveByIds(String ids) throws MyException {
        Long[] articleIds= Convert.toLongArray(ids);
        Long[] articleBodyIds = new Long[articleIds.length];

        //循环拿到article-id
        for (int i = 0; i < articleIds.length; i++) {
            articleBodyIds[i]=articleSaveDao.getArticleSaveById(articleIds[i]).getBodyId();
        }
        //删除文章体
        articleBodyService.deleteArticleBodyByIds(articleBodyIds);
        //删除article-tag关联表
        articleTagService.deleteArticleTagByArticleIds(articleIds);
        return articleSaveDao.deleteArticleSaveByIds(articleIds);
    }

    @Override
    public List<Article> selectArticleSaveAll() {
            return articleSaveDao.selectArticleSaveAll();
    }

    @Override
    public int changeWeight(Article article) {
            return articleSaveDao.updateArticleSave(article);
    }
}
