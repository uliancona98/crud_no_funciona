package mx.uady.sicei.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import mx.uady.sicei.exception.NotFoundException;

import org.springframework.stereotype.Service;
import mx.uady.sicei.repository.AlumnoRepository;
import mx.uady.sicei.repository.TutoriaRepository;
import mx.uady.sicei.repository.UsuarioRepository;
import mx.uady.sicei.repository.EquipoRepository;
import mx.uady.sicei.model.Usuario;
import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.model.Equipo;
import mx.uady.sicei.model.Tutoria;
import org.springframework.beans.factory.annotation.Autowired;

import mx.uady.sicei.model.request.AlumnoRequest;


@Service
public class AlumnoSerivce {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TutoriaRepository tutoriaRepository;


    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = new LinkedList<>();
        alumnoRepository.findAll().iterator().forEachRemaining(alumnos::add);
        return alumnos;    
    }

    public Alumno crearAlumno(AlumnoRequest request) {
        Alumno alumno = new Alumno();
        alumno.setNombre(request.getNombre());
        alumno.setUsuario(request.getUsuario());
        alumno.setEquipo(request.getEquipo());
        alumnoRepository.save(alumno);
        return alumno;
    }

    public Alumno obtenerAlumno(String id){
        Optional<Alumno> opt = alumnoRepository.findById(Integer.parseInt(id));
        if (opt.isPresent()) {
            return opt.get();
        }
        throw new NotFoundException();
    }
    
    public Alumno actualizarAlumno(Integer id, AlumnoRequest request){
        Optional<Alumno> optional = alumnoRepository.findById(id);
        if(!optional.isPresent()){
            return null;
        }
        Alumno alumno = optional.get();

        alumno.setNombre(request.getNombre());
        Equipo equipo = new Equipo();
        equipo.setId(request.getEquipo().getId());
        alumno.setEquipo(equipo);
        alumno.setLicenciatura(request.getLicenciatura());
        alumnoRepository.save(alumno);
        return alumno;    
    }

    public boolean borrarAlumno(Integer id){
        Optional<Alumno> optional = alumnoRepository.findById(id);
        if(optional.isPresent()){

           /* List<Tutoria> turorias = tutoriaRepository.getAll()
            Set<Tutoria> tutores = alumno.getTutorias();
            Equipo equipo = alumno.getEquipo();
            for(Tutoria t : tutores){
                tutoriaRepository.delete(t); FALTA
            }*/
            alumnoRepository.deleteById(id);
            usuarioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
