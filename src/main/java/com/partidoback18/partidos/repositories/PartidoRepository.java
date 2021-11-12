package com.partidoback18.partidos.repositories;

import com.partidoback18.partidos.models.PartidoModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartidoRepository extends MongoRepository<PartidoModel, String>{
    
}
