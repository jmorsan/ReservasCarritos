package es.iesjandula.reservascarritos.repositories;

import es.iesjandula.reservascarritos.models.ReservaCarritoTablets;
import es.iesjandula.reservascarritos.models.ReservaCarritoTabletsId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joaquín Moreno
 *
 * ReservaCarritoTablets Repository
 */
public interface IReservaCarritoTabletsRepository extends JpaRepository<ReservaCarritoTablets, ReservaCarritoTabletsId>
{
}
