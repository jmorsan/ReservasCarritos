package es.iesjandula.reservascarritos.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Joaquin Moreno
 *
 * Clase Reservas
 *
 * Almacena todas las reservas
 */
@Getter
@Setter
public class Reservas
{
    /** Atributo - lista con todas las reservas de las aulas informaticas. */
    private List<ReservaAula> reservaAulaList;

    /** Atributo - lista con todas las reservas de carritos de pcs. */
    private  List<ReservaCarritoPcs>reservaCarritoPcsList;

    /** Atributo - lista con todas las reservas de carritos de tablets. */
    private List<ReservaCarritoTablets>reservaCarritoTabletsList;

    /** Constructor vacio */
    public Reservas()
    {

    }

    /**
     * /** Constructor por parametros
     * @param reservaAulaList con la lista con todas las reservas de las aulas informaticas.
     * @param reservaCarritoPcsList con la lista con todas las reservas de carritos de pcs.
     * @param reservaCarritoTabletsList con la lista con todas las reservas de carritos de tablets.
     */
    public Reservas(List<ReservaAula> reservaAulaList, List<ReservaCarritoPcs> reservaCarritoPcsList, List<ReservaCarritoTablets> reservaCarritoTabletsList)
    {
        this.reservaAulaList = reservaAulaList;
        this.reservaCarritoPcsList = reservaCarritoPcsList;
        this.reservaCarritoTabletsList = reservaCarritoTabletsList;
    }

}
