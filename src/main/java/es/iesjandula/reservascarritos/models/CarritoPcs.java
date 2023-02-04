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
 * Clase Carrito Pcs
 */
@Entity
@Table(name="carrito_pcs")
@Getter
@Setter
public class CarritoPcs
{
    /** Atributo - identificador unico del carrito de pcs. */
    @Id
    @Column(length = 10)
    private Long id;

    /** Atributo - numero de pcs en el carrito. */
    @Column(length = 10 , nullable = false)
    private int numeroPcs;

    /** Atributo - numero de planta donde está el carrito. */
    @Column(length = 10 , nullable = false)
    private int planta;

    /** Atributo - sistema operativo que contiene los pcs del carrito. */
    @Column(length = 25, nullable = false)
    private String sistemaOperativo;

    /** Constructor vacio. */
    public CarritoPcs()
    {
    }
}
