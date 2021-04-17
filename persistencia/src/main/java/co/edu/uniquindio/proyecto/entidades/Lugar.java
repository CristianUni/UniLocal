package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Lugar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" ,length = 10)
    private int id;
    @Column( name = "descripcion", length = 1000)
    private String descripcion;
    @Column( name = "nombre", length = 100)
    private String nombre;
    @Column( name = "direccion",length = 1000)
    private String direccion;
    @Column( name = "latitud",length = 100)
    private String latitud;
    @Column( name = "longitud",length = 100)
    private String longitud;




    //@OneToMany(mappedBy = "lugar")
    //private List<horario> horario;
    //@OneToOne(mappedBy = "luggar")
    //private Registrolugar registroLugar;
    //@OneToMany(mappedBy = "lugar")
    //private telefono telefono;
    @OneToOne
    private Categoria categoria;
    @ManyToOne
    private Ciudad ciudad;
    //@ManyToOne
    //private usuario usuario;
    //@OneToMany(mappedBy = "lugar")
    //private resena resena;
    @OneToMany(mappedBy = "lugar")
    private List<Imagen> imagen;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lugar lugar = (Lugar) o;
        return id == lugar.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Lugar(){
        super();
    }
}