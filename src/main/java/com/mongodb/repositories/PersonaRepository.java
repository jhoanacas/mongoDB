package com.mongodb.repositories;

import com.mongodb.entities.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonaRepository extends MongoRepository<Persona, String> {

    Persona findByCedula(String cedula);
    int countByCedula(String cedula);
    int countByCorreo(String correo);


}
