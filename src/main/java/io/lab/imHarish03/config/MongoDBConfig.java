package io.lab.imHarish03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.lab.imHarish03.repository.UserDAO;

@EnableMongoRepositories(basePackageClasses = UserDAO.class)
@Configuration
public class MongoDBConfig {

}
