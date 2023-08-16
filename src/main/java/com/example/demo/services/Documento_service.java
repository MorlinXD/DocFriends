/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Documento;
import com.example.demo.Datos.Usuario;
import com.example.demo.repositories.Documento_interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class Documento_service {
    
    @Autowired
    private Documento_interface doc_inter;
    
    public Documento buscar(Long id) {
        return doc_inter.findByidDocumento(id);
    }
    
    public List<Documento> listar() {
        return doc_inter.findAll();
    }
    
    
    
     public void save(Documento doc) {

        doc_inter.save(doc);

    }
     
     
     public void delete(Documento doc) {
        doc_inter.delete(doc);
    }
    
}




    

    

   

    