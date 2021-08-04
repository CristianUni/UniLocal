package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RegistroLugar implements Serializable {

    //Llave principal de la entidad que en este caso es un código autogenerado de tipo entero
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    /*
        Atributo de la entidad que es de tipo enum. Este atributo nos indica el estado de el lugar,
         si está aprobado, rechazado o en espera de aprobación
         El atributo no puede ser null
         */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "estado", nullable = false)
    @NotBlank(message = "Estado es obligatorio")
    private Estado estado;
    /*
    Atributo de la entidad que es de tipo date. Este atributo nos indica la fecha de creación de la solicitud del registro del lugar
    El atributo no puede ser null
     */
    @NotBlank(message = "Fecha de creacion es obligatoria")
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    /*
    Atributo de la entidad que es de tipo date. Este atributo nos indica la fecha de aprobación de la solicitud del registro del lugar
    El atributo no puede ser null
     */
    @Column(name = "fecha_aprobacion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;

    //Relación con la entidad Moderador. Nos indica que un moderador tiene muchas solicitudes de registroLugar
    @Getter
    @Setter
    @ManyToOne
    private Moderador moderador;

    //Relación con la entidad Lugar. Nos indica que un Lugar tiene una solicitud de registro y un registro tiene un lugar
    @Getter
    @Setter
    @OneToOne
    private Lugar lugar;

    //Constructor vacío de la entidad
    public RegistroLugar() {
        super();
    }

    public RegistroLugar(Estado enEspera, Date fechai) {
        this.estado = enEspera;
        this.fechaCreacion = fechai;
    }

    /*
    Métodos get y set de la entidad. Los set nos sirve para asignarle valores a los atributos.
    Los get sirven para obtener los valores de los atributos
     */

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

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }





    /*
    Constructor sobrecargado que recibe por parámetro el estado del registro, la fecha de creación de la solitud
    y la fecha de aprobación de la solicitud
     */

    public RegistroLugar(Estado estado, Date fechaCreacion, Date fechaAprobacion) {
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaAprobacion = fechaAprobacion;
    }


}