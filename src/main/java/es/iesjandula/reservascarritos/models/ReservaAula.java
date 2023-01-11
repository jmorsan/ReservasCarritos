package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reserva_aula")
public class ReservaAula
{
    @Embedded
    private ReservaAulaId reservaAulaId;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_aula_informatica")
    @MapsId("idAulaInformatica")
    private AulaInformatica idAulaInformatica;

    @Id
    @Column(length = 50, nullable = false)
    private Date fecha;

    public ReservaAula()
    {
    }
}
