package com.mongodb.repositories;

import com.mongodb.entities.House;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface HouseRepository extends MongoRepository<House, String> {

    House findByAddress(String address);


}
