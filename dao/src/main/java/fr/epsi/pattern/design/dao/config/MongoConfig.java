package fr.epsi.pattern.design.dao.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    private String HOST = "127.0.0.1";

    @Override
    protected String getDatabaseName() {
        return "pattern-design";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(HOST);
    }
}
