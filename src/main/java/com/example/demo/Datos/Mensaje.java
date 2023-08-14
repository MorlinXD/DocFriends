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
@Table(name = "mensajes")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_mensaje;
    
    @Column(nullable = false)
    private String contenido;
    
    @Column(nullable = false)
    private Date fecha;/*Datetime*/
    
    @OneToOne
    @JoinColumn(nullable = false)
    Usuario id_usuario;/*remitente*/
    
    /*@OneToOne
    @Column(nullable = false)
    Usuario id_usuario;/*destinatario*/
}
