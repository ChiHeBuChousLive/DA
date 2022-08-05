package com.codermy.myspringsecurityplus.fore.vo.params;

import com.codermy.myspringsecurityplus.fore.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBody body;

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

    private String preciseLocate;

    private String search;

    //下面的时articleBody的数据
    private String content;

    private String contentHtml;
}
