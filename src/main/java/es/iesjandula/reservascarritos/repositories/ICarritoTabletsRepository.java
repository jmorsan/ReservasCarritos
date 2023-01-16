package es.iesjandula.reservascarritos.repositories;

import es.iesjandula.reservascarritos.models.CarritoTablets;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joaquín Moreno
 *
 * CarritoTablets Repository
 */
public interface ICarritoTabletsRepository extends JpaRepository<CarritoTablets,Long>
{
}
