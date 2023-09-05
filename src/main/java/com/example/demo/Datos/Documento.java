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
    private long idDocumento;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;
    
    @Column(nullable = true)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    Usuario idusuario; /*clave foranea*/
    
    @ManyToOne
    @JoinColumn(nullable = false)
    Tipo_Documento idTipoDocumento;/*clave foranea*/
    
    
    @Column(nullable = false)
    private Date fecha_subida;/*datetime*/
    
    @Column(nullable = true)
    private Date fecha_intercambio;/*datetime*/
    
    @Column(nullable = true)
    private String disponible;
    
    @Column(name = "imagen1")
    private String ruta1;
    
    @Column(name = "imagen2")
    private String ruta2;
    
    @Column(name = "imagen3")
    private String ruta3;
    
    @Column(name = "imagen4")
    private String ruta4;
    
    @Column(name = "imagen5")
    private String ruta5;
    
     @Column(name = "imagen6")
    private String ruta6;
    
    

}
