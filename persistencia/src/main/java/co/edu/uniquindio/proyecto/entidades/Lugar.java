package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Lugar implements Serializable {

    //atributos de la clase lugar
    //llave primaria id
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

    //relaciones entre entidades
    //relacion uno a muchos entre lugar y horario(entidad propietaria)
    @OneToMany(mappedBy = "lugar")
    private List<Horario> horario;
    //relacion uno a uno entre lugar y registrolugar(entidad propietaria)
    @OneToOne(mappedBy = "lugar")
    private RegistroLugar registroLugar;
    //relacion uno a muchos entre lugar y telefono(entidad propietaria)
    @OneToMany(mappedBy = "lugar")
    private List<Telefono> telefono;
    //relacion uno a uno entre lugar y categoria
    @OneToOne
    private Categoria categoria;
    //relacion muchos a uno entre lugar y ciudad
    @ManyToOne
    private Ciudad ciudad;
    //relacion muchos a uno entre lugar y usuario
    @ManyToOne
    private Usuario usuario;
    @ManyToMany
    private List<Usuario> usuarios;
    //relacion uno a muchos entre lugar y resena(entidad propietaria)
    @OneToMany(mappedBy = "lugar")
    private List<Resena> resena;
    //relacion uno a muchos entre lugar y imagen(entidad propietaria)
    @OneToMany(mappedBy = "lugar")
    private List<Imagen> imagen;



    //get y set
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


    //metodos de comparacion de la llave primaria
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

    //metodo constructor de lugar
    public Lugar( String descripcion, String nombre, String direccion, double latitud, double longitud) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}