package mx.uady.sicei.model;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
//import java.util.HashSet; 
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "alumnos")
public class Alumno {

    // POJO: Plain Java Object. No existe ninguna accion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // f(x) = y
    private Integer id;
    
    @Column
    private String nombre;

    @Column(name = "licenciatura")
    @Enumerated(EnumType.STRING)
    private Licenciatura licenciatura;

    // JOIN Usuario WHERE alumno.id_usario = usuarios.id

    // LAZY vs EAGER

    @OneToOne
    @JoinColumn(name = "id_usuario") // alumno.id_usuario
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonBackReference
    private Equipo equipo;

    /*@OneToMany(mappedBy = "alumno")
    @JsonManagedReference
    private Set<Tutoria> tutorias;*/

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, Licenciatura licenciatura, Usuario usuario, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.licenciatura = licenciatura;
        this.usuario = usuario;//*** */
        this.equipo = equipo;//*** */
    }
    

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno id(Integer id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alumno nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Licenciatura getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(Licenciatura licenciatura) {
        this.licenciatura = licenciatura;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

}
