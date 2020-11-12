package mx.uady.sicei.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import mx.uady.sicei.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import mx.uady.sicei.model.Tutoria;
import mx.uady.sicei.model.Profesor;
import mx.uady.sicei.model.Usuario;
import mx.uady.sicei.model.Alumno;

import mx.uady.sicei.model.request.ProfesorRequest;
import mx.uady.sicei.repository.*;


@Service
public class ProfesorSerivce {

    @Autowired
    private ProfesorRepository profesorRepository;
    
    public List<Profesor> getProfesores() {
        List<Profesor> profesores = new LinkedList<>();
        profesorRepository.findAll().iterator().forEachRemaining(profesores::add);
        return profesores;    
    }

    public Profesor crearProfesor(ProfesorRequest request) {
        Profesor profesor = new Profesor();
        profesor.setNombre(request.getNombre());
        profesor.setHoras(request.getHoras());
        profesor = profesorRepository.save(profesor);
        return profesor;
    }

    public Profesor obtenerProfesor(Integer id){
        Optional<Profesor> opt = profesorRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;    
    }

    public Profesor actualizarProfesor(Integer id, ProfesorRequest request){
        Optional<Profesor> optional = profesorRepository.findById(id);
        if(!optional.isPresent()){
            return null;
        }
        Profesor profesor = optional.get();
        profesor.setNombre(request.getNombre());
        profesor.setHoras(request.getHoras());
        profesorRepository.save(profesor);
        return profesor; 
    }

    public boolean borrarProfesor(Integer id){
        Optional<Profesor> opt = profesorRepository.findById(id);
        if (opt.isPresent()) {
            /*Set<Tutoria> tutorias = profesor.getTutorias();
            for(Tutoria t : tutorias) {
                tutoriaRepository.delete(t);
            }*/
            profesorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}