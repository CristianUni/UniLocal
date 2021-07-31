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

/*
Clase que sirve para hacer los respectivas pruebas unitarias del CRUD de la entidad RegistroLugar
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegistroLugarTest {

    //Atributo que referencia al repositorio de datos. el @Autowired sirve para que se autoinicialice el atributo
    @Autowired
    private RegistroLugarRepo registroLugarRepo;

    //Método de prueba para hacer un registro
    @Test
    public void registrarRegistroLugarTest() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaCreacion = sdf.parse("1996/02/14");
        Date fechaAprobacion = sdf.parse("2021/01/16");

        RegistroLugar registroLugarNuevo = new RegistroLugar(Estado.APROBADO, fechaCreacion, fechaAprobacion);
        RegistroLugar registroLugarGuardado = registroLugarRepo.save(registroLugarNuevo);

        Assertions.assertNotNull(registroLugarGuardado);
    }

    //Método de prueba para eliminar un registro de un lugar
    @Test
    public void eliminarRegistroLugarTest() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaCreacion = sdf.parse("1996/02/14");
        Date fechaAprobacion = sdf.parse("2021/01/16");

        RegistroLugar registroLugarNuevo = new RegistroLugar(Estado.EN_ESPERA, fechaCreacion, fechaAprobacion);
        RegistroLugar registroLugarGuardado = registroLugarRepo.save(registroLugarNuevo);
        int llave = registroLugarGuardado.getCodigo();

        registroLugarRepo.delete(registroLugarNuevo);

        RegistroLugar registroLugarBorrado = registroLugarRepo.findById(llave).orElse(null);

        Assertions.assertNull(registroLugarBorrado);
    }

    //Método de prueba para actualizar el estado de un registro
    @Test
    public void actualizarRegistroLugarTest() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaCreacion = sdf.parse("1996/02/14");
        Date fechaAprobacion = sdf.parse("2021/01/16");

        RegistroLugar registroLugarNuevo = new RegistroLugar(Estado.EN_ESPERA, fechaCreacion, fechaAprobacion);
        RegistroLugar registroLugarGuardado = registroLugarRepo.save(registroLugarNuevo);

        int llave = registroLugarGuardado.getCodigo();

        registroLugarGuardado.setEstado(Estado.APROBADO);
        registroLugarRepo.save(registroLugarGuardado);

        RegistroLugar registroLugarBuscado = registroLugarRepo.findById(llave).orElse(null);

        Assertions.assertEquals(Estado.APROBADO, registroLugarBuscado.getEstado());
    }

    //Método de prueba para listar los datos de una base de datos de sql
    @Test
    @Sql("classpath:registroLugar.sql")
    public void listarRegistroLugaresTest() {
        List<RegistroLugar> lista = registroLugarRepo.findAll();
        System.out.println(lista);
    }


}
