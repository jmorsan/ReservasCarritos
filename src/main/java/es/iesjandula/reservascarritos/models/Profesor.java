package es.iesjandula.reservascarritos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 25, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellidos;

    public Profesor(){
        //Empty Constructor
    }
}
