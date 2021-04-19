package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.RegistroLugar;
import co.edu.uniquindio.proyecto.repositorios.RegistroLugarRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegistroLugarTest {

    @Autowired
    private RegistroLugarRepo registroLugarRepo;

    @Test
    public void registrarRegistroLugarTest() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaCreacion = sdf.parse("1996/02/14");
        Date fechaAprobacion = sdf.parse("2021/01/16");

        RegistroLugar registroLugarNuevo= new RegistroLugar(Estado.APROBADO, fechaCreacion, fechaAprobacion);
        RegistroLugar registroLugarGuardado= registroLugarRepo.save(registroLugarNuevo);

        Assertions.assertNotNull(registroLugarGuardado);
    }

    @Test
    public void eliminarRegistroLugarTest() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaCreacion = sdf.parse("1996/02/14");
        Date fechaAprobacion = sdf.parse("2021/01/16");

        RegistroLugar registroLugarNuevo= new RegistroLugar(Estado.EN_ESPERA, fechaCreacion, fechaAprobacion);
        RegistroLugar registroLugarGuardado= registroLugarRepo.save(registroLugarNuevo);
        int llave = registroLugarGuardado.getCodigo();

        registroLugarRepo.delete(registroLugarNuevo);

        RegistroLugar registroLugarBorrado = registroLugarRepo.findById(llave).orElse(null);

        Assertions.assertNull(registroLugarBorrado);
    }

    @Test
    public void actualizarCiudadTest() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaCreacion = sdf.parse("1996/02/14");
        Date fechaAprobacion = sdf.parse("2021/01/16");

        RegistroLugar registroLugarNuevo= new RegistroLugar(Estado.EN_ESPERA, fechaCreacion, fechaAprobacion);
        RegistroLugar registroLugarGuardado= registroLugarRepo.save(registroLugarNuevo);

        int llave = registroLugarGuardado.getCodigo();

        registroLugarGuardado.setEstado(Estado.APROBADO);
        registroLugarRepo.save(registroLugarGuardado);

        RegistroLugar registroLugarBuscado = registroLugarRepo.findById(llave).orElse(null);

        Assertions.assertEquals(Estado.APROBADO,registroLugarBuscado.getEstado());
    }

    @Test
    @Sql("classpath:registroLugar.sql")
    public void listarRegistroLugaresTest(){
        List<RegistroLugar> lista = registroLugarRepo.findAll();
        System.out.println(lista);
    }


}
