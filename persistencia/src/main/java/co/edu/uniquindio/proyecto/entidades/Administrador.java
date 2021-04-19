package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Administrador extends Persona implements Serializable {

    @OneToMany(mappedBy = "administrador")
    private List<Moderador> moderadores;

    @OneToMany(mappedBy = "administrador")
    private List<Reporte> reportes;

    public Administrador(){
        super();
    }

    public Administrador(String email, String nombre, String nickname, String contrasena, double latitud, double longitud) {
        super(email, nombre, nickname, contrasena, latitud, longitud);
    }
}
