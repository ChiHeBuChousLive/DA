package com.codermy.myspringsecurityplus.fore.entity;

import com.codermy.myspringsecurityplus.admin.entity.BaseEntity;
import lombok.Data;

//资产类型
@Data
public class ArticleLocate extends BaseEntity {

    private Integer locateId;

    private String locateName;

}
