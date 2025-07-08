package io.lab.imHarish03.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import io.lab.imHarish03.document.Users;

@Repository
public class UserDAOImpl {

	@Autowired
	MongoTemplate mongoTemplate;

	public void updateUser() {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(1));
			Update update = new Update();
			update.set("name", "Harish");
			update.set("description", "Awesome");

			mongoTemplate.updateFirst(query, update, Users.class);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
