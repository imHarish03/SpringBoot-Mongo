package io.lab.imHarish03.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.lab.imHarish03.document.Users;

@Repository
public interface UserDAO extends MongoRepository<Users, String> {

}
