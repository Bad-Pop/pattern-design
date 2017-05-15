package fr.epsi.pattern.design.dao.impl;

import fr.epsi.pattern.design.dao.CatalogDaoInterface;
import fr.epsi.pattern.design.dao.config.MongoConfig;
import fr.epsi.pattern.design.dao.pojo.CatalogPojo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class CatalogDaoImpl implements CatalogDaoInterface {

    private ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    private MongoOperations request = (MongoOperations) ctx.getBean("mongoTemplate");

    public void create(CatalogPojo catalog) {
        request.save(catalog);
    }

    public CatalogPojo findByLabel(String label) {
        return request.findOne(new Query(Criteria.where("label").is(label)), CatalogPojo.class);
    }

    public void delete(String label) {
        request.remove(new Query(Criteria.where("label").is(label)), CatalogPojo.class);
    }

    public void update(String label, CatalogPojo catalog){
        CatalogPojo catalogPojo = request.findOne(new Query(Criteria.where("label").is(label)), CatalogPojo.class);
        catalogPojo.setArticlesPojo(catalog.getArticlesPojo());
        request.save(catalogPojo);
    }

    public Collection<CatalogPojo> findAll() {
        return request.findAll(CatalogPojo.class);
    }
}
