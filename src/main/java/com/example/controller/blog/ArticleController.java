package com.example.controller.blog;

import com.example.domail.blog.Article;
import com.example.domail.common.Label;
import com.example.model.ResultModel;
import com.example.services.blog.ArticleService;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : while
 * @date : 2017/11/17
 * @describe : 文章信息处理器
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResultModel<Article> postArticle(Article article , Label label ){
        ResultModel resultModel = ResultUtil.success();
        if (null != article){
            if ( "".equals(article.getAuthor() ) ){
                //文章作者不能为空
            } else if ( "".equals(article.getParagraphContent() )  ){
                //文章内容不能为空
            } else if( "".equals( article.getTitle() ) ){
                //文章标题不能为空
            } else if(  0 != article.getIsopen() || 1 != article.getIsopen()  ){
                //文章公开状态有误
            } else  {
                article = articleService.postArticle( article ,label );
                logger.info(" article : {} ", article );
                resultModel.setData( article  );
            }
        } else {
            resultModel = ResultUtil.error();
        }
        return  resultModel;
    }


}
