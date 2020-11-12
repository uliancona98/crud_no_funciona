package mx.uady.sicei.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.model.Tutoria;
import mx.uady.sicei.model.request.TutoriaRequest;
import mx.uady.sicei.service.TutoriaSerivce;
import mx.uady.sicei.repository.TutoriaRepository;



@RestController
@RequestMapping("/api")
public class TutoriaRest extends RuntimeException{

    @Autowired
    private TutoriaRepository tutoriaRepository;

    @Autowired
    private TutoriaSerivce tutoriaSerivce;

    @GetMapping("/tutorias")
    public ResponseEntity<List<Tutoria>> obtenerTutorias(){
        List<Tutoria> tutorias = tutoriaSerivce.obtenerTutorias();
        return ResponseEntity.ok(tutorias);
    }

    @PostMapping("/tutorias")
    public ResponseEntity<Tutoria> postTutoria(@RequestBody @Valid TutoriaRequest request) throws URISyntaxException {
        Tutoria tutoria = tutoriaSerivce.crearTutoria(request);

        if(tutoria!=null){
        return ResponseEntity.ok().body(tutoriaRepository.save(tutoria));
        }else{
            throw new NotFoundException();
        }
    }

    @GetMapping("/tutorias?alumno={alumnoId}&profesor={profesorId}")
    public ResponseEntity<Tutoria> obtenerTutoria(@PathVariable Integer alumnoId, @PathVariable Integer profesorId){
        Tutoria tutoria = tutoriaSerivce.obtenerTutoria(alumnoId, profesorId);
        return ResponseEntity.status(HttpStatus.OK).body(tutoria);
    }

    @PutMapping("/tutorias?alumno={alumnoId}&profesor={profesorId}")
    public ResponseEntity<Tutoria> actualizarTutoria(@PathVariable Integer alumnoId, @PathVariable Integer profesorId, @RequestBody @Valid TutoriaRequest request){
        Tutoria tutoria = tutoriaSerivce.actualizarTutoria(alumnoId, profesorId, request);
        return ResponseEntity.ok().body(tutoriaRepository.save(tutoria));
    }

    @DeleteMapping("/tutorias?alumno={alumnoId}&profesor={profesorId}")
    public ResponseEntity eliminarTutoria(@PathVariable Integer alumnoId, @PathVariable Integer profesorId){
        if(tutoriaSerivce.eliminarTutoria(alumnoId, profesorId)){
            return ResponseEntity.ok().build();
        }
        return null;
    }

}