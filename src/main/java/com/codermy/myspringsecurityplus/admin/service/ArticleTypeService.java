package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;


import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
public interface ArticleTypeService {

    /**
     * 返回类型
     * @param offectPosition
     * @param limit
     * @return
     */
    Result<ArticleType> getTypeAll(Integer offectPosition, Integer limit);

    /**
     * 新增类型信息
     * @param type 类型信息
     * @return 结果
     */
    int insertType(ArticleType type);

    /**
     * 校验岗位名称
     *
     * @param type 类型信息
     * @return 结果
     */
    String checkTypeNameUnique(ArticleType type);

    /**
     * 通过id获得类型信息
     * @param typeId
     * @return
     */
    ArticleType getTypeById(Integer typeId);

    /**
     * 批量删除类型信息
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws MyException 异常
     */
    int deleteTypeByIds(String ids) throws MyException;


    /**
     * 查询所有类型
     *
     * @return 类型列表
     */
     List<ArticleType> selectTypeAll();


     /**
      * 修改保存类型信息
      *
      * @param type 类型信息
      * @return 结果
      */
    int updateType(ArticleType type);

}
