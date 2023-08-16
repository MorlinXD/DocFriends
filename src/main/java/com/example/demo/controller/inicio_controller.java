/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Datos.Documento;
import com.example.demo.Datos.Usuario;
import com.example.demo.services.Documento_service;
import com.example.demo.services.Tipo_Documento_service;
import com.example.demo.services.usuario_service;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
public class inicio_controller {

    @Autowired
    private usuario_service ps;
    @Autowired
    private Tipo_Documento_service tipodocser;
    @Autowired
    private Documento_service ds;

    @GetMapping("/iniciosession")
    public String login(Model mo) {
        mo.addAttribute("objusuario", new Usuario());
        return "iniciodesesion";
    }

    @GetMapping("/home")
    public String iniciousuario(Model mo, HttpSession session, HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        System.out.print("cd");
        Long userId = (Long) session.getAttribute("usuario");
        mo.addAttribute("objusuario", userId);
        System.out.print("cd2");
        if (userId == null) {
            System.out.print("cd3");
            return "redirect:/docsfriends/iniciosession";
        }
        Usuario usu = ps.buscar(userId);
        if (usu == null) {
            return "redirect:/docsfriends/iniciosession";
        }
        return "iniciousuario";
    }

    @GetMapping("/logouteq")
    public String logo(Model mo) {
        return "ss.jpg";
    }

    @GetMapping("/perfil")
    public String perfil(Model mo, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        System.out.print("Valor: "+userId);
        mo.addAttribute("objusuario", ps.buscar(userId));
        
        return "perfil";
    }
    
    
    
    

    @GetMapping("/salir")
    public String cerrarSesion(HttpSession session) {

        // Eliminar el atributo de usuario de la sesión
        session.removeAttribute("usuario");

        return "redirect:/docsfriends/iniciosession";
    }

    @GetMapping("/inicio")
    public String cargarinicio(HttpSession session) {

        return "contenidoinicial";
    }

    @GetMapping("/creardoc")
    public String creardocument(Model mo) {
        mo.addAttribute("listatipodoc", tipodocser.listar());
        if (mo.getAttribute("objdocumento") == null) {
            mo.addAttribute("objdocumento", new Documento());
        }
        return "creardocumento";
    }

}
