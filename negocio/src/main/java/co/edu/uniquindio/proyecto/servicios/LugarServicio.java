package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;

import java.util.List;

public interface LugarServicio {

    List<Lugar> buscarPorNombre(String nombre) throws Exception;

    List<Lugar> buscarPorCategoria(int categoria) throws Exception;

    List<Lugar> buscarPorCategoriaYNombre(String nombre, int categoria) throws Exception;

    Lugar buscarPorNombreExacto(String nombre) throws Exception;

    Lugar crearLugar(Lugar l) throws Exception;

    void eliminarLugar(Integer id) throws Exception;

    Lugar actualizarLugar(Lugar lugar) throws Exception;

    List<Lugar> listarLugares();

    List<Categoria> listarCategorias();

    Lugar obtenerLugar(Integer id) throws Exception;

    Categoria crearCategoria(Categoria categoria) throws Exception;

    Categoria obtenerCategoria(Integer id) throws Exception;

    List<Resena> listarResenas(Integer idLugar);

    List<Horario> listarHorario(Integer idLugar);
    Telefono crearTelefono(Telefono telefono);

    void crearResena(Resena resena) throws  Exception;
}
