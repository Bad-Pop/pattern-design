package fr.epsi.pattern.design.dao;

import fr.epsi.pattern.design.dao.pojo.ArticlePojo;

import java.util.Collection;

public interface ArticleDaoInterface {

    void create(ArticlePojo product);
    ArticlePojo findByLabel(String label);
    void delete(String label);
    void update(ArticlePojo article);
    Collection<ArticlePojo> findAll();

}
