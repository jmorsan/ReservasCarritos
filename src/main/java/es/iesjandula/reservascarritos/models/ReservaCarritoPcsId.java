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
public class ReservaCarritoPcsId implements Serializable
{
    /** Atributo - identificador unico compuesto del reserva carrito pcs. */
    private static final long serialVersionUID = 5555119262846834919L;

    /** Atributo - identificador unico del profesor que hace la reserva. */
    private Long idProfesor;

    /** Atributo - identificador unico del carrito de pcs que se reserva. */
    private Long idCarritoPcs;

    /** Atributo - fecha de la reserva. */
    private Date fecha;

    /** Constructor vacio. */
    public ReservaCarritoPcsId()
    {
    }

    /**
     * Constructor por parametros
     * @param idProfesor con identificador unico compuesto del del profesor.
     * @param idCarritoPcs con identificador unico del carrito de pcs que se reserva.
     * @param fecha con la fecha de la reserva.
     */
    public ReservaCarritoPcsId(Long idProfesor, Long idCarritoPcs, Date fecha)
    {
        this.idProfesor = idProfesor;
        this.idCarritoPcs = idCarritoPcs;
        this.fecha = fecha;
    }
}
