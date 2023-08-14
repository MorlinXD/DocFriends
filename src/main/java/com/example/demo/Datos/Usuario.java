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
@Table(name = "usuarios")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_usuario;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private String apellidos;
    
    @Column(nullable=false)
    private String correo;
    
    @Column(nullable=false)
    private String password;
    
    @Column(nullable=false)
    private String cedula;
    
    @Column(nullable=false)
    private String telefono;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    Provincia id_provincia;/*Clave foranea*/
    
    @ManyToOne
    @JoinColumn(nullable=false)
    Ciudad id_ciudad;/*Clave foranea*/
    
    @Column (nullable=false)
    private String verificado;
    
    @OneToOne
    @JoinColumn(nullable=true)
    Imagen id_imagen;/*Clave foranea*/

}
