package es.iesjandula.reservascarritos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Joaquín Moreno
 *
 * Launcher
 */
@SpringBootApplication
@EnableJpaRepositories
public class ReservasCarritosApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ReservasCarritosApplication.class, args);
    }

}
