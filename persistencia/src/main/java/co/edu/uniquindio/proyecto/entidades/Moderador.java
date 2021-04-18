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
}
