/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Datos;

import jakarta.persistence.*;
import java.sql.Date;
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
@Table(name = "resenias")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_resenia;
    
    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private int calificacion;/*Entero del 1 al 10*/
    
    @ManyToOne
    @JoinColumn(nullable = false)
    Documento id_documento;/*clave foranea*/
    
    @ManyToOne
    @JoinColumn(nullable = false)
    Usuario id_usuario;/*clave foranea*/
    
    @Column(nullable = false)
    private Date fecha_subida;/*Datetime*/
}
