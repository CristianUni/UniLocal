package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Dia;
import co.edu.uniquindio.proyecto.entidades.Horario;
import co.edu.uniquindio.proyecto.entidades.Resena;
import co.edu.uniquindio.proyecto.repositorios.HorarioRepo;
import co.edu.uniquindio.proyecto.repositorios.ResenaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HorarioTest {
    @Autowired
    private HorarioRepo horarioRepo;

    @Test
    public void registrarHorarioTest(){

        Horario horarioNuevo= new Horario("07:00 am","07:00 pm", Dia.LUNES);
        Horario horarioGuardado= horarioRepo.save(horarioNuevo);

        Assertions.assertNotNull(horarioGuardado);
    }

    @Test
    public void eliminarHorarioTest(){

        Horario horarioNuevo= new Horario("07:00 am","07:00 pm", Dia.LUNES);
        Horario horarioGuardado=horarioRepo.save(horarioNuevo);
        int llave = horarioGuardado.getCodigo();

        horarioRepo.delete(horarioNuevo);

        Horario horarioBorrado = horarioRepo.findById(llave).orElse(null);

        Assertions.assertNull(horarioBorrado);
    }

    @Test
    public void actualizarHorarioTest() {

        Horario horarioNuevo= new Horario("07:00 am","07:00 pm", Dia.LUNES);
        Horario horarioGuardado=horarioRepo.save(horarioNuevo);


        horarioGuardado.setHoraApertura("06:00 am");
        horarioRepo.save(horarioGuardado);

        int llave = horarioGuardado.getCodigo();

        Horario horarioBuscado = horarioRepo.findById(llave).orElse(null);

        Assertions.assertEquals("06:00 am",horarioBuscado.getHoraApertura());
    }

    @Test
    @Sql("classpath:horario.sql")
    public void listarHorarioTest(){
        List<Horario> lista = horarioRepo.findAll();
        System.out.println(lista);
    }
}
