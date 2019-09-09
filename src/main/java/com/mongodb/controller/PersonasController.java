package com.mongodb.controller;


import com.mongodb.entities.Persona;
import com.mongodb.repositories.PersonaRepository;
import com.mongodb.services.IPersonaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonasController {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    IPersonaService personaService;

    @RequestMapping(value = "/{cedula}", method = RequestMethod.GET)
    public Persona findPersonaByCedula(@PathVariable("cedula") String cedula) {
        return personaRepository.findByCedula(cedula);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody  Persona persona) {
        personaService.savePersona(persona, 0);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Persona persona) {
        Persona personaUpdate  = personaRepository.findByCedula(persona.getCedula());
        if (personaUpdate == null) {
            throw new RuntimeException("La persona que quiere actualizar no existe en nuestras bases de datos");
        }
        persona.setId(personaUpdate.getId());
        personaService.savePersona(persona, 1);
    }

    @RequestMapping(value = "/delete/{cedula}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("cedula") String cedula) {
        personaRepository.delete(personaRepository.findByCedula(cedula));
    }

}
