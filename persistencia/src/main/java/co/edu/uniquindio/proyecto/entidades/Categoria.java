package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {


    //atributos de la calse Categoria
    //llave primaria id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "codigo")
    private int codigo;
    @Column( name = "descripcion", length = 200)
    private String descripcion;
    @Column( name = "nombre", length = 50, nullable = false)
    private String nombre;


    //relacion uno a uno categoria y lugar(entidad propietaria)
    @OneToMany(mappedBy = "categoria")
    private List<Lugar> lugar;


    //get y set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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


    //metodos para comparar la llave primaria
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(codigo, categoria.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


    //constructor vacio
    public Categoria(){super(); }

    //constructor Categoria sobrecarga
    public Categoria(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
}