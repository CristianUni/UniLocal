package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
public class Resena implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private int codigo;
    @Column(name = "calificacion", nullable = false)
    @Positive
    private int calificacion;
    @Column(name = "comentario",length = 500)
    private String comentario;

    @ManyToOne
    private Lugar lugar;

    @ManyToOne
    private Usuario usuario;

    public Resena(){
        super();
    }

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
