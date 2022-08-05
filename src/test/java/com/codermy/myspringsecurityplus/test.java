package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.admin.dao.DeptDao;
import com.codermy.myspringsecurityplus.admin.dao.UserDao;
import com.codermy.myspringsecurityplus.admin.dto.DeptDto;
import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.TreeUtil;
import com.codermy.myspringsecurityplus.fore.dao.ArticleDao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/22
 */
@SpringBootTest
public class test {
   @Autowired
    ArticleDao articleDao;

    @Test
    public void a(){

    }
}
