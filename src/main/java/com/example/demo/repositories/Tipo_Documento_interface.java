/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.Datos.Tipo_Documento;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alvar
 */
@Repository
public interface Tipo_Documento_interface extends JpaRepository<Tipo_Documento, Serializable>{
    Tipo_Documento findByidTipoDocumento(long idTipoDocumento);
}
