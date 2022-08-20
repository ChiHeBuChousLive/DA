package com.codermy.myspringsecurityplus.admin.dto;

import com.codermy.myspringsecurityplus.fore.entity.ArticleFinancialType;
import com.codermy.myspringsecurityplus.fore.entity.ArticleLocate;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;
import lombok.Data;

import java.math.BigInteger;

@Data
public class ArticleDto {
    //文章id
    private String articleId;
    //文章标题
    private String title;
    //作者id
    private Integer authorId;
    //资产类型
    private String type;
    //大体位置
    private String locate;
    //财产类型
    private String financialType;
    //创建时间
    private Long createDate;
    //权重
    private Integer weight;
    //精准地点
    private String preciseLocation;
    //联系方式
    private String contact;
    //面积
    private String area;

}
