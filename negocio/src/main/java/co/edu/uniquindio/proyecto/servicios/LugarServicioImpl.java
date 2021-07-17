package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
import org.springframework.stereotype.Service;

@Service
public class LugarServicioImpl  implements LugarServicio{

        private final LugarRepo lugarRepo;


    public LugarServicioImpl(LugarRepo lugarRepo) {
        this.lugarRepo = lugarRepo;
    }
}
