package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.RegistroLugar;

public interface RegistroLugarServicio {
    RegistroLugar AutorizarLugares(RegistroLugar r, boolean estado) throws Exception;
    
}
