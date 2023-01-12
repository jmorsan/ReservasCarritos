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

    @Column(length = 10 , nullable = false)
    private int numeroPcs;

    @Column(length = 10 , nullable = false)
    private int planta;

    @Column(length = 25, nullable = false)
    private String sistemaOperativo;

    public CarritoPcs()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getNumeroPcs()
    {
        return numeroPcs;
    }

    public void setNumeroPcs(int numeroPcs)
    {
        this.numeroPcs = numeroPcs;
    }

    public int getPlanta()
    {
        return planta;
    }

    public void setPlanta(int planta)
    {
        this.planta = planta;
    }

    public String getSistemaOperativo()
    {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo)
    {
        this.sistemaOperativo = sistemaOperativo;
    }
}
