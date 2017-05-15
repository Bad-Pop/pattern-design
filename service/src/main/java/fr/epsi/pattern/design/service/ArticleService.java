package fr.epsi.pattern.design.service;

import fr.epsi.pattern.design.dao.impl.ArticleDaoImpl;
import fr.epsi.pattern.design.model.Article;
import fr.epsi.pattern.design.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArticleService{

    @Autowired
    private ArticleDaoImpl articleDao;

    @Autowired
    private ArticleMapper articleMapper;

    public void create(Article article){
        articleDao.create(articleMapper.convertModelToPojo(article));
    }

    public Article getArticle(String label){
        return articleMapper.convertPojoToModel(articleDao.findByLabel(label));
    }

    public void delete(String label){
        articleDao.delete(label);
    }

    public void update(Article article){
        articleDao.update(articleMapper.convertModelToPojo(article));
    }

    public Collection<Article> getArticles(){
        return articleMapper.convertPojoListToModelList(articleDao.findAll());
    }
}
