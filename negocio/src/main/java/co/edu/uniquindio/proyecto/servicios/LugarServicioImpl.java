package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarServicioImpl  implements LugarServicio {

    private final LugarRepo lugarRepo;


    public LugarServicioImpl(LugarRepo lugarRepo) {
        this.lugarRepo = lugarRepo;
    }

    //
    @Override
    public List<Lugar> buscarPorNombre(String nombre) throws Exception {
        List<Lugar> buscado = lugarRepo.buscarPorCampo(nombre);
        if (buscado == null || buscado.size() == 0) {
            throw new Exception("No se encuentra ningun lugar con ese nombre");
        }

        return buscado;
    }

    @Override
    public List<Lugar> buscarPorCategoria(int nombre) throws Exception {
        List<Lugar> buscado = lugarRepo.buscarPorCateoria(nombre);
        if (buscado == null || buscado.size() == 0) {
            throw new Exception("No se encuentra ningun lugar con esa categoria");
        }
        return buscado;
    }


    @Override
    public List<Lugar> buscarPorCategoriaYNombre(String nombre, int categoriaId) throws Exception {
        List<Lugar> buscado = lugarRepo.buscarPorCateoriaYNombre(nombre, categoriaId);
        if (buscado == null || buscado.size() == 0) {
            List<Lugar> buscadoCategoria = lugarRepo.buscarPorCateoria(categoriaId);
            List<Lugar> buscadoNombre = lugarRepo.buscarPorCampo(nombre);

            if ((buscadoCategoria == null || buscadoCategoria.size() == 0) && (buscadoNombre == null || buscadoNombre.size() == 0)) {
                throw new Exception("No se encuentra ningun lugar con ese nombre ni categoria");
            } else if (buscadoCategoria == null || buscadoCategoria.size() == 0) {
                throw new Exception("No se encuentra ningun lugar con esa categoria");
            } else {
                throw new Exception("No se encuentra ningun lugar con ese nombre");

            }

        }

        return buscado;
    }

    //

    public Lugar buscarPorNombreExacto (String nombre) throws Exception {
        Lugar lugar = lugarRepo.findByNombre(nombre);

        if (lugar == null){
            throw new Exception("Lugar no encontrado");
        }
        return lugar;
    }

}
