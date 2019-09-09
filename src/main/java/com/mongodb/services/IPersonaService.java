package com.mongodb.services;

import com.mongodb.entities.Persona;

public interface IPersonaService {
    void savePersona(Persona persona, int cantidad);
}
