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
 * Clase Carrito Tablets
 */
@Entity
@Table(name="carrito_tablets")
@Getter
@Setter
public class CarritoTablets
{
    /** Atributo - identificador unico del carrito de tablets. */
    @Id
    @Column(length = 10)
    private Long id;

    /** Atributo - numero de tablets en el carrito. */
    @Column(length = 10 , nullable = false)
    private int numeroTablets;

    /** Atributo - numero de planta donde está el carrito. */
    @Column(length = 10 , nullable = false)
    private int planta;

    /** Constructor vacio. */
    public CarritoTablets()
    {
    }

}
