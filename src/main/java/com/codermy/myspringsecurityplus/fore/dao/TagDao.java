package com.codermy.myspringsecurityplus.fore.dao;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TagDao {
    /**
     * 根据tagId查询所有的tag名称
     *  @param tagId 标签id
     * @return 标签列表
     */
    String getTagNameById(Integer tagId);

}
