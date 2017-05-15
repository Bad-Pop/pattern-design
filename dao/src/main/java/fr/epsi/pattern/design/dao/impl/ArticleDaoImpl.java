package fr.epsi.pattern.design.dao.impl;

import fr.epsi.pattern.design.dao.ArticleDaoInterface;
import fr.epsi.pattern.design.dao.config.MongoConfig;
import fr.epsi.pattern.design.dao.pojo.ArticlePojo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class ArticleDaoImpl implements ArticleDaoInterface {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    private MongoOperations request = (MongoOperations) ctx.getBean("mongoTemplate");

    public void create(ArticlePojo article){
        request.save(article);
    }

    public ArticlePojo findByLabel(String label) {
        return request.findOne(new Query(Criteria.where("label").is(label)), ArticlePojo.class);
    }

    public void delete(String label) {
        request.remove(new Query(Criteria.where("label").is(label)), ArticlePojo.class);
    }

    public void update(ArticlePojo article){
        ArticlePojo articlePojo = findByLabel(article.getLabel());
        articlePojo.setType(article.getType());
        articlePojo.setColor(article.getColor());
        articlePojo.setSize(article.getSize());
        request.save(articlePojo);
    }

    public Collection<ArticlePojo> findAll() {
        return request.findAll(ArticlePojo.class);
    }
}
