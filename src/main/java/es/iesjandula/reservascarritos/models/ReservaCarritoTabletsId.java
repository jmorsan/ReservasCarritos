package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ReservaCarritoTabletsId implements Serializable
{
    private static final long serialVersionUID = -6168627471229791728L;

    private Long idProfesor;


    private Long idCarritoTablets;

    private Date fecha;

    public ReservaCarritoTabletsId()
    {
    }

    public Long getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor)
    {
        this.idProfesor = idProfesor;
    }

    public Long getIdCarritoTablets()
    {
        return idCarritoTablets;
    }

    public void setIdCarritoTablets(Long idCarritoTablets)
    {
        this.idCarritoTablets = idCarritoTablets;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }
}
