package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//Entidad Usuario el cual heredará de Persona sus atributos y metodos
@Entity
public class Usuario extends Persona implements Serializable {

    //Relacion de Usuario y lugar de uno a muchos
    @OneToMany(mappedBy = "usuario")
    private List<Lugar> lugares;

    //Relacion de Usuario y Resena de uno a muchos
    @OneToMany(mappedBy = "usuario")
    private List<Resena> resenas;

    //Relacion de Usuario y Ciudad de muchos a uno
    @ManyToOne
    private Ciudad ciudad;

    //contructor sin parametros
    public Usuario(){
        super();
    }

    //constructor sobrecargado
    public Usuario(String email, String nombre, String nickname, String contrasena, double latitud, double longitud) {
        super(email, nombre, nickname, contrasena, latitud, longitud);
    }
}
