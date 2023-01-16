package es.iesjandula.reservascarritos.repositories;

import es.iesjandula.reservascarritos.models.CarritoPcs;
import es.iesjandula.reservascarritos.models.ReservaCarritoPcsId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joaquín Moreno
 *
 * ReservaCarritoPcs Repository
 */
public interface IReservaCarritoPcsRepository extends JpaRepository<CarritoPcs, ReservaCarritoPcsId>
{
}
