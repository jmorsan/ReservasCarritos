package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Joaquin Moreno
 *
 * Clase Reserva Carritos Tablets
 */
@Entity
@Table(name = "reserva_carrito_tablets")
@Getter
@Setter
public class ReservaCarritoTablets
{
    /** Atributo - identificador unico compuesto de la reserva del carrito de tablets. */
    @EmbeddedId
    private ReservaCarritoTabletsId reservaCarritoTabletsId;

    /** Atributo - identificador unico del profesor que hace la reserva. */
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    /** Atributo - identificador unico del carrito de tablets. */
    @ManyToOne
    @JoinColumn(name = "id_carrito_tablets")
    @MapsId("idCarritoTablets")
    private CarritoTablets idCarritoTablets;

    /** Atributo - ubicacion a actualizar del carrito de tablets. */
    @Column(length = 25, nullable = false)
    private String ubicacionPrestamo;

    /** Constructor vacio. */
    public ReservaCarritoTablets()
    {
    }

    /**
     *
     * @param reservaCarritoTabletsId con el identificador unico compuesto de la reserva del carrito de tablets.
     * @param idProfesor con identificador unico compuesto del profesor.
     * @param idCarritoTablets con el identificador unico del carrito de tablets.
     * @param ubicacionPrestamo ubicacion del carrito de tablets.
     */
    public ReservaCarritoTablets(ReservaCarritoTabletsId reservaCarritoTabletsId, Profesor idProfesor, CarritoTablets idCarritoTablets, String ubicacionPrestamo)
    {
        this.reservaCarritoTabletsId = reservaCarritoTabletsId;
        this.idProfesor = idProfesor;
        this.idCarritoTablets = idCarritoTablets;
        this.ubicacionPrestamo = ubicacionPrestamo;
    }
}
