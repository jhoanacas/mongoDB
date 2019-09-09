package com.mongodb.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Persona {

    @Id
    private ObjectId id;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String correo;
    private String telefono;


    public void setTelefono(String telefono) throws Exception {
        if(!telefono.matches("[0-9]+")){
            throw new RuntimeException("El teléfono debe contener solo números");
        } else {
            this.telefono= telefono;
        }
    }

    public void setCedula(String cedula) throws Exception {
        if(!cedula.matches("[0-9]+")){
            throw new RuntimeException("La cédula debe contener solo números");
        } else {
            this.cedula= cedula;
        }
    }


    public void setCorreo(String correo) throws Exception {
        if(!correo.matches("[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+")){
            throw new RuntimeException("El formato del correo es inválido");
        } else {
            this.correo= correo;
        }
    }
}
