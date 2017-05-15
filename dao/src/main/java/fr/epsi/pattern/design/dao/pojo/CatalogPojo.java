package fr.epsi.pattern.design.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class CatalogPojo {

    private String label;
    private List<ArticlePojo> articles;

    public CatalogPojo(){
        articles = new ArrayList<ArticlePojo>();
    }

    public CatalogPojo(String label) {
        this.label = label;
        articles = new ArrayList<ArticlePojo>();
    }

    public void addArticlePojo(ArticlePojo article){
        articles.add(article);
    }

    public void addArticlesPojo(List<ArticlePojo> articles){
        this.articles.addAll(articles);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ArticlePojo> getArticlesPojo() {
        return articles;
    }

    public void setArticlesPojo(List<ArticlePojo> articles) {
        this.articles = articles;
    }
}
