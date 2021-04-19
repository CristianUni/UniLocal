package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Moderador extends Persona implements Serializable {

    @ManyToOne
    private Administrador administrador;

    @OneToMany(mappedBy = "moderador")
    private List<RegistroLugar> registroLugares;

    public Moderador(){
        super();
    }

    public Moderador(String email, String nombre, String nickname, String contrasena, double latitud, double longitud) {
        super(email, nombre, nickname, contrasena, latitud, longitud);
    }
}
