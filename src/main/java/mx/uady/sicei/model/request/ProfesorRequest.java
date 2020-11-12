package mx.uady.sicei.model.request;
import java.util.Optional;
import org.springframework.lang.NonNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class ProfesorRequest {
    @NotNull
    @NotEmpty(message = "Please enter the name")
    @Size(min = 1, max = 255, message="Campo requerido")
    private String nombre;

    @DecimalMin(value="0.1", message="Minimum value should be 0.01") 
    @DecimalMax(value="2.0", message="Maximun value should be 2.0") 
    private Double horas;

    public ProfesorRequest(){

    }

    public ProfesorRequest(String nombre,  Double horas){
        this.nombre = nombre;
        this.horas = horas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProfesorRequest nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Double getHoras(){
        return this.horas;
    }

    public void setHoras(Double horas){
        this.horas = horas;
    }

    public ProfesorRequest horas(Double horas){
        this.horas = horas;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            "}";
    }

}