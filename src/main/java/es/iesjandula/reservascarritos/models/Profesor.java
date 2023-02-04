package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Joaquin Moreno
 *
 * Clase Profesor
 */
@Entity
@Table(name="profesor")
@Getter
@Setter
public class Profesor
{
    /** Atributo - identificador unico del profesor. */
    @Id
    @Column(length = 10)
    private Long id;

    /** Atributo - nombre del profesor. */
    @Column(length = 25, nullable = false)
    private String nombre;

    /** Atributo - apellidos del profesor. */
    @Column(length = 50, nullable = false)
    private String apellidos;

    /** Constructor vacio */
    public Profesor(){
        //Empty Constructor
    }


}
