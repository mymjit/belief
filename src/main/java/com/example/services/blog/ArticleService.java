package com.example.services.blog;

import com.example.domail.blog.Article;
import com.example.domail.common.Label;

/**
 * @author : while
 * @date : 2017/11/17
 * @describe :
 */
public interface ArticleService {

    Article postArticle(Article article, Label label);
}
