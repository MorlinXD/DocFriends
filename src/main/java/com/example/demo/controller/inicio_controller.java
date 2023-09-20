/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Datos.Documento;
import com.example.demo.Datos.Solicitud;
import com.example.demo.Datos.Usuario;
import com.example.demo.Datos.autores;
import com.example.demo.services.Documento_service;
import com.example.demo.services.Solicitud_Service;
import com.example.demo.services.Tipo_Documento_service;
import com.example.demo.services.autor_service;
import com.example.demo.services.ciudad_service;
import com.example.demo.services.usuario_service;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
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
    @Autowired
    private Solicitud_Service solise;
    @Autowired
    private autor_service autse;

    @GetMapping("/iniciosession")
    public String login(Model mo) {
        mo.addAttribute("objusuario", new Usuario());
        return "iniciodesesion";
    }

    @GetMapping("/home")
    public String iniciousuario(Model mo, HttpSession session, HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        Long userId = (Long) session.getAttribute("usuario");
        mo.addAttribute("objusuario", userId);

        if (userId == null) {
            System.out.print("cd3");
            return "redirect:/docsfriends/iniciosession";
        }
        Usuario usu = ps.buscar(userId);
        List<Solicitud> listnot = solise.listarusu(usu);

        Collections.reverse(listnot);
        mo.addAttribute("listanoti", listnot);

        

        if (usu == null) {
            return "redirect:/docsfriends/iniciosession";
        }
        return "iniciousuario";
    }

    @GetMapping("/logouteq")
    public String logo(Model mo) {
        return "ss.jpg";
    }

    @GetMapping("/editarperfil")
    public String edperfil(Model mo, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        mo.addAttribute("objusuario", ps.buscar(userId));
        return "editarperfil";
    }

    @GetMapping("/perfil")
    public String perfil(Model mo, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        System.out.print("Valor: " + userId);
        mo.addAttribute("objusuario", ps.buscar(userId));
        mo.addAttribute("documentos", ds.buscarDocumentosPorUsuario(ps.buscar(userId)));
         //---------------------------
        mo.addAttribute("listatipodoc", tipodocser.listar());
        if (mo.getAttribute("objdocumento") == null) {
            mo.addAttribute("objdocumento", new Documento());
        }
        //---------------------------
        return "perfil";
    }

    @GetMapping("/salir")
    public String cerrarSesion(HttpSession session) {

        // Eliminar el atributo de usuario de la sesión
        session.removeAttribute("usuario");

        return "redirect:/docsfriends/iniciosession";
    }

    @GetMapping("/inicio")
    public String cargarinicio(Model mo, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        mo.addAttribute("listatipodoc", tipodocser.listar());
        mo.addAttribute("documentosInicio", ds.mostrarDocumentosInicio(ps.buscar(userId)));
       
        return "contenidoinicial";
    }

    @GetMapping("/creardoc")
    public String creardocument(Model mo, HttpSession session) {
        mo.addAttribute("autoresnormal", ds.listar());
        Long userId = (Long) session.getAttribute("usuario");
        mo.addAttribute("autoresusuario", ds.buscarDocumentosPorUsuario(ps.buscar(userId)));
        mo.addAttribute("objautor", new autores());
        mo.addAttribute("listatipodoc", tipodocser.listar());
        if (mo.getAttribute("objdocumento") == null) {
            mo.addAttribute("objdocumento", new Documento());
        }
        mo.addAttribute("listautno",autse.buscarsindoc());
        mo.addAttribute("listautcon",autse.buscarcondoc());
        return "creardocumento";
    }

}
