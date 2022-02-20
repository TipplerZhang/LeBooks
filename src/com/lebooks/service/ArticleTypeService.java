package com.lebooks.service;

import com.lebooks.dao.ArticleTypeDao;
import com.lebooks.entity.ArticleType;

import java.util.List;

public class ArticleTypeService {
    private ArticleTypeDao typeDao = new ArticleTypeDao();

    public List<ArticleType> getAllType() {
        List<ArticleType> types = typeDao.getAllType();
        return types;
    }
}
