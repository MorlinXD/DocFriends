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
import java.sql.Date;
import java.time.LocalDate;
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

    @PostMapping("/savedoc")
    public String login(@ModelAttribute(name = "objdocumento") Documento doc, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        doc.setFecha_subida(Date.valueOf(LocalDate.now()));

        doc.setIdusuario(us.buscar(userId));

        try {
            ds.save(doc);
            session.setAttribute("mensajenoti", "Se creó el documento:'"+doc.getTitulo()+"' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo crear el documento:'"+doc.getTitulo()+"'");

        }
        return "redirect:/docsfriends/home";
    }

    @PostMapping("/editardoc")
    public String editar(Model mo, @ModelAttribute(name = "objdocumento") Documento doc, HttpSession session) {
        Long userId = (Long) session.getAttribute("usuario");
        doc.setIdusuario(us.buscar(userId));
        try {
            ds.save(doc);
            session.setAttribute("mensajenoti", "Se edito el documento:'"+doc.getTitulo()+"' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo editar el documento:'"+doc.getTitulo()+"'");

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
            session.setAttribute("mensajenoti", "Se eliminó el documento:'"+doc.getTitulo()+"' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo eliminar el documento:'"+doc.getTitulo()+"'");

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
            session.setAttribute("mensajenoti", "Se solicitó el documento: '"+soli.getIdDocumento().getTitulo()+"' correctamente");

        } catch (Exception e) {
            session.setAttribute("mensajenoti", "No se pudo solicitar el documento:'"+soli.getIdDocumento().getTitulo()+"'");

        }
        return "redirect:/docsfriends/home";
    }

    @GetMapping("/documento")
    public String a(Model mo, @RequestParam(value = "docID", required = true) Long docID) {
        mo.addAttribute("objdocumento", ds.buscar(docID));
        return "documento";
    }
}
