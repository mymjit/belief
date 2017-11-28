package com.example.services.blog.impl;

import com.example.domail.blog.Article;
import com.example.domail.common.Label;
import com.example.repository.blog.ArticleRepository;
import com.example.services.blog.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : while
 * @date : 2017/11/17
 * @describe :
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article postArticle(Article article, Label label) {
        article.setState(1);
        article.setCreateTime(new Date());
        return articleRepository.save(article);
    }
}
