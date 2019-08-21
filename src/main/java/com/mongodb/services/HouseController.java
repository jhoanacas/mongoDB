package com.mongodb.services;

import com.mongodb.entities.House;
import com.mongodb.repositories.HouseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @RequestMapping(value = "/{address}", method = RequestMethod.GET)
    public House findHouse(@PathVariable("address") String address) {
        return houseRepository.findByAddress(address);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody  House house) {
        house.setId(ObjectId.get());
        houseRepository.save(house);
    }

}
