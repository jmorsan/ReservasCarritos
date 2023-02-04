package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Joaquin Moreno
 *
 * Clase Aula Informatica
 */
@Entity
@Table(name="aula_informatica")
@Getter
@Setter
public class AulaInformatica
{
    /** Atributo - identificador unico del Aula. */
    @Id
    @Column(length = 10)
    private Long id;

    /** Atributo - numero de Aula. */
    @Column(length = 10 , nullable = false)
    private int numeroAula;

    /** Atributo - numero de planta */
    @Column(length = 2 , nullable = false)
    private int planta;

    /** Constructor vacio */
    public AulaInformatica()
    {
        //Empty Constructor
    }
}
