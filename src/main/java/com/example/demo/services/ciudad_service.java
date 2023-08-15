/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Ciudad;
import com.example.demo.repositories.ciudad_interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class ciudad_service {

    @Autowired
    private ciudad_interface ciudad_inter;

    public Ciudad buscar(Long id) {
        return ciudad_inter.findByidCiudad(id);
    }

    public List<Ciudad> listar() {
        return ciudad_inter.findAll();
    }

    public void save(Ciudad ciu) {

        ciudad_inter.save(ciu);

    }

    public void delete(Ciudad ciu) {
        ciudad_inter.delete(ciu);
    }



}
