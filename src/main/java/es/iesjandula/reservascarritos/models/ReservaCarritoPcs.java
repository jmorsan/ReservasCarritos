package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reserva_carrito_pcs")
public class ReservaCarritoPcs
{
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    @ManyToOne
    @JoinColumn(name = "id_carrito_pcs")
    @MapsId("idCarritoPcs")
    private CarritoPcs idCarritoPcs;

    @Id
    @Column(length = 50, nullable = false)
    private Date fecha;

    @Column(length = 25, nullable = false)
    private String ubicacionPrestamo;

    public ReservaCarritoPcs()
    {
    }
}
