package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RegistroLugar implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "estado", nullable = false)
    private Estado estado;
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_aprobacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;

    @ManyToOne
    private Moderador moderador;

    @OneToOne
    private Lugar lugar;

    public RegistroLugar() {
        super();
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fecha_aprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistroLugar that = (RegistroLugar) o;

        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }


    public RegistroLugar(Estado estado, Date fechaCreacion, Date fechaAprobacion) {
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaAprobacion = fechaAprobacion;
    }
}