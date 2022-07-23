package com.codermy.myspringsecurityplus.admin.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.codermy.myspringsecurityplus.admin.dao.ArticleTypeDao;
import com.codermy.myspringsecurityplus.admin.entity.MyJob;
import com.codermy.myspringsecurityplus.admin.service.ArticleTypeService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.fore.entity.ArticleType;
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
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeDao typeDao;



    @Override
    @Transactional
    public Result<ArticleType> getTypeAll(Integer offectPosition, Integer limit) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<ArticleType> fuzzyType = typeDao.getFuzzyType();
        return Result.ok().count(page.getTotal()).data(fuzzyType).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    @Transactional
    public int insertType(ArticleType type) {
        return typeDao.insertType(type);
    }

    @Override
    @Transactional
    public String checkTypeNameUnique(ArticleType type) {
        ArticleType info=typeDao.checkTypeNameUnique(type.getTypeName());
        if (ObjectUtil.isNotEmpty(info) && !info.getTypeId().equals (type.getTypeId())){
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;

    }

    @Override
    @Transactional
    public ArticleType getTypeById(Integer typeId) {
        return typeDao.getTypeById(typeId);
    }

    @Override
    @Transactional
    public int deleteTypeByIds(String ids) throws MyException {
        Integer[] typeIds = Convert.toIntArray(ids);
        return typeDao.deleteTypeByIds(typeIds);
    }

    @Override
    @Transactional
    public List<ArticleType> selectTypeAll() {
        return typeDao.selectTypeAll();
    }

    @Override
    @Transactional
    public int updateType(ArticleType type) {
        return typeDao.updateType(type);
    }
}
