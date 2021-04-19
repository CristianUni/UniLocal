package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Reporte;
import co.edu.uniquindio.proyecto.repositorios.ReporteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReporteTest {

    @Autowired
    private ReporteRepo reporteRepo;

    @Test
    public void registrarReporteTest(){

        Reporte reporteNuevo= new Reporte("Cantidad masculinos:45, Cantidad femeninos:65");
        Reporte reporteGuardado= reporteRepo.save(reporteNuevo);

        Assertions.assertNotNull(reporteGuardado);
    }

    @Test
    public void eliminarReporteTest(){

        Reporte reporteNuevo= new Reporte("Cantidad masculinos:45, Cantidad femeninos:65");
        reporteRepo.save(reporteNuevo);

        reporteRepo.delete(reporteNuevo);

        Reporte reporteBorrado = reporteRepo.findById(reporteNuevo.getCodigo()).orElse(null);

        Assertions.assertNull(reporteBorrado);
    }

    @Test
    public void actualizarReporteTest() {

        Reporte reporteNuevo= new Reporte("Cantidad masculinos:45, Cantidad femeninos:65");
        Reporte reporteGuardado=reporteRepo.save(reporteNuevo);

        reporteGuardado.setDescripcion("Cantidad masculinos:60, Cantidad femeninos:85");
        reporteRepo.save(reporteGuardado);

        Reporte reporteBuscado = reporteRepo.findById(reporteNuevo.getCodigo()).orElse(null);

        Assertions.assertEquals("Cantidad masculinos:60, Cantidad femeninos:85",reporteBuscado.getDescripcion());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarReporteTest(){
        List<Reporte> lista = reporteRepo.findAll();
        System.out.println(lista);
    }
}
