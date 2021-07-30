package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.RegistroLugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
import co.edu.uniquindio.proyecto.repositorios.RegistroLugarRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LugarServicioImpl  implements LugarServicio {

    private final LugarRepo lugarRepo;
    private final RegistroLugarRepo registroLugarRepo;


    public LugarServicioImpl(LugarRepo lugarRepo, RegistroLugarRepo registroLugarRepo) {
        this.lugarRepo = lugarRepo;
        this.registroLugarRepo=registroLugarRepo;
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

    @Override
    public Lugar crearLugar(Lugar l, RegistroLugar r) throws Exception {
        if(l.getDireccion().trim().equals("")){
            throw new Exception("El campo de direccion está vacio ");
        }
        if(l.getNombre().trim().equals("")){
            throw new Exception("El campo del nombre está vacio ");
        }
        if(l.getDescripcion().length()>500){

            throw new Exception("La descripción debe contener menos de 500 caracteres");
        }
        if(l.getDireccion().length()>100 && l.getDireccion() != null){

            throw new Exception("La dirección debe contener menos de 100 caracteres");
        }
        if(l.getNombre().length() > 100 && l.getNombre() != null){

            throw new Exception("El nombre debe contener menos de 100 caracteres");
        } if(l.getDescripcion().length()>500){

            throw new Exception("La descripción debe contener menos de 500 caracteres");
        }
        if(l.getLatitud()>90 || l.getLatitud()<-90) {

            throw new Exception("El rango de la latitud debe ser de -90 a 90");
        }
        if(l.getLongitud()>180 || l.getLongitud()<-180){

            throw new Exception("El rango de la longitud debe ser de -180 a 180");
        }
        Lugar lugarNuevo= lugarRepo.save(l);
        r.setLugar(l);
        RegistroLugar registroLugar= registroLugarRepo.save(r);



        return lugarNuevo;

    }



    @Override
    public void eliminarLugar(Integer id) throws Exception {

    }

    @Override
    public Lugar actualizarLugar(Lugar lugar) throws Exception {
        return null;
    }

    @Override
    public List<Lugar> ListaLugares() {
        return lugarRepo.findAll();
    }

    @Override
    public Lugar obtenerLugar(Integer id) throws Exception {
        Optional<Lugar> objeto=lugarRepo.findById(id);

        if(objeto.isEmpty()){
            throw new Exception("El id no es valido");
        }
        return objeto.get();
    }

}
