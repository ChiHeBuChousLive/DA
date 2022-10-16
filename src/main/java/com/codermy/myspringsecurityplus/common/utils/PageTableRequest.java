package com.codermy.myspringsecurityplus.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Data
public class PageTableRequest implements Serializable {
    //页数，传进来的是页数
    private Integer page;
    //长度，你要查询几条
    private Integer limit;
    //开始查询的位置，从0开始
    private Integer offset;

    //变一下offset
    public void countOffset(){
        if(null == this.page || null == this.limit){
            this.offset = 0;
            return;
        }
        //开始的等于页数减1*5
        this.offset = (this.page - 1) * limit;
    }

}
