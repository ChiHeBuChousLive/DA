package com.codermy.myspringsecurityplus.admin.dto;

import lombok.Data;

import java.io.Serializable;

//此类用于mybatis后台的条件模糊查询
/**
 * @author codermy
 * @createTime 2022/8/8
 */
@Data
public class ArticleQueryDto implements Serializable {
    private String title;
    private String authorId;
    private Integer type;
    private Integer locate;
    private Integer financial;
    private Integer weight;

}
