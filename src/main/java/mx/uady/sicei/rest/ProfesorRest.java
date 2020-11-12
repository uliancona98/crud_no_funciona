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

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.model.Profesor;
import mx.uady.sicei.model.request.ProfesorRequest;
import mx.uady.sicei.service.ProfesorSerivce;

@RestController // Metaprogramacion
@RequestMapping("/api")
public class ProfesorRest extends RuntimeException{

    @Autowired
    private ProfesorSerivce profesorService;

    // GET /api/alumnos
    @GetMapping("/profesores")
    public ResponseEntity<List<Profesor>> getProfesores(){
        // ResponseEntity es una abstraccion de una respuesta HTTP, con body y headers
        List<Profesor> profesores = profesorService.getProfesores();

        if (profesorService.getProfesores()==null) {
            throw new NotFoundException();
        }
        return ResponseEntity.ok().body(profesores);
    }

    // POST /api/alumnos
    @PostMapping("/profesores")
    public ResponseEntity<Profesor> postProfesores(@RequestBody @Valid ProfesorRequest request) throws URISyntaxException{
        // RequestBody le indica a Java que estamos esperando un request que cumpla con los campos del Objeto AlumnoRequest
        Profesor profesor = profesorService.crearProfesor(request);
        // 201 Created
        // Header: Location
        return ResponseEntity
            .created(new URI("/profesores/" + profesor.getId()))
            .body(profesor);
    }

    @GetMapping("/profesores/{id}")
    public ResponseEntity getProfesor(@PathVariable Integer id) {
        Profesor profesor = profesorService.obtenerProfesor(id);
        if(profesor!=null){
            return ResponseEntity.ok().body(profesor);
        }else{
            throw new RuntimeException("");  
         }
        
    }

    // Validar que exista, si no existe Lanzar un RuntimeException
    @PutMapping("/profesores/{id}")
    public ResponseEntity<Profesor> putProfesor(@PathVariable Integer id, @RequestBody @Valid ProfesorRequest request) {
        Profesor profesor = profesorService.actualizarProfesor(id, request);
        if(profesor!=null){
            return ResponseEntity.ok().body(profesor);
        }else{
            throw new RuntimeException("");  
         }
    }

    // Validar que exista, si no existe Lanzar un RuntimeException
    @DeleteMapping("/profesores/{id}")
    public ResponseEntity deleteProfesor(@PathVariable Integer id){
       if(profesorService.borrarProfesor(id)){
           return ResponseEntity.ok().body(null);
       }else{
           throw new RuntimeException("");
       }
    }

}