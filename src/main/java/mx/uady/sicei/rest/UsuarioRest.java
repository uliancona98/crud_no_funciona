package mx.uady.sicei.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.uady.sicei.exception.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;




import mx.uady.sicei.model.Usuario;
import mx.uady.sicei.model.request.UsuarioRequest;
import mx.uady.sicei.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> obtenerUsuario() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioRequest request) {
        //Usuario u = usuarioService.crear(request);
        throw new NotFoundException();

    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest request) {
        Usuario usuarioUpdate = usuarioService.updateUsuario(id, request);
        if(usuarioUpdate!=null){
            return ResponseEntity.ok().body(usuarioUpdate);
        }
        throw new NotFoundException();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) {
        Usuario u = usuarioService.getUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id){
        if(usuarioService.deleteUsuario(id)){
            return ResponseEntity.ok().build();
        }
        throw new NotFoundException();
    }


}