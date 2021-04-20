package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
//Entidad Resena del lugar incluye un comentario y una calificacion
@Entity
public class Resena implements Serializable {
    //Atributos pertenecientes a la Entidad Resena
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private int codigo;
    @Column(name = "calificacion", nullable = false)
    @Positive
    private int calificacion;
    @Column(name = "comentario",length = 500)
    private String comentario;

    //Relacion de Resena con Lugar de muchos a uno
    @ManyToOne
    private Lugar lugar;
    //Relacion de Resena con Usuario de muchos a uno
    @ManyToOne
    private Usuario usuario;

    public Resena(){
        super();
    }
    //Sobre carga de Constructor Resena con parametros Calificacion de tipo Entero y comentario Tipo String limitado a 500 caracteres
    public Resena(int calificacion, String comentario) {
        this.calificacion = calificacion;
        this.comentario = comentario;
    }
    //metodos Set y Get de los atributos de Resena
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    //Metodo equals and hashCode para corroborar la llave primaria codigo de la entidad Resena
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resena resena = (Resena) o;

        return codigo == resena.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
