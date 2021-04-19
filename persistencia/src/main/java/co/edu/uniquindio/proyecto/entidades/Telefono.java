package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name = "codigo")
    private int codigo;
    @Column( name = "numero",unique = true)
    @Positive
    private String numero;

    @ManyToOne
    private Lugar lugar;

    public Telefono() {
        super();
    }


    public Telefono(@Positive String numero) {

        this.numero = numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telefono telefono = (Telefono) o;

        return codigo == telefono.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
