/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Datos.Solicitud;
import com.example.demo.services.Solicitud_Service;
import com.example.demo.services.usuario_service;
import javax.script.ScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Alvar
 */
@Controller
@RequestMapping("/docsfriends")
public class solicitudController {
    
    @Autowired
    private Solicitud_Service ps;
    
    @GetMapping("/aceptarsoli") 
    public String aceptar(@RequestParam(value = "idSoli", required = true) Long solID) throws ScriptException {
        
        Solicitud soli=ps.buscar(solID);
        soli.setEstado("Aceptada");
        ps.guardarsoli(soli);

        return "redirect:/docsfriends/home";
    }
    
    @GetMapping("/rechazarsoli") 
    public String rechazar(@RequestParam(value = "idSoli", required = true) Long solID) throws ScriptException {
        
        Solicitud soli=ps.buscar(solID);
        soli.setEstado("Rechazada");
        ps.guardarsoli(soli);

        return "redirect:/docsfriends/home";
    }
    
}
