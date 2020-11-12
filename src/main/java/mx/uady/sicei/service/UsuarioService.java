package mx.uady.sicei.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.model.Usuario;
import mx.uady.sicei.model.request.UsuarioRequest;
import mx.uady.sicei.repository.AlumnoRepository;
import mx.uady.sicei.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    /*@Transactional
    public Usuario crear(UsuarioRequest request) {
        Usuario usuarioCrear = new Usuario();

        usuarioCrear.setUsuario(request.getUsuario());
        usuarioCrear.setPassword(request.getPassword());

        String token = UUID.randomUUID().toString();
        usuarioCrear.setToken(token);

        Usuario usuarioGuardado = usuarioRepository.save(usuarioCrear);

        Alumno alumno = new Alumno();

        alumno.setNombre(request.getNombre());
        alumno.setUsuario(usuarioGuardado); // Relacionar 2 entidades

        alumno = alumnoRepository.save(alumno);

        return usuarioGuardado;
    }*/


    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario updateUsuario(Integer id, UsuarioRequest request){
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            opt.get().setUsuario(request.getUsuario());
            return usuarioRepository.save(opt.get());
        }else{
            return null;
        }
    }
    public Usuario getUsuario(Integer id) {

        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new NotFoundException();
    }

    public boolean deleteUsuario(Integer id){
        Optional<Usuario> opt = usuarioRepository.findById(id);
        if (opt.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}