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
    @Column( name = "descripcion", length = 10)
    private String descripcion;
    @Column( name = "nombre", length = 10)
    private String nombre;
    @Column( name = "codigo_horario",length = 100,unique = true)
    @Positive
    private int codigo_horario;
    @Column( name = "email_usuario",length = 100,unique = true)
    private String email_usuario;
    @Column( name = "codigo_categoria",length = 100)
    @Positive
    private int codigo_categoria;
    @Column( name = "direccion",length = 1000)
    private String direccion;
    @Column( name = "latitud",length = 100)
    private String latitud;
    @Column( name = "longitud",length = 100)
    private String longitud;
    @Column( name = "codigo_ciudad",length = 100)
    @Positive
    private int codigo_ciudad;



    //@OneToMany(mappedBy = "lugar")
    //private List<horario> horario;
    //@OneToOne(mappedBy = "luggar")
    //private Registrolugar registroLugar;
    //@OneToMany(mappedBy = "lugar")
    //private telefono telefono;
    @OneToOne
    private Categoria categoria;
    //@ManyToOne
    //private ciudad ciudad;
    //@ManyToOne
    //private usuario usuario;
    //@OneToMany(mappedBy = "lugar")
    //private resena resena;
    //@OneToMany(mappedBy = "lugar")
    //private imagen imagen;


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

    public int getCodigo_horario() {
        return codigo_horario;
    }

    public void setCodigo_horario(int codigo_horario) {
        this.codigo_horario = codigo_horario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public int getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(int codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
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

    public int getCodigo_ciudad() {
        return codigo_ciudad;
    }

    public void setCodigo_ciudad(int codigo_ciudad) {
        this.codigo_ciudad = codigo_ciudad;
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
