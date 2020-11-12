package mx.uady.sicei.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tutorias")
public class Tutoria{

    @EmbeddedId
    private TutoriaId id;

    @ManyToOne
    @MapsId(value = "id_alumno")
    @JoinColumn(name = "id_alumno")
    @JsonBackReference
    private Alumno alumno;

    @ManyToOne
    @MapsId(value = "id_profesor")
    @JoinColumn(name = "id_profesor")
    @JsonBackReference
    private Profesor profesor;

    @Column(name = "horas")
    private Double horasTutoria;

    public Tutoria(){

    }

    public Tutoria(TutoriaId id, Alumno alumno, Profesor profesor, Double horasTutoria){
        this.id = id;
        this.alumno = alumno;
        this.profesor = profesor;
        this.horasTutoria = horasTutoria;
    }

    public Tutoria id(TutoriaId id) {
        this.id = id;
        return this;
    }

    public TutoriaId getId() {
        return this.id;
    }

    public void setId(TutoriaId id) {
        this.id = id;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Tutoria alumno(Alumno alumno){
        this.alumno = alumno;
        return this;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Tutoria profesor(Profesor profesor){
        this.profesor = profesor;
        return this;
    }

   
    public Double getHorasTutoria(){
        return this.horasTutoria;
    }

    public void setHorasTutoria(Double horasTutoria){
        this.horasTutoria = horasTutoria;
    }

    public Tutoria horasTutoria(Double horasTutoria){
        this.horasTutoria = horasTutoria;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", alumno='" + getAlumno() + "'" +
            ", profesor='" + getProfesor() + "'" +
            ", horas='" + getHorasTutoria() + "'" +
            "}";
    }


}