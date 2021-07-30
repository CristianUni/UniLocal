package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.RegistroLugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface LugarServicio {

List<Lugar> buscarPorNombre(String nombre ) throws Exception;
List<Lugar> buscarPorCategoria(int categoria) throws Exception;
List<Lugar>  buscarPorCategoriaYNombre(String nombre, int categoria) throws Exception;
Lugar buscarPorNombreExacto (String nombre) throws Exception;
Lugar crearLugar(Lugar l) throws Exception;
void eliminarLugar(Integer id) throws Exception;
Lugar actualizarLugar(Lugar lugar) throws Exception;
List<Lugar>  ListaLugares();
Lugar obtenerLugar(Integer id) throws Exception;


}
