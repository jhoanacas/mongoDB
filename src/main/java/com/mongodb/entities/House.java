package com.mongodb.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class House {

    @Id
    private ObjectId id;
    private String address;
    private String color;
}
