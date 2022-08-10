package com.codermy.myspringsecurityplus.fore.entity;

import com.codermy.myspringsecurityplus.admin.entity.BaseEntity;
import lombok.Data;

//状态
@Data
public class ArticleTag extends BaseEntity {

    private Long id;

    private Long articleId;

    private int tagId;
}
