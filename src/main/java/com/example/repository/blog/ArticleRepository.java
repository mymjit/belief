package com.example.repository.blog;

import com.example.domail.blog.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : while
 * @date : 2017/11/17
 * @describe :
 */
public interface ArticleRepository extends JpaRepository<Article , Long > {

}
