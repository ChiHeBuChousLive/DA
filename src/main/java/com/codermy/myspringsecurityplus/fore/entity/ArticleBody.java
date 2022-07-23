package com.codermy.myspringsecurityplus.fore.entity;

import lombok.Data;

@Data
public class ArticleBody {

    private Long bodyId;
    private String content;
    private String contentHtml;
    private Long articleId;
}
