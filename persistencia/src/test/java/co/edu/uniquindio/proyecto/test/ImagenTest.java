package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Imagen;
import co.edu.uniquindio.proyecto.repositorios.ImagenRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ImagenTest {

    @Autowired
    private ImagenRepo imagenRepo;

    @Test
    public void registrarImagenTest(){

        Imagen imagenNueva= new Imagen("c:/imagen/img.jpg");
        Imagen imagenGuardada= imagenRepo.save(imagenNueva);

        Assertions.assertNotNull(imagenGuardada);
    }

    @Test
    public void eliminarImagenTest(){

        Imagen imagenNueva= new Imagen("c:/imagen/img.jpg");
        Imagen imagenGuardada=imagenRepo.save(imagenNueva);
        int llave = imagenGuardada.getCodigo();

        imagenRepo.delete(imagenNueva);

        Imagen imagenBorrada = imagenRepo.findById(llave).orElse(null);

        Assertions.assertNull(imagenBorrada);
    }

    @Test
    public void actualizarImagenTest() {

        Imagen imagenNueva= new Imagen("c:/imagen/im33g.jpg");
        Imagen imagenGuardada= imagenRepo.save(imagenNueva);
        int llave = imagenGuardada.getCodigo();

        imagenGuardada.setLink("c:/usuarios/imagenes/nueva.jpg");
        imagenRepo.save(imagenGuardada);

        Imagen imagenBuscada = imagenRepo.findById(llave).orElse(null);

        Assertions.assertEquals("c:/usuarios/imagenes/nueva.jpg",imagenBuscada.getLink());
    }

    @Test
    @Sql("classpath:imagenes.sql")
    public void listarImagenesTest(){
        List<Imagen> lista = imagenRepo.findAll();
        System.out.println(lista);
    }

}
