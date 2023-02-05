package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Joaquin Moreno
 *
 * Clase Reserva Carrito Pcs Id
 *
 * Conforma la clave primaria compuesta de Reserva Carrito Pcs
 */
@Embeddable
@Getter
@Setter
public class ReservaCarritoTabletsId implements Serializable
{
    /** Atributo - identificador unico compuesto del reserva carrito tablets. */
    private static final long serialVersionUID = -6168627471229791728L;

    /** Atributo - identificador unico del profesor que hace la reserva. */
    private Long idProfesor;

    /** Atributo - identificador unico del carrito de tablets que se reserva. */
    private Long idCarritoTablets;

    /** Atributo - fecha de la reserva. */
    private Date fecha;

    /** Constructor vacio. */
    public ReservaCarritoTabletsId()
    {
    }

    /**
     * Constructor por parametros
     * @param idProfesor con identificador unico compuesto del del profesor.
     * @param idCarritoTablets con identificador unico del carrito de tablets que se reserva.
     * @param fecha con la fecha de la reserva.
     */
    public ReservaCarritoTabletsId(Long idProfesor, Long idCarritoTablets, Date fecha)
    {
        this.idProfesor = idProfesor;
        this.idCarritoTablets = idCarritoTablets;
        this.fecha = fecha;
    }
}
