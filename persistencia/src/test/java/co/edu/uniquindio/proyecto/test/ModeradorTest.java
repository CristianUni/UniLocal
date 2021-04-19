package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ModeradorTest {

    @Autowired
    private ModeradorRepo moderadorRepo;

    @Test
    public void registrarModeradorTest(){

        Moderador moderadorNuevo= new Moderador("juanito@gmail.com","juan manolo","Juannixo12","Elcapojuan12",20.124561,65.595684);
        Moderador moderadorGuardado= moderadorRepo.save(moderadorNuevo);

        Assertions.assertNotNull(moderadorGuardado);
    }

    @Test
    public void eliminarModeradorTest(){

        Moderador moderadorNuevo= new Moderador("juanito@gmail.com","juan manolo","Juannixo12","Elcapojuan12",20.124561,65.595684);
        moderadorRepo.save(moderadorNuevo);

        moderadorRepo.delete(moderadorNuevo);

        Moderador moderadorBorrado = moderadorRepo.findById("juanito@gmail.com").orElse(null);

        Assertions.assertNull(moderadorBorrado);
    }

    @Test
    public void actualizarModeradorTest() {

        Moderador moderadorNuevo= new Moderador("juanito@gmail.com","juan manolo","Juannixo12","Elcapojuan12",20.124561,65.595684);
        Moderador moderadorGuardado=moderadorRepo.save(moderadorNuevo);

        moderadorGuardado.setContrasena("estanosemeolvida123");
        moderadorRepo.save(moderadorGuardado);

        Moderador moderadorBuscado = moderadorRepo.findById("juanito@gmail.com").orElse(null);

        Assertions.assertEquals("estanosemeolvida123",moderadorBuscado.getContrasena());
    }

    @Test
    @Sql("classpath:moderadores.sql")
    public void listarModeradorTest(){
        List<Moderador> lista = moderadorRepo.findAll();
        System.out.println(lista);
    }
}
