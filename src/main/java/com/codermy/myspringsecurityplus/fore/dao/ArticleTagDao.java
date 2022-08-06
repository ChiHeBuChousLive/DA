package com.codermy.myspringsecurityplus.fore.dao;

import com.codermy.myspringsecurityplus.fore.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleTagDao {


    /**
     * 新增文章和标签信息
     * @param articleTag 文章标签信息
     * @return 结果
     */
    int insertArticleTag(ArticleTag articleTag);

    /**
     * 查询所有文章标签
     *
     * @return 文章标签列表
     */
    List<ArticleTag> selectArticleTag();
    /**
     * 根据文章id批量岗位信息
     *
     * @param articleIds 需要删除的数据ID
     * @return 结果
     */
    int deleteArticleTagByIds(Integer[] articleIds);


}
