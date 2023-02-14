package es.iesjandula.reservascarritos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.authorizeHttpRequests()
                // /* -> Todos los endpoints en ese nivel. Ejemplo: /reservas , /mostrarAula,...
                // /** -> Todos los endpoints y todos los de dentro de estos(recursivo). Ejemplo: /reservas/carritos/pcs...

                .requestMatchers("/reservas/mostrar_reservas_carrito_tablets").hasRole("User_Carrito_Tablets")
                .requestMatchers("/reservas/mostrar_reservas_carrito_pcs","/reservas/reservar_carrito_pcs").hasRole("User_Carrito_Pcs")
                .requestMatchers("/**").hasRole("ADMIN")
                .and().formLogin()
                .and().httpBasic();

        return  httpSecurity.build();

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        return  new InMemoryUserDetailsManager(
                User.withUsername("Admin").password("{noop}demo").roles("ADMIN").build(),
                User.withUsername("User1").password("{noop}demo").roles("User_Carrito_Tablets").build(),
                User.withUsername("User2").password("{noop}demo").roles("User_Carrito_Pcs").build()

        );
    }
}
