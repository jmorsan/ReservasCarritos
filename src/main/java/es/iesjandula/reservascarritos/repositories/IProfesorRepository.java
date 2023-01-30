package es.iesjandula.reservascarritos.repositories;

import es.iesjandula.reservascarritos.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * @author Joaquín Moreno
 *
 * Profesor Repository
 */
public interface IProfesorRepository extends JpaRepository<Profesor,Long>
{

}
