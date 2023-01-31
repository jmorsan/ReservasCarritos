package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ReservaCarritoPcsId implements Serializable
{
    private static final long serialVersionUID = 5555119262846834919L;

    private Long idProfesor;

    private Long idCarritoPcs;

    private Date fecha;

    public ReservaCarritoPcsId()
    {
    }

    public ReservaCarritoPcsId(Long idProfesor, Long idCarritoPcs, Date fecha)
    {
        this.idProfesor = idProfesor;
        this.idCarritoPcs = idCarritoPcs;
        this.fecha = fecha;
    }

    public Long getIdProfesor()
    {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor)
    {
        this.idProfesor = idProfesor;
    }

    public Long getIdCarritoPcs()
    {
        return idCarritoPcs;
    }

    public void setIdCarritoPcs(Long idCarritoPcs)
    {
        this.idCarritoPcs = idCarritoPcs;
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
