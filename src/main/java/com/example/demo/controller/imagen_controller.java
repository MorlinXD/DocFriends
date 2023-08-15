/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Datos.Imagen;
import com.example.demo.services.imagen_service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Arrays;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Alvar
 */
@Controller
@RequestMapping("/docsfriends")
public class imagen_controller {

    @Autowired
    private imagen_service imagenService;

    @GetMapping("/subir-imagen")
    public String mostrarFormularioSubirImagen(Model model) {
        model.addAttribute("imagen", new Imagen());
        return "subir-imagen";
    }

    @PostMapping("/subir-imagen")
    public String subirImagen(@RequestParam("archivo") MultipartFile archivo, Model model) {
        try {
            byte[] imagenBytes = archivo.getBytes();
            model.addAttribute("imagenBytes", imagenBytes);
            return "iniciousuario"; // Renderiza la plantilla home.html con la imagen actualizada
        } catch (IOException e) {
            // Manejo de errores
            return "error";
        }
    }

    
}
