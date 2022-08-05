package com.codermy.myspringsecurityplus.fore.dao;
import com.codermy.myspringsecurityplus.fore.entity.Article;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface ArticleDao {
//    /**
//     * 模糊查询文章
//     * @param article 查询参数
//     * @return
//     */
//    List<Article> getFuzzyArticle(Article article);

    /**
     * 新增文章信息
     * @param article 文章信息
     * @return 结果
     */
    int insertArticle(Article article);

//
//    /**
//     * 校验文章名称
//     * @param name 文章名称
//     * @return 结果
//     */
//    Article checkArticleNameUnique(String name);
//    /**
//     * 通过id查询文章信息
//     * @param articleId
//     * @return
//     */
//    Article getArticleById(Integer articleId);
//
//    /**
//     * 批量删除文章信息
//     *
//     * @param ids 需要删除的数据ID
//     * @return 结果
//     */
//    int deleteArticleByIds(Integer[] ids);
//
//    /**
//     * 根据用户ID查询文章
//     *
//     * @param userId 用户ID
//     * @return 文章列表
//     */
//    List<Article> selectArticlesByUserId(Integer userId);
//
//    /**
//     * 查询所有文章
//     *
//     * @return 文章列表
//     */
//    List<Article> selectArticleAll();
//
//    /**
//     * 修改文章信息
//     *
//     * @param Article 文章信息
//     * @return 结果
//     */
//    int updateArticle(Article Article);

}
