package es.iesjandula.reservascarritos.models;

import java.util.List;

public class Reservas
{
    private List<ReservaAula> reservaAulaList;

    private  List<ReservaCarritoPcs>reservaCarritoPcsList;

    private List<ReservaCarritoTablets>reservaCarritoTabletsList;

    public Reservas()
    {

    }

    public Reservas(List<ReservaAula> reservaAulaList, List<ReservaCarritoPcs> reservaCarritoPcsList, List<ReservaCarritoTablets> reservaCarritoTabletsList)
    {
        this.reservaAulaList = reservaAulaList;
        this.reservaCarritoPcsList = reservaCarritoPcsList;
        this.reservaCarritoTabletsList = reservaCarritoTabletsList;
    }

    public List<ReservaAula> getReservaAulaList()
    {
        return reservaAulaList;
    }

    public void setReservaAulaList(List<ReservaAula> reservaAulaList)
    {
        this.reservaAulaList = reservaAulaList;
    }

    public List<ReservaCarritoPcs> getReservaCarritoPcsList()
    {
        return reservaCarritoPcsList;
    }

    public void setReservaCarritoPcsList(List<ReservaCarritoPcs> reservaCarritoPcsList)
    {
        this.reservaCarritoPcsList = reservaCarritoPcsList;
    }

    public List<ReservaCarritoTablets> getReservaCarritoTabletsList()
    {
        return reservaCarritoTabletsList;
    }

    public void setReservaCarritoTabletsList(List<ReservaCarritoTablets> reservaCarritoTabletsList)
    {
        this.reservaCarritoTabletsList = reservaCarritoTabletsList;
    }
}
