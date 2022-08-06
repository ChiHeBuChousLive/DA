package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.SecurityUtils;
import com.codermy.myspringsecurityplus.fore.dao.ArticleDao;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import com.codermy.myspringsecurityplus.fore.service.ArticleBodyService;
import com.codermy.myspringsecurityplus.fore.service.ArticleTagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



/**
 * @author codermy
 * @createTime 2020/8/22
 */
@SpringBootTest
public class test {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleBodyService articleBodyService;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private UserService userService;
    @Test
    public void a(){
        ArticleTag articleTag=new ArticleTag();

        int[] tags = new int[]{1,2,3,4};

        for (int tag : tags) {
            articleTag.setTagId(tag);
            articleTagService.insertArticleTag(articleTag);
        }
    }
}
