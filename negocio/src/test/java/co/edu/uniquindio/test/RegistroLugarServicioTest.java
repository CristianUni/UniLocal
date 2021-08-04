package co.edu.uniquindio.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.RegistroLugar;
import co.edu.uniquindio.proyecto.servicios.RegistroLugarServicio;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {NegocioApplication.class}
)
@Transactional
public class RegistroLugarServicioTest {
    @Autowired
    private RegistroLugarServicio registroLugarServicio;

    public RegistroLugarServicioTest() {
    }

    @Test
    public void AutorizarLugarTest() throws Exception {
        Date fechai = new GregorianCalendar(2020, 03, 1).getTime();/*LocalDate.of(2020, 3, 1)*/
        ;
        RegistroLugar RegistroLugarNuevo1 = new RegistroLugar(Estado.EN_ESPERA, fechai);
        RegistroLugar RegistroLugarGuardado = this.registroLugarServicio.AutorizarLugares(RegistroLugarNuevo1, 1);
        System.out.println(RegistroLugarGuardado.getEstado());
        System.out.println(RegistroLugarGuardado.getFechaAprobacion());
        System.out.println(RegistroLugarGuardado.getFechaCreacion());
        Assertions.assertNotNull(RegistroLugarGuardado);
    }
}
