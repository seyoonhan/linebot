package com.linebot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by han on 2016. 4. 14..
 */
@Configuration
@EnableMongoRepositories("com.linebot")
public class SpringMongoConfig extends AbstractMongoConfiguration {

    private String host = "10.113.247.117";
    private String port = "27017";
    private String database = "linebot";

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(host + ":" + port);
    }
}
