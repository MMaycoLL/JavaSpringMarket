package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//Comparte atributos de herencia
@MappedSuperclass //Hereda
public class Persona implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    @Column(length = 100, nullable = false)
    private String nombreCompleto;

    @Email
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 10, nullable = false, unique = true)
    private String cedula;

    @Column(length = 100, nullable = false)
    private String Contrasenia;

}