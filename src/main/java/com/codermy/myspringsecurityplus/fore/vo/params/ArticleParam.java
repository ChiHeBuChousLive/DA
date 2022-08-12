package com.codermy.myspringsecurityplus.fore.vo.params;

import lombok.Data;


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
