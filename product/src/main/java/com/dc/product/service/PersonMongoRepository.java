package com.dc.product.service;

import com.dc.product.dto.PersonMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonMongoRepository extends MongoRepository<PersonMongo, String> {

    List<PersonMongo> findByName(String name);

    @Query("{'age': ?0}")
    List<PersonMongo> withQueryFindByAge(Integer age);

}
