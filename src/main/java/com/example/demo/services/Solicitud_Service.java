/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Solicitud;
import com.example.demo.Datos.Usuario;
import com.example.demo.repositories.Solicitud_Interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class Solicitud_Service {

    @Autowired
    private Solicitud_Interface soliciser;

    public void guardarsoli(Solicitud soli) {
        soliciser.save(soli);
    }

    public Solicitud buscar(Long id) {
        return soliciser.findByidSolicitud(id);
    }

    public List<Solicitud> listar() {
        return soliciser.findAll();
    }

    public List<Solicitud> listarusu(Usuario usu) {
        return soliciser.findSolicitudesByidDocumentoIdusuario(usu);
    }

    public void delete(Solicitud ima) {
        soliciser.delete(ima);
    }

}
