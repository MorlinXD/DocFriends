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
@Table(name = "documento")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_documento;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;
    
    @Column(nullable = false)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    Usuario id_usuario; /*clave foranea*/
    
    @ManyToOne
    @JoinColumn(nullable = false)
    Tipo_Documento id_tipodoc;/*clave foranea*/
    
    
    @Column(nullable = false)
    private Date fecha_subida;/*datetime*/
    
    @Column(nullable = false)
    private Date fecha_intercambio;/*datetime*/
    
    @Column(nullable = false)
    private String disponible;
}
