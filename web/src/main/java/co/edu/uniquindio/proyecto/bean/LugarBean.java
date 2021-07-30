package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.RegistroLugar;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
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
    private RegistroLugar registroLugar;

    private final LugarServicio lugarServicio;

    public LugarBean(LugarServicio lugarServicio){
        this.lugarServicio=lugarServicio;
    }

    @PostConstruct
    public void inicializar(){
        lugar = new Lugar();
        registroLugar = new RegistroLugar();
    }

    public void crearLugar(){
        try {
            lugarServicio.crearLugar(lugar,registroLugar);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","El lugar se ha creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null,msg);
        }
        catch (Exception e){
            FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,msg);

        }
    }

    public Lugar getLugar() {
        return lugar;
    }

    public RegistroLugar getRegistroLugar() {
        return registroLugar;
    }

    public void setRegistroLugar(RegistroLugar registroLugar) {
        this.registroLugar = registroLugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
}
