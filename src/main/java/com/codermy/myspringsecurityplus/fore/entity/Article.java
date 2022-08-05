package com.codermy.myspringsecurityplus.fore.entity;

import lombok.Data;

@Data
public class Article {
    //是否置顶
    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    //文章id
    private Long id;
    //文章标题
    private String title;
    //文章简介
    private String summary;
    //精准地点
    private String preciseLocate;
    //联系方式
    private String contact;
    //地区
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
    private int typeId;
    /**
     *类型id
     */
    private int tagId;

    /**
     * 财产类型id（）
     */
    private int financialTypeId;
    /**
     *地区id（）
     */
    private int locateId;

    /**
     * 置顶
     */
    private Integer weight;


    /**
     * 创建时间
     */
    private Long createDate;
}
