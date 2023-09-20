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
@Table(name = "autor")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idautor;

    @Column(nullable = false, unique=true)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    Usuario idUsuario;


}
