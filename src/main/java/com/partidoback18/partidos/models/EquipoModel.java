package com.partidoback18.partidos.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Agregamos el nombre a la colección 
@Document(collection="equipos")
public class EquipoModel {
    
    @Id //Etiqueta que asígna este campo como id
    private String id;

    @NotEmpty(message="El nombre del equipo no puede estar vacio")
    private String nombre; //Campo que guarda el nombre del equipo

    //Metodos selectores (get) y modificadores (set)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
