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

    @Id
    @Column(length = 50, nullable = false)
    private Date fecha;


    public ReservaCarritoTabletsId()
    {
    }
}
