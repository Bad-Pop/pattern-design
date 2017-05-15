package fr.epsi.pattern.design.api.web.article.v1;

import fr.epsi.pattern.design.model.Article;
import fr.epsi.pattern.design.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/article")
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity create(@RequestBody Article article){

        if(ObjectUtils.isEmpty(article)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        articleService.create(article);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{label}")
    public ResponseEntity<Article> getArticle(@PathVariable("label") String label){

        if(StringUtils.isBlank(label)){
            return new ResponseEntity<Article>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Article>(articleService.getArticle(label), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<Article>> getArticles(){

        Collection<Article> articles = articleService.getArticles();

        if(CollectionUtils.isEmpty(articles)){
            return new ResponseEntity<Collection<Article>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Collection<Article>>(articles, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Article article){

        if(ObjectUtils.isEmpty(article)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        articleService.update(article);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{label}")
    public ResponseEntity delete(@PathVariable("label") String label){

        if(StringUtils.isBlank(label)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        articleService.delete(label);

        return new ResponseEntity(HttpStatus.OK);
    }

}
