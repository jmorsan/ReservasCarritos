package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="carrito_pcs")
public class CarritoPcs
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 10)
    private int numeroPcs;

    @Column(length = 10)
    private int planta;

    @Column(length = 25, nullable = false)
    private String sistemaOperativo;

    public CarritoPcs()
    {
    }
}
