package fr.epsi.pattern.design.dao;

import fr.epsi.pattern.design.dao.pojo.CatalogPojo;

import java.util.Collection;

public interface CatalogDaoInterface {

    void create(CatalogPojo catalog);
    CatalogPojo findByLabel(String label);
    void delete(String label);
    void update(String label, CatalogPojo catalog);
    Collection<CatalogPojo> findAll();

}
