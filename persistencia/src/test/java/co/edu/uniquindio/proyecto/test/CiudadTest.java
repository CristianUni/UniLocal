package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void registrarCiudadTest(){

        Ciudad ciudadNueva= new Ciudad("Armenia");
        Ciudad ciudadGuardada= ciudadRepo.save(ciudadNueva);

        Assertions.assertNotNull(ciudadGuardada);
    }

    @Test
    public void eliminarImagenTest(){

        Ciudad ciudadNueva= new Ciudad("Circasia");
        Ciudad ciudadGuardada=ciudadRepo.save(ciudadNueva);
        int llave = ciudadGuardada.getCodigo();

        ciudadRepo.delete(ciudadNueva);

        Ciudad ciudadBorrada = ciudadRepo.findById(llave).orElse(null);

        Assertions.assertNull(ciudadBorrada);
    }

    @Test
    public void actualizarCiudadTest() {

        Ciudad ciudadNueva= new Ciudad("Calarcá");
        Ciudad ciudadGuardada= ciudadRepo.save(ciudadNueva);
        int llave = ciudadGuardada.getCodigo();

        ciudadGuardada.setNombre("Quimbaya");
        ciudadRepo.save(ciudadGuardada);

        Ciudad ciudadBuscada = ciudadRepo.findById(llave).orElse(null);

        Assertions.assertEquals("Quimbaya",ciudadBuscada.getNombre());
    }

    @Test
    @Sql("classpath:ciudades.sql")
    public void listarImagenesTest(){
        List<Ciudad> lista = ciudadRepo.findAll();
        System.out.println(lista);
    }
}
