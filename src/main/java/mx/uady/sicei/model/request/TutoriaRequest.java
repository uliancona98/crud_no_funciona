package mx.uady.sicei.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import mx.uady.sicei.model.Profesor;
import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.model.TutoriaId;


import mx.uady.sicei.repository.ProfesorRepository;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
public class TutoriaRequest{

    private Alumno alumno;
    private Profesor profesor;
    private TutoriaId id;
    @Min(value=0, message="El minimo es cero horas")
	@Max(value=2, message="No se epermiten más de dos horas")
    private Double horasTutoria;

    public class TutoriaId {
        private Integer alumnoId;
        private Integer profesorId;
        /**
         * @return the alumnoId
         */
        public Integer getAlumnoId() {
            return alumnoId;
        }
        /**
         * @param alumnoId the alumnoId to set
         */
        public void setAlumnoId(Integer alumnoId) {
            this.alumnoId = alumnoId;
        }
        /**
         * @return the profesorId
         */
        public Integer getProfesorId() {
            return profesorId;
        }
        /**
         * @param profesorId the profesorId to set
         */
        public void setProfesorId(Integer profesorId) {
            this.profesorId = profesorId;
        }
    }

    public TutoriaRequest(){

    }

    public TutoriaRequest(Alumno alumno, Profesor profesor, Double horasTutoria){
        this.alumno = alumno;
        this.profesor = profesor;
        this.horasTutoria = horasTutoria;
    }
    
     /**
     * @return the id
     */
    public TutoriaId getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(TutoriaId id) {
        this.id = id;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public TutoriaRequest alumno(Alumno alumno){
        this.alumno = alumno;
        return this;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public TutoriaRequest profesor(Profesor profesor){
        this.profesor = profesor;
        return this;
    }

   
    public Double getHorasTutoria(){
        return this.horasTutoria;
    }

    public void setHorasTutoria(Double horasTutoria){
        this.horasTutoria = horasTutoria;
    }

    public TutoriaRequest horasTutoria(Double horasTutoria){
        this.horasTutoria = horasTutoria;
        return this;
    }
}