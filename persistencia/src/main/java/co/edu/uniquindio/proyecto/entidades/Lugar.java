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
    @Column( name = "descripcion", length = 500)
    private String descripcion;
    @Column( name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column( name = "direccion",length = 100, nullable = false)
    private String direccion;
    @Column(name = "latitud", precision = 3, scale = 6, nullable = false)
    private double latitud;
    @Column(name = "longitud", precision = 2, scale = 6, nullable = false)
    private double longitud;


    @OneToMany(mappedBy = "lugar")
    private List<Horario> horario;
    @OneToOne(mappedBy = "lugar")
    private RegistroLugar registroLugar;
    @OneToMany(mappedBy = "lugar")
    private List<Telefono> telefono;
    @OneToOne
    private Categoria categoria;
    @ManyToOne
    private Ciudad ciudad;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "lugar")
    private List<Resena> resena;
    @OneToMany(mappedBy = "lugar")
    private List<Imagen> imagen;

    public Lugar(){
        super();
    }

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

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
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

}