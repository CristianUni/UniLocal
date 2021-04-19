package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaTest {
    @Autowired
    private CategoriaRepo categoriaRepo;

    @Test
    public void registrarCategoriaTest(){

        Categoria categoriaNuevo= new Categoria("restaurante de mariscos","mariamar");
        Categoria categoriaGuardada= categoriaRepo.save(categoriaNuevo);

        Assertions.assertNotNull(categoriaGuardada);
    }

    @Test
    public void eliminarCategoriaTest(){

        Categoria categoriaNuevo= new Categoria("comida callejera","calleperro");
        categoriaRepo.save(categoriaNuevo);

        categoriaRepo.delete(categoriaNuevo);

        Categoria categoriaBorrado = categoriaRepo.findById(categoriaNuevo.getCodigo()).orElse(null);

        Assertions.assertNull(categoriaBorrado);
    }

    @Test
    public void actualizarCategoriaTest() {

        Categoria categoriaNuevo= new Categoria("restauante vegano","papucity");
        Categoria categoriaGuardado=categoriaRepo.save(categoriaNuevo);

        categoriaGuardado.setDescripcion("fabulosa comida arabe");
        categoriaRepo.save(categoriaGuardado);

        Categoria categoriaBuscado = categoriaRepo.findById(categoriaGuardado.getCodigo()).orElse(null);

        Assertions.assertEquals("fabulosa comida arabe",categoriaBuscado.getDescripcion());
    }

    @Test
    @Sql("classpath:categorias.sql")
    public void listarCategoriaTest(){
        List<Categoria> lista = categoriaRepo.findAll();
        System.out.println(lista);
    }
}
