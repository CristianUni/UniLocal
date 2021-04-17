package co.edu.uniquindio.proyecto.entidades;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo",length = 10)
    private int codigo;
    @Column(name="nombre",length = 100)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Lugar> lugar;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return codigo == ciudad.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public Ciudad(){
        super();
    }
}