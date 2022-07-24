package com.codermy.myspringsecurityplus.admin.service;

import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.fore.entity.ArticleLocate;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
public interface ArticleLocateService {

    /**
     * 返回类型
     * @param offectPosition
     * @param limit
     * @return
     */
    Result<ArticleLocate> getLocateAll(Integer offectPosition, Integer limit);

    /**
     * 新增类型信息
     * @param locate 类型信息
     * @return 结果
     */
    int insertLocate(ArticleLocate locate);

    /**
     * 校验岗位名称
     *
     * @param locate 类型信息
     * @return 结果
     */
    String checkLocateNameUnique(ArticleLocate locate);

    /**
     * 通过id获得类型信息
     * @param locateId
     * @return
     */
    ArticleLocate getLocateById(Integer locateId);

    /**
     * 批量删除类型信息
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws MyException 异常
     */
    int deleteLocateByIds(String ids) throws MyException;


    /**
     * 查询所有类型
     *
     * @return 类型列表
     */
     List<ArticleLocate> selectLocateAll();


     /**
      * 修改保存类型信息
      *
      * @param locate 类型信息
      * @return 结果
      */
    int updateLocate(ArticleLocate locate);

}
