package com.partidoback18.partidos.repositories;

import com.partidoback18.partidos.models.EquipoModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //Etiqueta que asígna la interfaz como repositorio
public interface EquipoRepository extends MongoRepository<EquipoModel,String>{
    /* 
    La Clase MongoRepository contiene creados 
    métodos de las funcione básica del CRUD
    C - Crear o agregar datos
    R - Leer datos 
    U - Actualizar
    D - Eliminar datos
    */

}
