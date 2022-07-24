package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.fore.entity.ArticleLocate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author codermy
 * @createTime 2022/7/24
 */
@Mapper
public interface ArticleLocateDao {
    /**
     * 模糊查询所有资产类型
     * @return
     */
    List<ArticleLocate> getFuzzyLocate();


    /**
     * 新增资产类型信息
     * @param locate 资产类型信息
     * @return 结果
     */
    @Insert("INSERT INTO ms_item_locate(locate_name) values(#{locateName})")
    int insertLocate(ArticleLocate locate);

    /**
     * 校验资产类型名称
     * @param name 资产类型名称
     * @return 结果
     */
    ArticleLocate checkLocateNameUnique(String name);

    /**
     * 查询所有资产类型
     *
     * @return 资产类型列表
     */
    List<ArticleLocate> selectLocateAll();

    /**
     * 批量删除类型信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteLocateByIds(Integer[] ids);


    /**
     * 修改类型信息
     *
     * @param locate 岗位信息
     * @return 结果
     */
    int updateLocate(ArticleLocate locate);
    /**
     * 通过id查询类型信息
     * @param locateId
     * @return
     */
    @Select("select t.locate_id,t.locate_name from ms_item_locate t where t.locate_id = #{locateId}")
    ArticleLocate getLocateById(Integer locateId);


}
