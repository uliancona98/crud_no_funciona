package mx.uady.sicei.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    private Integer id;

    @Column
    private String nombre;

    
    @Column
    private Double horas;

    /*@OneToMany(mappedBy = "profesor")
    @JsonManagedReference
    private Set<Tutoria> tutorias;*/

    public Profesor(){

    }

    public Profesor(Integer id, String nombre, Double horas){
        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Profesor id(Integer id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Double getHoras(){
        return this.horas;
    }

    public void setHoras(Double horas){
        this.horas = horas;
    }

    public Profesor horas(Double horas){
        this.horas = horas;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }



}