package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void registrarUsuarioTest(){

        Usuario usuarioNuevo= new Usuario("juanito@gmail.com","juan manolo","Juannixo12","Elcapojuan12",20.124561,65.595684);
        Usuario usuarioGuardado= usuarioRepo.save(usuarioNuevo);

        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    public void eliminarUsuarioTest(){

        Usuario usuarioNuevo= new Usuario("juanito@gmail.com","juan manolo","Juannixo12","Elcapojuan12",20.124561,65.595684);
        usuarioRepo.save(usuarioNuevo);

        usuarioRepo.delete(usuarioNuevo);

        Usuario usuarioBorrado = usuarioRepo.findById("juanito@gmail.com").orElse(null);

        Assertions.assertNull(usuarioBorrado);
    }

    @Test
    public void actualizarUsuarioTest() {

        Usuario usuarioNuevo= new Usuario("juanito@gmail.com","juan manolo","Juannixo12","Elcapojuan12",20.124561,65.595684);
        Usuario usuarioGuardado=usuarioRepo.save(usuarioNuevo);

        usuarioGuardado.setContrasena("estanosemeolvida123");
        usuarioRepo.save(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById("juanito@gmail.com").orElse(null);

        Assertions.assertEquals("estanosemeolvida123",usuarioBuscado.getContrasena());
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosTest(){
        List<Usuario> lista = usuarioRepo.findAll();
        System.out.println(lista);
    }
}
