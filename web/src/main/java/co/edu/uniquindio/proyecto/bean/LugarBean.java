package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.TelefonoRepo;
import co.edu.uniquindio.proyecto.servicios.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@RequestScope
public class LugarBean implements Serializable {

    private Lugar lugar;
    private Telefono telefono;

    private final LugarServicio lugarServicio;
    private final CiudadServicio ciudadServicio;
    private final CategoriaServicio categoriaServicio;
    private final UsuarioServicio usuarioServicio;

    @Getter @Setter
    private List<Ciudad> ciudades;

    @Getter @Setter
    private List<Categoria> categorias;


    public LugarBean(LugarServicio lugarServicio, CiudadServicio ciudadServicio, UsuarioServicio usuarioServicio, CategoriaServicio categoriaServicio, TelefonoServicio telefonoServicio) {
        this.lugarServicio = lugarServicio;
        this.ciudadServicio = ciudadServicio;
        this.usuarioServicio = usuarioServicio;
        this.categoriaServicio = categoriaServicio;
    }

    @PostConstruct
    public void inicializar() {
        this.lugar = new Lugar();
        this.telefono= new Telefono();
        this.ciudades = ciudadServicio.listarCiudades();
        this.categorias = lugarServicio.listarCategorias();
    }

    public String crearLugar() {
        try {
            //lugar.setCategoria(categoriaServicio.obtenerCategoria(1));
            //lugar.setCiudad(ciudadServicio.obtenerCiudad(1));
            lugar.setUsuario(usuarioServicio.buscarUsuario("eljhoiner@gmail.com"));
            System.out.println(telefono.getNumero());


           Lugar l = lugarServicio.crearLugar(lugar);
            telefono.setLugar(l);
            lugarServicio.crearTelefono(telefono);
            return "lugarCreado?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage() + " mori");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return null;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
}
