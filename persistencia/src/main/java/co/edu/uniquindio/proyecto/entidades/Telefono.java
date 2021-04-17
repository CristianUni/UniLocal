package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name = "codigo",length=100)
    private int codigo;
    @Column( name = "numero", length = 10,unique = true)
    @Positive
    private int numero;

    @ManyToOne
    private Lugar lugar;

    public Telefono() {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
