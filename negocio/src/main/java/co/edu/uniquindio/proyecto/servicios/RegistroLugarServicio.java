package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.RegistroLugar;

public interface RegistroLugarServicio {
    RegistroLugar AutorizarLugares(RegistroLugar r, int estado) throws Exception;
    RegistroLugar RegistroLugar(RegistroLugar r) throws Exception;

    RegistroLugar CrearRegistroLugar(RegistroLugar registroLugar) throws Exception;

}
