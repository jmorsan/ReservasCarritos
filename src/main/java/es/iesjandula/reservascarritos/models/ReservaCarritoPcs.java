package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Joaquin Moreno
 *
 * Clase Reserva Carritos PCS
 */
@Entity
@Table(name = "reserva_carrito_pcs")
@Getter
@Setter
public class ReservaCarritoPcs
{
    /** Atributo - identificador unico compuesto de la reserva del carrito de pcs. */
    @EmbeddedId
    private ReservaCarritoPcsId reservaCarritoPcsId;

    /** Atributo - identificador unico del profesor que hace la reserva. */
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    /** Atributo - identificador unico del carrito de pcs. */
    @ManyToOne
    @JoinColumn(name = "id_carrito_pcs")
    @MapsId("idCarritoPcs")
    private CarritoPcs idCarritoPcs;

    /** Atributo - ubicacion del carrito de pcs. */
    @Column(length = 25, nullable = false)
    private String ubicacionPrestamo;

    /** Constructor vacio. */
    public ReservaCarritoPcs()
    {
    }

    /**
     * Constructor por parametros
     * @param reservaCarritoPcsId con el identificador unico compuesto de la reserva del carrito de pcs.
     * @param idProfesor con el identificador unico del profesor que hace la reserva.
     * @param idCarritoPcs con el identificador unico del carrito de pcs.
     * @param ubicacionPrestamo con la ubicacion del carrito de pcs.
     */
    public ReservaCarritoPcs(ReservaCarritoPcsId reservaCarritoPcsId, Profesor idProfesor, CarritoPcs idCarritoPcs, String ubicacionPrestamo)
    {
        this.reservaCarritoPcsId = reservaCarritoPcsId;
        this.idProfesor = idProfesor;
        this.idCarritoPcs = idCarritoPcs;
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
