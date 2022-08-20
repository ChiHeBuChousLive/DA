package com.codermy.myspringsecurityplus.fore.service.impl;

import com.codermy.myspringsecurityplus.fore.dao.TagDao;
import com.codermy.myspringsecurityplus.fore.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public String getTagNameById(Integer tagId) {
        return tagDao.getTagNameById(tagId);
    }
}
