package com.codermy.myspringsecurityplus.admin.dao;

import com.codermy.myspringsecurityplus.fore.entity.ArticleFinancialType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author codermy
 * @createTime 2022/7/24
 */
@Mapper
public interface ArticleFinancialTypeDao {
    /**
     * 模糊查询所有资产类型
     * @return
     */
    List<ArticleFinancialType> getFuzzyFinancialType();


    /**
     * 新增资产类型信息
     * @param financialType 资产类型信息
     * @return 结果
     */
    @Insert("INSERT INTO ms_item_financialType(financialType_name) values(#{financialTypeName})")
    int insertFinancialType(ArticleFinancialType financialType);

    /**
     * 校验资产类型名称
     * @param name 资产类型名称
     * @return 结果
     */
    ArticleFinancialType checkFinancialTypeNameUnique(String name);

    /**
     * 查询所有资产类型
     *
     * @return 资产类型列表
     */
    List<ArticleFinancialType> selectFinancialTypeAll();

    /**
     * 批量删除类型信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteFinancialTypeByIds(Integer[] ids);


    /**
     * 修改类型信息
     *
     * @param financialType 岗位信息
     * @return 结果
     */
    int updateFinancialType(ArticleFinancialType financialType);
    /**
     * 通过id查询类型信息
     * @param financialTypeId
     * @return
     */
    @Select("select t.financialType_id,t.financialType_name from ms_item_financialType t where t.financialType_id = #{financialTypeId}")
    ArticleFinancialType getFinancialTypeById(Integer financialTypeId);


}
