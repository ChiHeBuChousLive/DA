package com.codermy.myspringsecurityplus.fore.entity;

import com.codermy.myspringsecurityplus.admin.entity.BaseEntity;
import lombok.Data;

//资产类型
@Data
public class ArticleFinancialType extends BaseEntity {

    private Integer financialTypeId;

    private String financialTypeName;

}
