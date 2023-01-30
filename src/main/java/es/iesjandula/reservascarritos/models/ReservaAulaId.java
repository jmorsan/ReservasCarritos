package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ReservaAulaId implements Serializable
{
    private static final long serialVersionUID = 4641059104768487532L;

    private Long idProfesor;

    private Long idAulaInformatica;

    private Date fecha;

    public ReservaAulaId()
    {
    }

    public ReservaAulaId(Long idProfesor, Long idAulaInformatica, Date fecha)
    {
        this.idProfesor = idProfesor;
        this.idAulaInformatica = idAulaInformatica;
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

    public Long getIdAulaInformatica()
    {
        return idAulaInformatica;
    }

    public void setIdAulaInformatica(Long idAulaInformatica)
    {
        this.idAulaInformatica = idAulaInformatica;
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
