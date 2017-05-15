package fr.epsi.pattern.design.service.mapper;

import fr.epsi.pattern.design.dao.pojo.ArticlePojo;
import fr.epsi.pattern.design.model.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ArticleMapper {

    public Article convertPojoToModel(ArticlePojo pojo) {

        Article article = new Article();

        article.setLabel(pojo.getLabel());
        article.setType(pojo.getType());
        article.setColor(pojo.getColor());
        article.setSize(pojo.getSize());

        return article;
    }

    public ArticlePojo convertModelToPojo(Article article){

        ArticlePojo pojo = new ArticlePojo();

        pojo.setLabel(article.getLabel());
        pojo.setType(article.getType());
        pojo.setColor(article.getColor());
        pojo.setSize(article.getSize());

        return pojo;

    }

    public List<Article> convertPojoListToModelList(Collection<ArticlePojo> pojos){

        List<Article> articles = new ArrayList<Article>();

        for(ArticlePojo pojo: pojos){
            articles.add(convertPojoToModel(pojo));
        }

        return articles;
    }

    public List<ArticlePojo> convertModelListToPojoList(Collection<Article> articles){

        List<ArticlePojo> pojos = new ArrayList<ArticlePojo>();

        for(Article article : articles){
            pojos.add(convertModelToPojo(article));
        }

        return pojos;
    }
}
