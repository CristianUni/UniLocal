package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Telefono;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.TelefonoRepo;
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
public class TelefonoTest {

    @Autowired
    private TelefonoRepo telefonoRepo;

    @Test
    public void registrarTelefonoTest(){

        Telefono telefonoNuevo= new Telefono("3216496970");
        Telefono telefonoGuardado= telefonoRepo.save(telefonoNuevo);

        Assertions.assertNotNull(telefonoGuardado);
    }

    @Test
    public void eliminarTelefonoTest(){

        Telefono telefonoNuevo= new Telefono("3216496970");
        Telefono telefonoGuardado=telefonoRepo.save(telefonoNuevo);
        int llave = telefonoGuardado.getCodigo();

        telefonoRepo.delete(telefonoNuevo);

        Telefono telefonoBorrado = telefonoRepo.findById(llave).orElse(null);

        Assertions.assertNull(telefonoBorrado);
    }

    @Test
    public void actualizarTelefonoTest() {

        Telefono telefonoNuevo= new Telefono("3216496970");
        Telefono telefonoGuardado=telefonoRepo.save(telefonoNuevo);

        
        telefonoGuardado.setNumero("3217692122");
        telefonoRepo.save(telefonoGuardado);

        int llave = telefonoGuardado.getCodigo();

        Telefono telefonoBuscado = telefonoRepo.findById(llave).orElse(null);

        Assertions.assertEquals("3217692122",telefonoBuscado.getNumero());
    }

    @Test
    @Sql("classpath:telefono.sql")
    public void listarTelefonoTest(){
        List<Telefono> lista = telefonoRepo.findAll();
        System.out.println(lista);
    }
}
