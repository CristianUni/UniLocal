package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Registro_Lugar implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "codigo", length = 10)
    private int codigo;

    @Column(name = "estado")
    private Estado estado;
    @Column(name = "fecha_creacion")
    private Date fecha_creacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.DATE)
    private Date fecha_aprobacion;

    @ManyToOne
    private Moderador moderador;

    @OneToOne
    private Lugar lugar;

    public Registro_Lugar() {
        super();
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getUsuario_moderador() {
        return usuario_moderador;
    }

    public void setUsuario_moderador(String usuario_moderador) {
        this.usuario_moderador = usuario_moderador;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_aprobacion() {
        return fecha_aprobacion;
    }

    public void setFecha_aprobacion(Date fecha_aprobacion) {
        this.fecha_aprobacion = fecha_aprobacion;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registro_Lugar that = (Registro_Lugar) o;

        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }



}