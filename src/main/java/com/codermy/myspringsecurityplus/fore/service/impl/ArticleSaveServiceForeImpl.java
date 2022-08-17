package com.codermy.myspringsecurityplus.fore.service.impl;

import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.SecurityUtils;
import com.codermy.myspringsecurityplus.fore.dao.ArticleSaveDao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.fore.service.ArticleSaveForeService;
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
public class ArticleSaveServiceForeImpl implements ArticleSaveForeService {
    @Autowired
    private ArticleSaveDao articleSaveDao;
    @Autowired
    private ArticleBodyService articleBodyService;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private UserService userService;

    //插入文章
    @Override
    @Transactional
    public int insertArticleSave(Article article) {
        return articleSaveDao.insertArticleSave(article);
    }

    @Override
    @Transactional
    public int publicArticleSave(ArticleParam articleParam) {

        if (articleParam.getContent().length()<=50){
            return 0;
        };
        //articleBody添加
        //注意！我们在articleBody的mapper里设置了添加完成后自动设置uuid和返回
        //主键id的配置useGeneratedKeys="true" keyProperty="id"
        //插入后直接用get方法直接拿到bodyid,要不然是null
        ArticleBody articleBody=new ArticleBody();

        articleBody.setContent(articleParam.getContent());
        articleBody.setContentHtml(articleParam.getContentHtml());

        articleBodyService.insertArticleBody(articleBody);

        //article添加
        Article article=new Article();
        //id在插入数据库的时候自己添加
        article.setTitle(articleParam.getTitle());
        article.setSummary(articleParam.getSummary());
        article.setPreciseLocation(articleParam.getPreciseLocation());
        article.setContact(articleParam.getContact());
        article.setArea(articleParam.getArea());
        //article.setAuthorId();
        //注意！这里的getBodyID在mybatis自动插入回调了
        article.setBodyId(articleBody.getBodyId());
        article.setTypeId(articleParam.getType());
        article.setFinancialTypeId(articleParam.getFinancialType());
        article.setLocateId(articleParam.getLocate());
        article.setWeight(1);
        //creatdate插入数据库的时候加的了
        //获得当前用户信息
        MyUser myUser=userService.getUserByName(SecurityUtils.getCurrentUsername());
        article.setAuthorId(myUser.getUserId());

        articleSaveDao.insertArticleSave(article);
        //tag
        int[] tags=articleParam.getTags();

        ArticleTag articleTag=new ArticleTag();
        for (int tag : tags) {
            articleTag.setArticleId(article.getArticleId());
            articleTag.setTagId(tag);
            articleTagService.insertArticleTag(articleTag);
        }
        return 1;
    }
}
