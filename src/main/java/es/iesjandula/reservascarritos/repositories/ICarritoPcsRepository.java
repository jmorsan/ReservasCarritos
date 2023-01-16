package es.iesjandula.reservascarritos.repositories;

import es.iesjandula.reservascarritos.models.CarritoPcs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joaquín Moreno
 *
 * CarritoPcs Repository
 */
public interface ICarritoPcsRepository extends JpaRepository<CarritoPcs,Long>
{

}
