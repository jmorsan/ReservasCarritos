package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class ReservaCarritoPcsId implements Serializable
{

    private Long idProfesor;

    private Long idCarritoPcs;

    @Id
    @Column(length = 50, nullable = false)
    private Date fecha;

    public ReservaCarritoPcsId()
    {
    }
}
