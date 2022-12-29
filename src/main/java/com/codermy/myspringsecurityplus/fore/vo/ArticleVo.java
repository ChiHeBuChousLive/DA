package com.codermy.myspringsecurityplus.fore.vo;

import com.codermy.myspringsecurityplus.fore.entity.ArticleFinancialType;
import com.codermy.myspringsecurityplus.fore.entity.ArticleLocate;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ArticleVo {
    //文章id
    //这个注解解决了Long传到前端数据丢失的问题
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    //文章标题
    private String title;
    //文章简介
    private String summary;
    //精准地点
    private String preciseLocation;
    //联系方式
    private String contact;
    //面积
    private String area;


    //下面的是关联查询的内容
    /**
     * 作者id
     */
    private Integer authorId;
    /**
     * 内容id
     */
    private Long bodyId;
    //三类相似单选选项
    /**
     *类型id
     */
    private String type;

    /**
     * 财产类型id（）
     */
    private String financialType;
    /**
     *地区id（）
     */
    private String locate;

    /**
     * 置顶
     */
    private Integer weight;


    /**
     * 创建时间
     */
    private Long createDate;
}
