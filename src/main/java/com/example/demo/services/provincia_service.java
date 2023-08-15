/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Provincia;
import com.example.demo.repositories.provincia_interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class provincia_service {
    @Autowired
    private provincia_interface provincia_inter;
    
    
    public Provincia buscar(Long id)
    {
        return provincia_inter.findByidProvincia(id);
    }
    
    public List<Provincia> listar()
    {
        return provincia_inter.findAll();
    }
    
    
    public void save(Provincia usua)
    {

            provincia_inter.save(usua);

        
    }
    
    
    public void delete(Provincia usua)
    {
        provincia_inter.delete(usua);
    }
    
    
}
