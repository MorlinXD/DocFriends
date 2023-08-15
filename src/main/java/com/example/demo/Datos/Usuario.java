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
    private long idUsuario;
    
    @Column(nullable=false,length = 30,unique =true)
    private String nombreusuario;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false)
    private String apellidos;
    
    @Column(nullable=false,length = 30,unique =true)
    private String correo;
    
    @Column(nullable=false)
    private String password;
    
    @Transient
    private String repeatPassword;
    
    @Column(nullable=false,length = 10,unique =true)
    private String cedula;
    
    @Column(nullable=false,length = 13,unique =true)
    private String telefono;
    
    @Column(nullable=true, length=30)
    private String direccion;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    Provincia idProvincia;/*Clave foranea*/
    
    @ManyToOne
    @JoinColumn(nullable=false)
    Ciudad idCiudad;/*Clave foranea*/
    
    @Column (nullable=true)
    private String verificado;
    
    @OneToOne
    @JoinColumn(nullable=true)
    Imagen idImagen;/*Clave foanea*/

}
