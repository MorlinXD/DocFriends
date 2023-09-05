/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.Datos.Documento;
import com.example.demo.Datos.Solicitud;
import com.example.demo.Datos.Usuario;
import com.example.demo.services.Documento_service;
import com.example.demo.services.Solicitud_Service;
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
public class documento_controller {

    @Autowired
    private Documento_service ds;
    @Autowired
    private usuario_service us;
    @Autowired
    private Solicitud_Service solise;
    @Autowired
    private usuario_service ps;

    @PostMapping("/savedoc")
    public String login(@ModelAttribute(name = "objdocumento") Documento doc, HttpSession session,
            @RequestParam(name = "file1", required = false) MultipartFile archivo1,
            @RequestParam(name = "file2", required = false) MultipartFile archivo2,
            @RequestParam(name = "file3", required = false) MultipartFile archivo3,
            @RequestParam(name = "file4", required = false) MultipartFile archivo4,
            @RequestParam(name = "file5", required = false) MultipartFile archivo5,
            @RequestParam(name = "file6", required = false) MultipartFile archivo6,
            @RequestParam(name = "arch1", required = false) MultipartFile pdf,
            RedirectAttributes flash) {

        Long userId = (Long) session.getAttribute("usuario");
        doc.setFecha_subida(Date.valueOf(LocalDate.now()));

        doc.setIdusuario(us.buscar(userId));
        List<MultipartFile> archivos = new ArrayList<>();
        archivos.add(archivo1);
        doc.setRuta1(archivo1.getOriginalFilename());
        archivos.add(archivo2);
        doc.setRuta2(archivo2.getOriginalFilename());
        archivos.add(archivo3);
        doc.setRuta3(archivo3.getOriginalFilename());
        archivos.add(archivo4);
        doc.setRuta4(archivo4.getOriginalFilename());
        archivos.add(archivo5);
        doc.setRuta5(archivo5.getOriginalFilename());
        archivos.add(archivo6);
        doc.setRuta6(archivo6.getOriginalFilename());

        try {
            for (MultipartFile archivo : archivos) {
                if (archivo != null && !archivo.isEmpty()) {
                    String ruta_gen = "src/main/resources/static/images/";
                    byte[] bytes = archivo.getBytes();
                    Path ruta = Paths.get(ruta_gen + archivo.getOriginalFilename());
                    Files.write(ruta, bytes);
                    // Guardar información del archivo en la base de datos si es necesario
                }
            }
            if (pdf != null && !pdf.isEmpty()) {
                String ruta_gen = "src/main/resources/static/files/";
                byte[] bytes = pdf.getBytes();
                Path ruta = Paths.get(ruta_gen + pdf.getOriginalFilename());
                Files.write(ruta, bytes);
                doc.setPdf(pdf.getOriginalFilename());
                // Guardar información del archivo en la base de datos si es necesario
            }
            ds.save(doc);
            session.setAttribute("mensajenoti", "Se creó el documento:'" + doc.getTitulo() + "' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo crear el documento:'" + doc.getTitulo() + "'");

        }
        return "redirect:/docsfriends/home";
    }

    @PostMapping("/editardoc")
    public String editar(Model mo, @ModelAttribute(name = "objdocumento") Documento doc, HttpSession session,
            @RequestParam(name = "file1", required = false) MultipartFile archivo1,
            @RequestParam(name = "file2", required = false) MultipartFile archivo2,
            @RequestParam(name = "file3", required = false) MultipartFile archivo3,
            @RequestParam(name = "file4", required = false) MultipartFile archivo4,
            @RequestParam(name = "file5", required = false) MultipartFile archivo5,
            @RequestParam(name = "file6", required = false) MultipartFile archivo6,
            RedirectAttributes flash) {
        Long userId = (Long) session.getAttribute("usuario");
        doc.setIdusuario(us.buscar(userId));
        List<MultipartFile> archivos = new ArrayList<>();
        archivos.add(archivo1);
        doc.setRuta1(archivo1.getOriginalFilename());
        archivos.add(archivo2);
        doc.setRuta2(archivo2.getOriginalFilename());
        archivos.add(archivo3);
        doc.setRuta3(archivo3.getOriginalFilename());
        archivos.add(archivo4);
        doc.setRuta4(archivo4.getOriginalFilename());
        archivos.add(archivo5);
        doc.setRuta5(archivo5.getOriginalFilename());
        archivos.add(archivo6);
        doc.setRuta6(archivo6.getOriginalFilename());
        try {
            for (MultipartFile archivo : archivos) {
                if (archivo != null && !archivo.isEmpty()) {
                    String ruta_gen = "src/main/resources/static/images/";
                    byte[] bytes = archivo.getBytes();
                    Path ruta = Paths.get(ruta_gen + archivo.getOriginalFilename());
                    Files.write(ruta, bytes);
                    // Guardar información del archivo en la base de datos si es necesario
                }
            }
            ds.save(doc);
            session.setAttribute("mensajenoti", "Se edito el documento:'" + doc.getTitulo() + "' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo editar el documento:'" + doc.getTitulo() + "'");

        }

        return "redirect:/docsfriends/home";
    }

    @PostMapping("/removemessage")
    public ResponseEntity<String> removeMessageFromSession(HttpSession session) {

        session.removeAttribute("mensajenoti");
        return ResponseEntity.ok("Mensaje de sesión eliminado");

    }

    @GetMapping("/deletedoc")
    public String eliminar(@RequestParam(value = "docID", required = true) Long docID, HttpSession session) throws ScriptException {
        Documento doc = ds.buscar(docID);

        try {
            ds.delete(doc);
            session.setAttribute("mensajenoti", "Se eliminó el documento:'" + doc.getTitulo() + "' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo eliminar el documento:'" + doc.getTitulo() + "'");

        }
        return "redirect:/docsfriends/home";
    }

    @PostMapping("/solicitar")
    public String solicitar(@ModelAttribute(name = "objsolicitud") Solicitud soli, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        System.out.print("Write line juas jaus");
        soli.setId_usuario(us.buscar(userId));
        soli.setFecha_solitud(Date.valueOf(LocalDate.now()));
        soli.setEstado("Pendiente");
        solise.guardarsoli(soli);
        try {
            solise.guardarsoli(soli);
            session.setAttribute("mensajenoti", "Se solicitó el documento: '" + soli.getIdDocumento().getTitulo() + "' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo solicitar el documento:'" + soli.getIdDocumento().getTitulo() + "'");

        }
        return "redirect:/docsfriends/home";
    }

    @PostMapping("/mdocumentos")
    public String mostrardoc(Model mo, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        mo.addAttribute("documentosInicio", ds.mostrarDocumentosInicio(ps.buscar(userId)));
        return "libros";
    }

    @GetMapping("/documento")
    public String a(Model mo, @RequestParam(value = "docID", required = true) Long docID) {
        mo.addAttribute("objdocumento", ds.buscar(docID));
        return "documento";
    }
}
