/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.Datos.Usuario;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Alvar
 */
@Repository
public interface usuario_interface extends JpaRepository<Usuario, Serializable>{
    Usuario findByidUsuario(long idusuario);
    Usuario findByNombreusuario(String nombreusuario);
}

