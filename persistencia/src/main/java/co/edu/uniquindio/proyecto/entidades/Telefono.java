package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
//Entidad Telefono del Lugar
@Entity
public class Telefono implements Serializable {
    //Atributos pertenecientes a la Entidad Telefono
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name = "codigo")
    private int codigo;
    @Column( name = "numero",unique = true)
    @Positive
    private String numero;
    //Relacion de Telefono con Lugar de muchos a uno
    @ManyToOne
    private Lugar lugar;

    //Constructor Telefono sin parametros
    public Telefono() {
        super();
    }

    //Sobre carga de Constructor Telefono con parametro numero de tipo String
    public Telefono(@Positive String numero) {

        this.numero = numero;
    }
    //metodos Set y Get de los atributos de Telefono
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
    //Metodo equals and hashCode para corroborar la llave primaria codigo de la entidad Telefono
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
