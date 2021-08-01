package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Resena;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component
@RequestScope
public class DetalleLugarBean implements Serializable {

    @Value("#{param['lugar']}")
    private String idLugar;

    @Autowired
    private LugarServicio lugarServicio;

    @Getter
    @Setter
    private Lugar lugar;

    @Getter
    @Setter
    private List<Resena> resenas;

    @Getter
    @Setter
    private List<Horario> horarios;

    @PostConstruct
    public void init() {
        if (idLugar != null && !"".equals(idLugar)) {
            try {
                int id = Integer.parseInt(idLugar);
                this.lugar = lugarServicio.obtenerLugar(id);
                this.resenas = lugarServicio.listarResenas(id);
                this.horarios = lugarServicio.listarHorario(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
