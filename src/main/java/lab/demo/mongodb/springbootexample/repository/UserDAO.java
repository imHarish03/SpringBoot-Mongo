package lab.demo.mongodb.springbootexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import lab.demo.mongodb.springbootexample.document.Users;

public interface UserDAO extends MongoRepository<Users, Integer> {

}
