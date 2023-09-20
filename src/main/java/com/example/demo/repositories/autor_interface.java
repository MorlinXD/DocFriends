/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.Datos.Documento;
import com.example.demo.Datos.Usuario;
import com.example.demo.Datos.autores;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alvar
 */
@Repository
public interface autor_interface extends JpaRepository<autores, Serializable> {

    autores findByidautor(long idautor);

    List<autores> findByidUsuario(Usuario idUsuario); 
    
    @Query(value = "SELECT DISTINCT * FROM autor a WHERE NOT EXISTS (SELECT 1     FROM documento_autores da     WHERE da.autor_id = a.idautor);", nativeQuery = true)
    List<autores> findAutoresNotInAnyDocumento();
    
    @Query(value = "SELECT DISTINCT * FROM autor a inner JOIN documento_autores ON documento_autores.autor_id = a.idautor", nativeQuery = true)
    List<autores> findAutoresInAnyDocumento();
/*
    @Query("SELECT * FROM autores")
    List<autores> findAutoresWithoutDocuments() ;

 
    
    @Query("SELECT * FROM autores")    
List<autores> findAutoresWithDocuments();
*/
}
