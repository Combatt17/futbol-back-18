package com.partidoback18.partidos.repositories;

import java.util.Optional;

import com.partidoback18.partidos.models.UsuarioModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioModel,String>{
    
    //Para buscar a un usuario por nombre de usuario (username)
    public Optional<UsuarioModel> findByUsername(String username);

    

}
