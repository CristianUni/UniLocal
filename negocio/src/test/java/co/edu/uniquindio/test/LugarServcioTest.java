package co.edu.uniquindio.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.servicios.LugarServicio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class LugarServcioTest {

    @Autowired
    private LugarServicio lugarServicio;

    @Test
    @Sql("classpath:lugares.sql")
    public void listarLugaresPorNombreTest() throws Exception {

        List<Lugar> lista = lugarServicio.buscarPorNombre("maria");
        for(Lugar l:lista)
        System.out.println(l.getNombre());
    }

    @Test
    @Sql("classpath:lugares.sql")
    public void listarLugaresPorCatagoriaTest() throws Exception {

        List<Lugar> lista = lugarServicio.buscarPorCategoria(2);

        for(Lugar l:lista) {
            System.out.println(l.getNombre());

        }


    }

    @Test
    @Sql("classpath:lugares.sql")
    public void buscarPorCategoriaYNombreaTest() throws Exception {

        List<Lugar> lista = lugarServicio.buscarPorCategoriaYNombre("maria",2);

        for(Lugar l:lista) {
            System.out.println(l.getNombre());

        }


    }



}
