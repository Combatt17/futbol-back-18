package com.partidoback18.partidos.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.partidoback18.partidos.models.PartidoModel;
import com.partidoback18.partidos.services.PartidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PartidoController {
    
    @Autowired
    PartidoService service;


    @PostMapping("/partidos")
    public ResponseEntity<Map<String, String>> guardar(@Valid @RequestBody PartidoModel partido){
        //Recibimos los datos por el body de la petición
        this.service.guardarPartido(partido); //Invocamos el metodo creado en el servicio
        Map<String, String> respuesta=new HashMap<>();//Creamos el map para la respuesta al cliente
        respuesta.put("mensaje", "Se agregó el partido correctamente"); //Se agrega la respuesta que se quiere enviar
        respuesta.put("estado", "true");
        return ResponseEntity.ok(respuesta); //Y se retorna esa respuesta
    }
}
