/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositories;


import com.example.demo.Datos.Solicitud;
import com.example.demo.Datos.Usuario;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alvar
 */
@Repository
public interface Solicitud_Interface extends JpaRepository<Solicitud, Serializable>{
    Solicitud findByidSolicitud(long idSolicitud);
    List<Solicitud> findSolicitudesByidDocumentoIdusuario(Usuario usuario);
    
    
}
