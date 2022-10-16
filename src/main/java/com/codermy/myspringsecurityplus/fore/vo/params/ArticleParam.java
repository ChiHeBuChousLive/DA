package com.codermy.myspringsecurityplus.fore.vo.params;

import lombok.Data;


//信息数据库页面返回前端所使用的实体类（因为要有content）而之前用的没有
@Data
public class ArticleParam {

    private Long id;

    //三个单选框
    private int type;

    private int locate;

    private int financialType;

    //输入框
    private String summary;

    private int[] tags;

    private String title;

    private String contact;

    private String area;

    private String preciseLocation;

    //private String search;

    //下面的是articleBody的数据
    private String content;

    private String contentHtml;
}
