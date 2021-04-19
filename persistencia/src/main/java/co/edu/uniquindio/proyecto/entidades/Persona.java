package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class Persona implements Serializable {

    @Id
    @Column(name = "email", length = 200)
    private String email;
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    @Column(name = "nickname", length = 100, nullable = false)
    private String nickname;
    @Column(name = "contrasena", length = 200, nullable = false)
    private String contrasena;
    @Column(name = "latitud", precision = 3, scale = 6)
    private double latitud;
    @Column(name = "longitud", precision = 2, scale = 6)
    private double longitud;

    public Persona(){
        super();
    }

    public Persona(String email, String nombre, String nickname, String contrasena, double latitud, double longitud) {
        this.email = email;
        this.nombre = nombre;
        this.nickname = nickname;
        this.contrasena = contrasena;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return email != null ? email.equals(persona.email) : persona.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
