package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( name = "codigo")
    private int codigo;
    @Column( name = "hora_apertura", length = 8, nullable = false)
    private String horaApertura;
    @Column( name = "hora_cierre", length = 8, nullable = false)
    private String horaCierre;
    @Enumerated(EnumType.ORDINAL)
    @Column( name = "dia", nullable = false)
    private Dia dia;

    @ManyToOne
    private Lugar lugar;

    public Horario(){
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horCierre) {
        this.horaCierre = horaCierre;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Horario horario = (Horario) o;

        return codigo == horario.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

}
