/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Datos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author MorlinXD
 */
@Entity
@Table(name = "tipo_documentos")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tipo_Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipoDocumento;
    
    @Column(nullable = false)
    private String nombre_tipo;
    
    @Column(nullable = false)
    private String descripcion;
}
