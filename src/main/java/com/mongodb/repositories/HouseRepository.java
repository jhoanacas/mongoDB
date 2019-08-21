package com.mongodb.repositories;

import com.mongodb.entities.House;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface HouseRepository extends MongoRepository<House, String> {

    House findByAddress(String address);


}
