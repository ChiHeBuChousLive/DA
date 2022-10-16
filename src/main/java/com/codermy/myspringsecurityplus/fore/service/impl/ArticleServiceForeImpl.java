package com.codermy.myspringsecurityplus.fore.service.impl;


import com.codermy.myspringsecurityplus.admin.dto.ArticleDto;
import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.admin.service.ArticleFinancialTypeService;
import com.codermy.myspringsecurityplus.admin.service.ArticleLocateService;
import com.codermy.myspringsecurityplus.admin.service.ArticleTypeService;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.fore.dao.ArticleDao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.service.ArticleForeService;
import com.codermy.myspringsecurityplus.fore.vo.ArticleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class ArticleServiceForeImpl implements ArticleForeService {
    @Autowired
    ArticleDao articleDao;
    @Autowired
    ArticleTypeService articleTypeService;
    @Autowired
    ArticleLocateService articleLocateService;
    @Autowired
    ArticleFinancialTypeService articleFinancialTypeService;

    @Override
    public Result<ArticleVo> getArticleAll(Integer offectPosition, Integer limit, ArticleQueryDto articleQueryDto) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        //模糊查询，没有参数就查询全部
        List<Article> fuzzyArticle = articleDao.getFuzzyArticle(articleQueryDto);
        List<ArticleVo> articleVos=new ArrayList<ArticleVo>();
        for (Article article : fuzzyArticle) {
            //相同查询
            ArticleVo articleVo=new ArticleVo();
            articleVo.setId(article.getArticleId());
            articleVo.setTitle(article.getTitle());
            articleVo.setAuthorId(article.getAuthorId());

            articleVo.setSummary(article.getSummary());
            articleVo.setCreateDate(article.getCreateDate());
            articleVo.setWeight(article.getWeight());
            articleVo.setPreciseLocation(article.getPreciseLocation());
            articleVo.setContact(article.getContact());
            articleVo.setArea(article.getArea());
            //关联查询
            articleVo.setType(articleTypeService.getTypeById(article.getTypeId()).getTypeName());
            articleVo.setLocate(articleLocateService.getLocateById(article.getLocateId()).getLocateName());
            articleVo.setFinancialType(articleFinancialTypeService.getFinancialTypeById(article.getFinancialTypeId()).getFinancialTypeName());
            articleVos.add(articleVo);

        }
        return Result.ok().count(page.getTotal()).data(articleVos).code(ResultCode.TABLE_SUCCESS);
    }
}
