package com.codermy.myspringsecurityplus.fore.dao;

import com.codermy.myspringsecurityplus.fore.entity.Article;
import com.codermy.myspringsecurityplus.fore.entity.ArticleBody;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleBodyDao {


    /**
     * 新增文章体信息
     * @param articleBody 文章体信息
     * @return 结果
     */
    int insertArticleBody(ArticleBody articleBody);

    /**
     * 通过id查询文章信息
     * @param bodyId
     * @return
     */
    ArticleBody getArticleBodyById(@Param("bodyId") Long bodyId);

    /**
     * 批量删除文章体信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteArticleBodyByIds(@Param("ids")Long[] ids);

}
