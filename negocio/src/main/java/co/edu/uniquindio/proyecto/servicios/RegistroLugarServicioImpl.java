package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.RegistroLugar;
import co.edu.uniquindio.proyecto.repositorios.RegistroLugarRepo;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class RegistroLugarServicioImpl implements RegistroLugarServicio {
    private final RegistroLugarRepo registroLugarRepo;

    public RegistroLugarServicioImpl(RegistroLugarRepo registroLugarRepo) {
        this.registroLugarRepo = registroLugarRepo;
    }

    public RegistroLugar AutorizarLugares(RegistroLugar r, boolean estado) {
        if (estado) {
            r.setEstado(Estado.APROBADO);
            Date ahora = new Date();
            r.setFechaAprobacion(ahora);
            System.out.println("el contexto tiene un precio"+ ahora);
            PrintStream var10000 = System.out;
            LocalDate var10001 = LocalDate.now();
            var10000.println(var10001 + " fechisimo" + r.getFechaAprobacion());
        }

        if (!estado) {
            r.setEstado(Estado.RECHAZADO);
        }

        return r;
    }
}
