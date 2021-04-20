package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

//Entidad Reporte
@Entity
public class Reporte implements Serializable {

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "descripcion", length = 1000, nullable = false)
    private String descripcion;

    //Relacion de Reporte y Adminstrador de muchos a uno
    @ManyToOne
    private Administrador administrador;

    //contructor sin parametros
    public Reporte(){
        super();
    }

    //constructor sobrecargado
    public Reporte(String descripcion) {
        this.descripcion = descripcion;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reporte reporte = (Reporte) o;

        return codigo == reporte.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}

