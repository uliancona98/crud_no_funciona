package mx.uady.sicei.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
//import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
    @Embeddable
    public class TutoriaId implements Serializable{

        @Column(name = "id_alumno")
        Integer alumnoId;

        @Column(name = "id_profesor")
        Integer profesorId;

        public TutoriaId() { }
        public TutoriaId(Integer alumnoId, Integer profesorId) { 
            this.alumnoId = alumnoId;
            this.profesorId = profesorId;
        }

        /**
         * @return the alumnoId
         */
        public Integer getAlumnoId() {
            return alumnoId;
        }/**
         * @param alumnoId the alumnoId to set
         */
        public void setAlumnoId(Integer alumnoId) {
            this.alumnoId = alumnoId;
        }/**
         * @return the profesorId
         */
        public Integer getProfesorId() {
            return profesorId;
        }/**
         * @param profesorId the profesorId to set
         */
        public void setProfesorId(Integer profesorId) {
            this.profesorId = profesorId;
        }
    }