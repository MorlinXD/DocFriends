/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Datos;

import jakarta.persistence.*;
/*import java.awt.Image;*/


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
@Table(name = "imagenes")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Imagen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_imagen;
    
    /*@Column(nullable=false)
    private Image imagen;/*varbinary o imageIO confirmar luego*/
    
    
}
