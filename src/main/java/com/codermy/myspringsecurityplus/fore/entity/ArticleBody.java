package com.codermy.myspringsecurityplus.fore.entity;

import com.codermy.myspringsecurityplus.admin.entity.BaseEntity;
import lombok.Data;

@Data
public class ArticleBody extends BaseEntity {

    private Long bodyId;
    private String content;
    private String contentHtml;
    private Long articleId;
}
