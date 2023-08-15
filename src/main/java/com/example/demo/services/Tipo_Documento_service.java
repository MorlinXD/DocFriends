/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.Datos.Tipo_Documento;
import com.example.demo.repositories.Tipo_Documento_interface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alvar
 */
@Service
public class Tipo_Documento_service {
    @Autowired
    private Tipo_Documento_interface tipodocinter;

    public Tipo_Documento buscar(Long id) {
        return tipodocinter.findByidTipoDocumento(id);
    }

    public List<Tipo_Documento> listar() {
        return tipodocinter.findAll();
    }

    public void save(Tipo_Documento ciu) {

        tipodocinter.save(ciu);

    }

    public void delete(Tipo_Documento ciu) {
        tipodocinter.delete(ciu);
    }
}
