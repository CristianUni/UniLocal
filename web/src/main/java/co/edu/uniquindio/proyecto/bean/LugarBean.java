package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.RegistroLugar;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicio;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@RequestScope
public class LugarBean implements Serializable {

    private Lugar lugar;

    private final LugarServicio lugarServicio;

    private final CiudadServicio ciudadServicio;
    private final CategoriaServicio categoriaServicio;
    private final UsuarioServicio usuarioServicio;

    public LugarBean(LugarServicio lugarServicio, CiudadServicio ciudadServicio, UsuarioServicio usuarioServicio, CategoriaServicio categoriaServicio) {
        this.lugarServicio = lugarServicio;
        this.ciudadServicio = ciudadServicio;
        this.usuarioServicio = usuarioServicio;
        this.categoriaServicio = categoriaServicio;
    }

    @PostConstruct
    public void inicializar() {
        lugar = new Lugar();
    }

    public String crearLugar() {
        try {
            lugar.setCategoria(categoriaServicio.obtenerCategoria(1));
            lugar.setCiudad(ciudadServicio.obtenerCiudad(1));
            lugar.setUsuario(usuarioServicio.buscarUsuario("eljhoiner@gmail.com"));

            lugarServicio.crearLugar(lugar);

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
}
