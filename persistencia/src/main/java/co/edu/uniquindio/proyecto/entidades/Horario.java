package co.edu.uniquindio.proyecto.entidades;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Horario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column( name = "codigo",length=10)
    private int codigo;
    @Column( name = "hora_apertura", length = 8)
    private String hora_apertura;
    @Column( name = "hora_cierre", length = 8)
    private String hora_cierre;

    @Enumerated(EnumType.STRING)
    @Column( name = "dia",unique =true)
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

    public String getHora_apertura() {
        return hora_apertura;
    }

    public void setHora_apertura(String hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    public String getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(String hora_cierre) {
        this.hora_cierre = hora_cierre;
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
