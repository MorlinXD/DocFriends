/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Datos.Usuario;
import com.example.demo.services.ciudad_service;
import com.example.demo.services.provincia_service;
import com.example.demo.services.usuario_service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

    @PostMapping("/save")
    public String guardar(@ModelAttribute(name = "objusuario") Usuario usu, HttpSession session) {

        if (!usu.getPassword().equals(usu.getRepeatPassword())) {
            return "redirect:/docsfriends/iniciosession";
        } else {
            ps.save(usu);
            session.setAttribute("usuario", usu.getIdUsuario());
        }

        return "iniciousuario"; 
    }

    @PostMapping("/iniciar")
    public String iniciar(@ModelAttribute("objusuario") Usuario usu, HttpSession session) {
        Usuario aux = ps.buscarPorNombreUsuario(usu.getNombreusuario());
        if (aux != null && usu.getPassword().equals(aux.getPassword())) {
            session.setAttribute("usuario", aux.getIdUsuario());
            return "redirect:/docsfriends/home";
            
        } else {
            return "redirect:/docsfriends/iniciosession";
        }
    }
}
