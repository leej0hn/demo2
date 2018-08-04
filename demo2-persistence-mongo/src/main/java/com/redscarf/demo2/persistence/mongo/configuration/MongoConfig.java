package com.redscarf.demo2.persistence.mongo.configuration;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.util.StringUtils;
import static java.util.Collections.singletonList;

/**
 * <p>function:
 * <p>User: LeeJohn
 * <p>Date: 2017/6/24
 * <p>Version: 1.0
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    private MongoProperties mongoProperties;

    @Autowired
    private ApplicationContext appContext;

    @Override
    protected String getDatabaseName() {
        return mongoProperties.getDatabase();
    }


    @Override
    @Bean
    public MongoClient mongoClient() {
        if( StringUtils.hasLength(mongoProperties.getUsername()) && !StringUtils.isEmpty(mongoProperties.getPassword()) ){
            return new MongoClient(singletonList(new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort())),
                    MongoCredential.createCredential(mongoProperties.getUsername(), mongoProperties.getDatabase(), mongoProperties.getPassword()),
                    MongoClientOptions.builder().build());
        }else {
            return new MongoClient(mongoProperties.getHost(), mongoProperties.getPort());
        }
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoDbFactory factory = mongoDbFactory();
        MongoMappingContext mongoMappingContext = new MongoMappingContext();
        mongoMappingContext.setApplicationContext(appContext);
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory), mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(factory, converter);
    }

}
