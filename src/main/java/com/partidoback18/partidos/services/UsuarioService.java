package com.partidoback18.partidos.services;

import java.util.List;
import java.util.Optional;

import com.partidoback18.partidos.models.UsuarioModel;
import com.partidoback18.partidos.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    //Método para guardar usuario
    public void guardarUsuario(UsuarioModel usuario) {
        this.usuarioRepository.save(usuario);
    }


    //Método para listar todos los usuarios
    public List<UsuarioModel> traerTodos() {
        return this.usuarioRepository.findAll();
    }

    //Método para buscar por ID
    public Optional<UsuarioModel> buscarPorId(String id) {
        return this.usuarioRepository.findById(id);
    }

    //Método para buscar por username
    public UsuarioModel buscarUsername(String username) {
        return this.usuarioRepository.findByUsername(username).orElse(new UsuarioModel());
    }
}
