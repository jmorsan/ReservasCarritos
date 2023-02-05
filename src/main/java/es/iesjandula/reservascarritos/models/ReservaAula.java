package es.iesjandula.reservascarritos.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Joaquin Moreno
 *
 * Clase Aula Informatica
 */
@Entity
@Table(name = "reserva_aula")
@Getter
@Setter
public class ReservaAula
{
    /** Atributo - identificador unico compuesto de la reserva del aula. */
    @EmbeddedId
    private ReservaAulaId reservaAulaId;

    /** Atributo - identificador unico del profesor que hace la reserva. */
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @MapsId("idProfesor")
    private Profesor idProfesor;

    /** Atributo - identificador unico del aula que se reserva. */
    @ManyToOne
    @JoinColumn(name = "id_aula_informatica")
    @MapsId("idAulaInformatica")
    private AulaInformatica idAulaInformatica;

    /** Constructor vacio. */
    public ReservaAula()
    {
    }

    /**
     * Constructor por parametros
     * @param reservaAulaId con el identificador unico compuesto del reserva.
     * @param idProfesor con el identificador unico del profesor que hace la reserva.
     * @param idAulaInformatica con el identificador unico del aula que se reserva.
     */
    public ReservaAula(ReservaAulaId reservaAulaId, Profesor idProfesor, AulaInformatica idAulaInformatica)
    {
        this.reservaAulaId = reservaAulaId;
        this.idProfesor = idProfesor;
        this.idAulaInformatica = idAulaInformatica;
    }

}
