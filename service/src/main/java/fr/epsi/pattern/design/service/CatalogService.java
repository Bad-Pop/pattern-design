package fr.epsi.pattern.design.service;

import fr.epsi.pattern.design.dao.impl.CatalogDaoImpl;
import fr.epsi.pattern.design.model.Catalog;
import fr.epsi.pattern.design.service.mapper.CatalogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CatalogService {

    @Autowired
    private CatalogDaoImpl catalogDao;

    @Autowired
    private CatalogMapper catalogMapper;

    public void create(Catalog catalog){
        catalogDao.create(catalogMapper.convertModelToPojo(catalog));
    }

    public Catalog getCatalog(String label){
        return catalogMapper.convertPojoToModel(catalogDao.findByLabel(label));
    }

    public void delete(String label){
        catalogDao.delete(label);
    }

    public void update(String label, Catalog catalog){
        catalogDao.update(label, catalogMapper.convertModelToPojo(catalog));
    }

    public Collection<Catalog> getCatalogs(){
        return catalogMapper.convertPojoListToModelList(catalogDao.findAll());
    }

}
