package com.codermy.myspringsecurityplus.fore.entity;

import com.codermy.myspringsecurityplus.admin.entity.BaseEntity;
import lombok.Data;

//现状
@Data
public class Tag extends BaseEntity {

    private int tagId;

    private String tagName;

}
