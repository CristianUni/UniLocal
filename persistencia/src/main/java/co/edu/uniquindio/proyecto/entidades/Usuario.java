package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Usuario extends Persona implements Serializable {

    @OneToMany(mappedBy = "usuario")
    private List<Lugar> lugares;

    @OneToMany(mappedBy = "usuario")
    private List<Resena> resenas;

    @ManyToOne
    private Ciudad ciudad;

    public Usuario(){
        super();
    }

    public Usuario(String email, String nombre, String nickname, String contrasena, double latitud, double longitud) {
        super(email, nombre, nickname, contrasena, latitud, longitud);
    }
}
