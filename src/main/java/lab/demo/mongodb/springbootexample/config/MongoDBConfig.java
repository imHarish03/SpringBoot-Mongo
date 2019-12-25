package lab.demo.mongodb.springbootexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import lab.demo.mongodb.springbootexample.repository.UserDAO;

@EnableMongoRepositories(basePackageClasses = UserDAO.class)
@Configuration
public class MongoDBConfig {

}
