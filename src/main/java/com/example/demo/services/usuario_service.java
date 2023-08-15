/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Usuario;
import com.example.demo.repositories.usuario_interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class usuario_service {
    @Autowired
    private usuario_interface usuario_inter;
    
    
    public Usuario buscar(Long id)
    {
        return usuario_inter.findByidUsuario(id);
    }
    
    public List<Usuario> listar()
    {
        return usuario_inter.findAll();
    }
    
    
    public void save(Usuario usua)
    {

            usuario_inter.save(usua);

        
    }
    
    
    public void delete(Usuario usua)
    {
        usuario_inter.delete(usua);
    }
}
