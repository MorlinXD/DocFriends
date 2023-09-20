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
import com.example.demo.services.autor_service;
import com.example.demo.services.usuario_service;
import jakarta.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Alvar
 */
@Controller
@RequestMapping("/docsfriends")
public class autor_controller {

    @Autowired
    private autor_service ds;
    @Autowired
    private usuario_service us;

    @GetMapping("/autores")
    public String a(Model mo, HttpSession session) {
        mo.addAttribute("autoresnormal", ds.listar());
        Long userId = (Long) session.getAttribute("usuario");
        mo.addAttribute("autoresusuario", ds.buscaru(us.buscar(userId)));
        mo.addAttribute("objautor", new autores());
        return "adminautores";
    }

    @PostMapping("/saveautor")
    public String guardar(@ModelAttribute(name = "objautor") autores usu, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        usu.setIdUsuario(us.buscar(userId));
        System.out.println("vAMOS ACÁ");
        ds.save(usu);
        return "redirect:/docsfriends/home";
    }
}
