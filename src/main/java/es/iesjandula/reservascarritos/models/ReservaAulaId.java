package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Joaquin Moreno
 *
 * Clase Reserva Aula Id
 *
 * Conforma la clave primaria compuesta de Reserva de Aula
 */
@Embeddable
@Getter
@Setter
public class ReservaAulaId implements Serializable
{
    /** Atributo - identificador unico compuesto de la reserva de aula. */
    private static final long serialVersionUID = 4641059104768487532L;

    /** Atributo - identificador unico compuesto del profesor. */
    private Long idProfesor;

    /** Atributo - identificador unico compuesto del aula informatica. */
    private Long idAulaInformatica;

    /** Atributo - fecha de la reserva. */
    private Date fecha;

    /** Constructor vacio. */
    public ReservaAulaId()
    {
    }

    /**
     * Constructor por parametros
     * @param idProfesor con identificador unico compuesto del profesor.
     * @param idAulaInformatica con identificador unico compuesto del aula informatica.
     * @param fecha con la fecha de la reserva.
     */
    public ReservaAulaId(Long idProfesor, Long idAulaInformatica, Date fecha)
    {
        this.idProfesor = idProfesor;
        this.idAulaInformatica = idAulaInformatica;
        this.fecha = fecha;
    }


}
