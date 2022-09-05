package com.codermy.myspringsecurityplus.fore.dao;
import com.codermy.myspringsecurityplus.admin.dto.ArticleQueryDto;
import com.codermy.myspringsecurityplus.admin.entity.MyJob;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ArticleDao {
    /**
     * 模糊查询文章
     * @param articleQueryDto 查询的名称
     * @param
     * @return
     */
    List<Article> getFuzzyArticle(ArticleQueryDto articleQueryDto);

    /**
     * 新增文章信息
     * @param article 文章信息
     * @return 结果
     */
    int insertArticle(Article article);


    /**
     * 通过id查询文章信息
     * @param articleId
     * @return
     */
    Article getArticleById(Long articleId);

    /**
     * 批量删除文章信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteArticleByIds(@Param("ids")Long[] ids);

//    /**
//     * 根据用户ID查询文章
//     *
//     * @param userId 用户ID
//     * @return 文章列表
//     */
//    List<Article> selectArticlesByUserId(Integer userId);

    /**
     * 查询所有文章
     *
     * @return 文章列表
     */
    List<Article> selectArticleAll();

    /**
     * 修改文章信息
     *
     * @param article 文章信息
     * @return 结果
     */
    int updateArticle(Article article);

}
