/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Datos.Usuario;
import com.example.demo.services.ciudad_service;
import com.example.demo.services.provincia_service;
import com.example.demo.services.usuario_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Alvar
 */
@Controller
@RequestMapping("/docsfriends")
public class usuario_controller {
    
    @Autowired
    private usuario_service ps;
    @Autowired
    private provincia_service pros;
    @Autowired
    private ciudad_service cius;
    
    @GetMapping("/registrarse")
    public String vista(Model mo) {
        if (mo.getAttribute("objusuario") == null) {
            mo.addAttribute("objusuario", new Usuario());
        }
        mo.addAttribute("listaciudad", cius.listar());
        mo.addAttribute("listaprovincias", pros.listar());
        return "registrarse";
    }
    
    

    
}
