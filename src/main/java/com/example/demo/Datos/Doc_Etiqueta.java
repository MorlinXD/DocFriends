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
/*@Entity*/
@Table(name = "doc_etiqueta")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doc_Etiqueta {

    @OneToOne
    @JoinColumn(nullable = false)
    Documento id_documento;/*clave foranea*/
    
    @OneToOne
    @JoinColumn(nullable = false)
    Etiqueta id_etiqueta;/*clave foranea*/
}
