package fr.epsi.pattern.design.model;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private String label;
    private List<Article> articles;

    public Catalog(){
        articles = new ArrayList<Article>();
    }

    public Catalog(String label) {
        this.label = label;
        articles = new ArrayList<Article>();
    }

    public void addArticle(Article article){
        articles.add(article);
    }

    public void addArticles(List<Article> products){
        this.articles.addAll(products);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
