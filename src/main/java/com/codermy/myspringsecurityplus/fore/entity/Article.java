package com.codermy.myspringsecurityplus.fore.entity;

import lombok.Data;

@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private Long id;

    private String title;

    private String summary;


    /**
     * 作者id
     */
    private Long authorId;
    /**
     * 内容id
     */
    private Long bodyId;
    //三类相似单选选项
    /**
     *类别id
     */
    private Long categoryId;
    /**
     *类别id2（）
     */
    private Long financialTypeId;
    /**
     *地区id（）
     */
    private Long locateID;
    /**
     *具体位置（）
     */
    private String preciseLocate;
    /**
     *联系方式（）
     */
    private String contact;
    /**
     *面积（）
     */
    private String area;

    /**
     * 置顶
     */
    private Integer weight;


    /**
     * 创建时间
     */
    private Long createDate;
}
