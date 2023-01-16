package es.iesjandula.reservascarritos.repositories;

import es.iesjandula.reservascarritos.models.AulaInformatica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joaquín Moreno
 *
 * AulaInformatica Repository
 */
public interface IAulaInformaticaRepository extends JpaRepository<AulaInformatica,Long>
{
}
