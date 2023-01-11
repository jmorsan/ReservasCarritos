package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="aula_informatica")
public class AulaInformatica
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 10)
    private int numeroAula;

    @Column(length = 2)
    private int planta;

    public AulaInformatica()
    {
        //Empty Constructor
    }
}
