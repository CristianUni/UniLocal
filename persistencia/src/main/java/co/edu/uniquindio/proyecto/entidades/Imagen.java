package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "link",length = 1000, nullable = false)
    private String link;

    @ManyToOne
    private Lugar lugar;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imagen imagen = (Imagen) o;
        return codigo == imagen.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public Imagen(){
        super();
    }

    public Imagen( String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "codigo=" + codigo +
                ", link='" + link + '\'' +
                '}';
    }
}
