/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Imagen;
import com.example.demo.repositories.imagen_interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class imagen_service {
    @Autowired
    private imagen_interface imagenRepository;

    public void guardarImagen(Imagen imagen) {
        imagenRepository.save(imagen);
    }
    
    public Imagen buscar(Long id) {
        return imagenRepository.findByidImagen(id);
    }

    public List<Imagen> listar() {
        return imagenRepository.findAll();
    }


    public void delete(Imagen ima) {
        imagenRepository.delete(ima);
    }

    
    
}
