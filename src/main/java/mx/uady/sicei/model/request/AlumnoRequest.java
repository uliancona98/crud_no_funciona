package mx.uady.sicei.model.request;
import java.util.Optional;
import org.springframework.lang.NonNull;

import mx.uady.sicei.model.Licenciatura;
import mx.uady.sicei.model.Usuario;
import mx.uady.sicei.model.Equipo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class AlumnoRequest {

    @NotNull
    @NotEmpty(message = "Please enter the name")
    @Size(min = 1, max = 255, message="Campo requerido")
    private String nombre;

    @NotNull
    private Usuario usuario;

    @NotNull
    private Equipo equipo;

    @NotNull
    private Licenciatura licenciatura;

    public AlumnoRequest() {
    }

    public AlumnoRequest(String nombre, Usuario usuario, Equipo equipo, Licenciatura licenciatura) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.equipo = equipo;
        this.licenciatura = licenciatura;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AlumnoRequest nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @return the licenciatura
     */
    public Licenciatura getLicenciatura() {
        return this.licenciatura;
    }

    /**
     * @param licenciatura the licenciatura to set
     */
    public void setLicenciatura(Licenciatura licenciatura) {
        this.licenciatura = licenciatura;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuario
     */
    public Equipo getEquipo() {
        return this.equipo;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            "}";
    }
    
}
