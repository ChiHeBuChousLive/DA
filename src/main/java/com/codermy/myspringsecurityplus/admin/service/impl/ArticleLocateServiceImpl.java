package com.codermy.myspringsecurityplus.admin.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.codermy.myspringsecurityplus.admin.dao.ArticleLocateDao;
import com.codermy.myspringsecurityplus.admin.service.ArticleLocateService;
import com.codermy.myspringsecurityplus.common.exceptionhandler.MyException;
import com.codermy.myspringsecurityplus.common.utils.Result;
import com.codermy.myspringsecurityplus.common.utils.ResultCode;
import com.codermy.myspringsecurityplus.common.utils.UserConstants;
import com.codermy.myspringsecurityplus.fore.entity.ArticleLocate;
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
public class ArticleLocateServiceImpl implements ArticleLocateService {
    @Autowired
    private ArticleLocateDao locateDao;



    @Override
    @Transactional
    public Result<ArticleLocate> getLocateAll(Integer offectPosition, Integer limit) {
        Page page = PageHelper.offsetPage(offectPosition,limit);
        List<ArticleLocate> fuzzyLocate = locateDao.getFuzzyLocate();
        return Result.ok().count(page.getTotal()).data(fuzzyLocate).code(ResultCode.TABLE_SUCCESS);
    }

    @Override
    @Transactional
    public int insertLocate(ArticleLocate locate) {
        return locateDao.insertLocate(locate);
    }

    @Override
    @Transactional
    public String checkLocateNameUnique(ArticleLocate locate) {
        ArticleLocate info=locateDao.checkLocateNameUnique(locate.getLocateName());
        if (ObjectUtil.isNotEmpty(info) && !info.getLocateId().equals (locate.getLocateId())){
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;

    }

    @Override
    @Transactional
    public ArticleLocate getLocateById(Integer locateId) {
        return locateDao.getLocateById(locateId);
    }

    @Override
    @Transactional
    public int deleteLocateByIds(String ids) throws MyException {
        Integer[] locateIds = Convert.toIntArray(ids);
        return locateDao.deleteLocateByIds(locateIds);
    }

    @Override
    @Transactional
    public List<ArticleLocate> selectLocateAll() {
        return locateDao.selectLocateAll();
    }

    @Override
    @Transactional
    public int updateLocate(ArticleLocate locate) {
        return locateDao.updateLocate(locate);
    }
}
