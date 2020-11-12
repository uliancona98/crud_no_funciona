package mx.uady.sicei.service;

import java.util.Optional;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import mx.uady.sicei.model.Tutoria;
import mx.uady.sicei.model.request.TutoriaRequest;
import mx.uady.sicei.repository.TutoriaRepository;
import mx.uady.sicei.repository.ProfesorRepository;
import mx.uady.sicei.repository.AlumnoRepository;
import mx.uady.sicei.model.TutoriaId;
import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.model.Profesor;

import mx.uady.sicei.exception.NotFoundException;


@Service
public class TutoriaSerivce{

    @Autowired
    private TutoriaRepository tutoriaRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Tutoria> obtenerTutorias(){
        List<Tutoria> tutorias = new LinkedList<>();
        tutoriaRepository.findAll().iterator().forEachRemaining(tutorias::add);
        return tutorias;
    }

    public Tutoria crearTutoria(TutoriaRequest request){
        Optional<Alumno> alumnoOpcional = alumnoRepository.findById(request.getId().getAlumnoId());
        Optional<Profesor> profesorOpcional = profesorRepository.findById(request.getId().getProfesorId());
        if(alumnoOpcional.isPresent() && profesorOpcional.isPresent()){
        TutoriaId tutoriaId = new TutoriaId();
        tutoriaId.setAlumnoId(request.getId().getAlumnoId());
        tutoriaId.setProfesorId(request.getId().getProfesorId());

        Tutoria tutoria = new Tutoria();
        tutoria.setId(tutoriaId);

        Alumno alumno = new Alumno();
        alumno.setId(request.getId().getAlumnoId());
        tutoria.setAlumno(alumno);

        Profesor profesor = new Profesor();
        profesor.setId(request.getId().getProfesorId());
        tutoria.setProfesor(profesor);

        tutoria.setHorasTutoria(request.getHorasTutoria());
        return tutoria;
        }else{
            return null;
        }
    }

    public Tutoria obtenerTutoria(Integer alumnoId, Integer profesorId){
        TutoriaId tutoriaId = new TutoriaId();
        tutoriaId.setAlumnoId(alumnoId);
        tutoriaId.setProfesorId(profesorId);
        
        Optional<Tutoria> opcional = tutoriaRepository.findById(tutoriaId);
        if(opcional.isPresent()){
           return opcional.get();
        }
        throw new NotFoundException();
        /*Alumno alumno = new Alumno();
        alumno.setId(alumnoId);
        tutoria.setAlumno(alumno);

        Profesor profesor = new Profesor();
        profesor.setId(profesorId);
        tutoria.setProfesor(profesor);*/
    }

    public Tutoria actualizarTutoria(Integer alumnoId, Integer profesorId, TutoriaRequest request){
        TutoriaId tutoriaId = new TutoriaId();
        tutoriaId.setAlumnoId(alumnoId);
        tutoriaId.setProfesorId(profesorId);

        Optional<Tutoria> opcional = tutoriaRepository.findById(tutoriaId);

        if(opcional.isPresent()){
            opcional.get().setHorasTutoria(request.getHorasTutoria());
            return opcional.get();
        }
        return null;
    }

    public boolean eliminarTutoria(Integer alumnoId, Integer profesorId){
        TutoriaId tutoriaId = new TutoriaId();
        tutoriaId.setAlumnoId(alumnoId);
        tutoriaId.setProfesorId(profesorId);
        Optional<Tutoria> opcional = tutoriaRepository.findById(tutoriaId);
        if(opcional.isPresent()){
            tutoriaRepository.deleteById(tutoriaId);
            return true;
        }
        return false;

        /*Alumno alumno = new Alumno();
        alumno.setId(alumnoId);
        tutoria.setAlumno(alumno);

        Profesor profesor = new Profesor();
        profesor.setId(profesorId);
        tutoria.setProfesor(profesor);*/
    }



}