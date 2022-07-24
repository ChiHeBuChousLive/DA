package com.codermy.myspringsecurityplus.admin.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.codermy.myspringsecurityplus.admin.dao.ArticleFinancialTypeDao;
import com.codermy.myspringsecurityplus.admin.service.ArticleFinancialTypeService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.fore.entity.ArticleFinancialType;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/19
 */
@Service
public class ArticleFinancialTypeServiceImpl implements ArticleFinancialTypeService {
    @Autowired
    private ArticleFinancialTypeDao financialTypeDao;



    @Override
    @Transactional
    public Result<ArticleFinancialType> getFinancialTypeAll(Integer offectPosition, Integer limit) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<ArticleFinancialType> fuzzyFinancialType = financialTypeDao.getFuzzyFinancialType();
        return Result.ok().count(page.getTotal()).data(fuzzyFinancialType).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    @Transactional
    public int insertFinancialType(ArticleFinancialType financialType) {
        return financialTypeDao.insertFinancialType(financialType);
    }

    @Override
    @Transactional
    public String checkFinancialTypeNameUnique(ArticleFinancialType financialType) {
        ArticleFinancialType info=financialTypeDao.checkFinancialTypeNameUnique(financialType.getFinancialTypeName());
        if (ObjectUtil.isNotEmpty(info) && !info.getFinancialTypeId().equals (financialType.getFinancialTypeId())){
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;

    }

    @Override
    @Transactional
    public ArticleFinancialType getFinancialTypeById(Integer financialTypeId) {
        return financialTypeDao.getFinancialTypeById(financialTypeId);
    }

    @Override
    @Transactional
    public int deleteFinancialTypeByIds(String ids) throws MyException {
        Integer[] financialTypeIds = Convert.toIntArray(ids);
        return financialTypeDao.deleteFinancialTypeByIds(financialTypeIds);
    }

    @Override
    @Transactional
    public List<ArticleFinancialType> selectFinancialTypeAll() {
        return financialTypeDao.selectFinancialTypeAll();
    }

    @Override
    @Transactional
    public int updateFinancialType(ArticleFinancialType financialType) {
        return financialTypeDao.updateFinancialType(financialType);
    }
}
