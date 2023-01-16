package es.iesjandula.reservascarritos.repositories;

import es.iesjandula.reservascarritos.models.ReservaAula;
import es.iesjandula.reservascarritos.models.ReservaAulaId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joaquín Moreno
 *
 * ReservaAula Repository
 */
public interface IReservaAulaRepository extends JpaRepository<ReservaAula, ReservaAulaId>
{
}
