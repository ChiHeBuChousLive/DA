package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.admin.entity.MyJob;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Mapper
public interface ArticleTypeDao {
    /**
     * 模糊查询所有资产类型
     * @return
     */
    List<ArticleType> getFuzzyType();


    /**
     * 新增资产类型信息
     * @param type 资产类型信息
     * @return 结果
     */
    @Insert("INSERT INTO ms_item_type(type_name) values(#{typeName})")
    int insertType(ArticleType type);

    /**
     * 校验资产类型名称
     * @param name 资产类型名称
     * @return 结果
     */
    ArticleType checkTypeNameUnique(String name);

    /**
     * 查询所有资产类型
     *
     * @return 资产类型列表
     */
    List<ArticleType> selectTypeAll();

    /**
     * 批量删除类型信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTypeByIds(Integer[] ids);


    /**
     * 修改类型信息
     *
     * @param type 岗位信息
     * @return 结果
     */
    int updateType(ArticleType type);
    /**
     * 通过id查询类型信息
     * @param typeId
     * @return
     */
    @Select("select t.type_id,t.type_name from ms_item_type t where t.type_id = #{typeId}")
    ArticleType getTypeById(Integer typeId);


}
