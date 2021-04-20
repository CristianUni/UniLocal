package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//Entidad Moderador el cual heredará de Persona sus atributos y metodos
@Entity
public class Moderador extends Persona implements Serializable {

    //Relacion de Moderador y Administrador de muchos a uno
    @ManyToOne
    private Administrador administrador;

    //Relacion de Moderador y RegistroLugar de uno a muchos
    @OneToMany(mappedBy = "moderador")
    private List<RegistroLugar> registroLugares;

    //contructor sin parametros
    public Moderador(){
        super();
    }

    //constructor sobrecargado
    public Moderador(String email, String nombre, String nickname, String contrasena, double latitud, double longitud) {
        super(email, nombre, nickname, contrasena, latitud, longitud);
    }
}
