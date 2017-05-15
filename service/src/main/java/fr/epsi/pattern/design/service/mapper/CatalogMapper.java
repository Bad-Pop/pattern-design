package fr.epsi.pattern.design.service.mapper;

import fr.epsi.pattern.design.dao.pojo.CatalogPojo;
import fr.epsi.pattern.design.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CatalogMapper {

    @Autowired
    private ArticleMapper articleMapper;

    public Catalog convertPojoToModel(CatalogPojo pojo){

        Catalog catalog = new Catalog();

        catalog.setLabel(pojo.getLabel());
        catalog.setArticles(articleMapper.convertPojoListToModelList(pojo.getArticlesPojo()));

        return catalog;
    }

    public CatalogPojo convertModelToPojo(Catalog catalog){

        CatalogPojo pojo = new CatalogPojo();

        pojo.setLabel(catalog.getLabel());
        if(!CollectionUtils.isEmpty(catalog.getArticles())){
            pojo.setArticlesPojo(articleMapper.convertModelListToPojoList(catalog.getArticles()));
        }

        return pojo;
    }

    public List<Catalog> convertPojoListToModelList(Collection<CatalogPojo> pojos){

        List<Catalog> catalogs = new ArrayList<Catalog>();

        for(CatalogPojo pojo : pojos){
            catalogs.add(convertPojoToModel(pojo));
        }

        return catalogs;
    }
}
