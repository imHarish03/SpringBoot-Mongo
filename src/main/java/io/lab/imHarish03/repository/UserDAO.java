package io.lab.imHarish03.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.lab.imHarish03.document.Users;

public interface UserDAO extends MongoRepository<Users, String> {

}
