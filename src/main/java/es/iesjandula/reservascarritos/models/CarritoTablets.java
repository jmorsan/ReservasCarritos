package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="carrito_tablets")
public class CarritoTablets
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 10)
    private int numeroTablets;

    @Column(length = 10)
    private int planta;

    public CarritoTablets()
    {
    }
}
