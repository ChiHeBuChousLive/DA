package com.codermy.myspringsecurityplus.fore.entity;

import com.codermy.myspringsecurityplus.admin.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

//资产类型
@Data
@ToString
public class ArticleType extends BaseEntity {

    private Integer typeId;

    private String typeName;

}
