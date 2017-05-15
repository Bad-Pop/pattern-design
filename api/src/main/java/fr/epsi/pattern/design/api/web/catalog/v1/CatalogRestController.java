package fr.epsi.pattern.design.api.web.catalog.v1;

import fr.epsi.pattern.design.model.Catalog;
import fr.epsi.pattern.design.service.CatalogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/catalog")
public class CatalogRestController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping
    public ResponseEntity create(@RequestBody Catalog catalog){

        if(ObjectUtils.isEmpty(catalog)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        catalogService.create(catalog);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{label}")
    public ResponseEntity<Catalog> getCatalog(@PathVariable("label") String label){

        if(StringUtils.isBlank(label)){
            return new ResponseEntity<Catalog>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Catalog>(catalogService.getCatalog(label), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<Catalog>> getCatalogs(){
        return new ResponseEntity<Collection<Catalog>>(catalogService.getCatalogs(), HttpStatus.OK);
    }

    @PutMapping(value = "/{label}")
    public ResponseEntity update(@PathVariable("label") String label, @RequestBody Catalog catalog){

        if(StringUtils.isBlank(label) || ObjectUtils.isEmpty(catalog)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        catalogService.update(label, catalog);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{label}")
    public ResponseEntity delete(@PathVariable("label") String label){

        if(StringUtils.isBlank(label)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        catalogService.delete(label);

        return new ResponseEntity(HttpStatus.OK);
    }
}
