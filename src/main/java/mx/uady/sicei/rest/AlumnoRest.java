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
import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.model.Usuario;

import mx.uady.sicei.model.request.AlumnoRequest;
import mx.uady.sicei.service.AlumnoSerivce;

@RestController // Metaprogramacion
@RequestMapping("/api")
public class AlumnoRest extends RuntimeException {

    @Autowired
    private AlumnoSerivce alumnoService;

    // GET /api/alumnos
    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        // ResponseEntity es una abstraccion de una respuesta HTTP, con body y headers
        /*if (true) {
            throw new NotFoundException();
        }*/
        return ResponseEntity.ok().body(alumnoService.getAlumnos());
    }

    // POST /api/alumnos
    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> postAlumnos(@RequestBody @Valid AlumnoRequest request) throws URISyntaxException {
        // RequestBody le indica a Java que estamos esperando un request que cumpla con los campos del Objeto AlumnoRequest
        Alumno alumno = alumnoService.crearAlumno(request);
        // 201 Created
        // Header: Location
        return ResponseEntity
            .created(new URI("/alumnos/" + alumno.getId()))
            .body(alumno);
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity getAlumno(@PathVariable String id) {
        Alumno alumno = alumnoService.obtenerAlumno(id);
        if(alumno !=null){
            return ResponseEntity.ok().body(alumno);
        }
        throw new RuntimeException("");  

    }

    // Validar que exista, si no existe Lanzar un RuntimeException
    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> postAlumno(@PathVariable Integer id, @RequestBody @Valid AlumnoRequest request) {
        Alumno alumno = alumnoService.actualizarAlumno(id, request);
        if(alumno!=null){
            return ResponseEntity.ok().body(alumno);
        }else{
            throw new RuntimeException("");  
         }
    }

    // }

    // Validar que exista, si no existe Lanzar un RuntimeException
     @DeleteMapping("/alumnos/{id}")
     public ResponseEntity deleteAlumno(@PathVariable Integer id){
        if(alumnoService.borrarAlumno(id)){
            return ResponseEntity.ok().body(null);
        }else{
            throw new RuntimeException("");
        }
     }


}