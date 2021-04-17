package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
public class Resena implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo",length = 10)
    private int codigo;
    @Column(name = "calificacion", length = 1)
    @Positive
    private int calificacion;
    @Column(name = "email_usuario",length = 100,unique = true)
    private String email_usuario;
    @Column(name = "comentario",length = 1000)
    private String comentario;
    @Column(name = "id_lugar",length = 10,unique = true)
    @Positive
    private int id_lugar;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    @ManyToOne
    private Lugar lugar;

    @ManyToOne
    private Usuario usuario;

    public Resena(){
        super();

    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
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
