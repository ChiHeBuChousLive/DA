package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.ArticleFinancialType;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
public interface ArticleFinancialTypeService {

    /**
     * 返回类型
     * @param offectPosition
     * @param limit
     * @return
     */
    Result<ArticleFinancialType> getFinancialTypeAll(Integer offectPosition, Integer limit);

    /**
     * 新增类型信息
     * @param financialType 类型信息
     * @return 结果
     */
    int insertFinancialType(ArticleFinancialType financialType);

    /**
     * 校验岗位名称
     *
     * @param financialType 类型信息
     * @return 结果
     */
    String checkFinancialTypeNameUnique(ArticleFinancialType financialType);

    /**
     * 通过id获得类型信息
     * @param financialTypeId
     * @return
     */
    ArticleFinancialType getFinancialTypeById(Integer financialTypeId);

    /**
     * 批量删除类型信息
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws MyException 异常
     */
    int deleteFinancialTypeByIds(String ids) throws MyException;


    /**
     * 查询所有类型
     *
     * @return 类型列表
     */
     List<ArticleFinancialType> selectFinancialTypeAll();


     /**
      * 修改保存类型信息
      *
      * @param financialType 类型信息
      * @return 结果
      */
    int updateFinancialType(ArticleFinancialType financialType);

}
