package com.partidoback18.partidos.services;

import com.partidoback18.partidos.models.PartidoModel;
import com.partidoback18.partidos.repositories.PartidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {
    
    @Autowired
    PartidoRepository partidoRepository;

    public void guardarPartido(PartidoModel partido){
        this.partidoRepository.save(partido);

    }
    
}
