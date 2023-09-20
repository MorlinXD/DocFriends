/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Usuario;
import com.example.demo.Datos.autores;
import com.example.demo.repositories.autor_interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class autor_service {
    
    @Autowired
    private autor_interface autor_inter;
    
    public autores buscar(Long id) {
        return autor_inter.findByidautor(id);
    }
    
    public List<autores> buscaru(Usuario usu) {
        return autor_inter.findByidUsuario (usu);
    }
    
    public List<autores> buscarsindoc() {
        return autor_inter.findAutoresNotInAnyDocumento();
    }
    
    public List<autores> buscarcondoc() { 
        return autor_inter.findAutoresInAnyDocumento();
    }
    
    public List<autores> listar() {
        return autor_inter.findAll();
    }

     public void save(autores doc) {

        autor_inter.save(doc);

    }
     
     
     public void delete(autores doc) {
        autor_inter.delete(doc);
    }
    
}




    

    

   

    