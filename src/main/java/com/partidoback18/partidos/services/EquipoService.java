package com.partidoback18.partidos.services;

import java.util.List;

import com.partidoback18.partidos.models.EquipoModel;
import com.partidoback18.partidos.repositories.EquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
    
    @Autowired //Instancia del repositorio
    EquipoRepository equipoRepository; //Variable que hace referencia al repositorio

    //Metodo para guardar datos del equipo
    public void guardarEquipo(EquipoModel equipo){
        this.equipoRepository.save(equipo);
    }

    //Método para listar los equipos
    public List<EquipoModel> obtenerEquipos(){
        return this.equipoRepository.findAll();
    }
}
