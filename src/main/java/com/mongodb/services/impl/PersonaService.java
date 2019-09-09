package com.mongodb.services.impl;

import com.mongodb.entities.Persona;
import com.mongodb.repositories.PersonaRepository;
import com.mongodb.services.IPersonaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void savePersona (Persona persona, int cantidad) {
        int personaByCedula = personaRepository.countByCedula(persona.getCedula());
        int personaByCorreo = personaRepository.countByCorreo(persona.getCorreo());

        if(personaByCedula !=cantidad) {
            throw new RuntimeException("Ya existe una persona con la cédula " + persona.getCedula());
        }

        if(personaByCorreo !=cantidad) {
            throw new RuntimeException("Ya existe una persona con el correo " + persona.getCorreo());
        }

        if(cantidad!= 1) {
            persona.setId(ObjectId.get());
        }
        personaRepository.save(persona);

    }
}
