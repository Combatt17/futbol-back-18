package com.partidoback18.partidos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.partidoback18.partidos.models.EquipoModel;
import com.partidoback18.partidos.services.EquipoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Definimos que el controlador es de tipo REST
@RequestMapping("/api") // El Path principal
public class EquipoController {
    
    @Autowired //Instalacia del servicio
    EquipoService equipoService;

    @PostMapping("/equipos") //Define la petición HTTP con la que ejecutará el método (POST) y El path (/api/partidos)
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody EquipoModel equipo){
        //Recibimos los datos por el body de la petición
        this.equipoService.guardarEquipo(equipo); //Invocamos el metodo creado en el servicio
        Map<String, String> respuesta=new HashMap<>();//Creamos el map para la respuesta al cliente
        respuesta.put("mensaje", "Se agregó el equipo correctamente"); //Se agrega la respuesta que se quiere enviar
        respuesta.put("estado", "true");
        return ResponseEntity.ok(respuesta); //Y se retorna esa respuesta
    }


    @GetMapping("/equipos")//Define la petición HTTP con la que ejecutará el método (GET) 
    public List<EquipoModel> mostrar(){
        //Invocamos el metodo creado en el servicio
        return this.equipoService.obtenerEquipos(); 
    }
}
