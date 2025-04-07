package domain.inscripciones;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasInscripcion;
    private LocalDateTime fechaHora;

    public Inscripcion(Alumno alumno, List<Materia> materiasInscripcion) {
        this.alumno = alumno;
        this.materiasInscripcion = materiasInscripcion;;
        this.fechaHora = LocalDateTime.now();
    }

    public boolean esAprobado(){
        List<Materia> materiasAprobadas = this.alumno.getMateriasAprobadas();
        return this.materiasInscripcion.stream().allMatch(materia -> cumpleCorrelativas(materiasAprobadas, materia));
    }

    public boolean cumpleCorrelativas(List<Materia> materiasAprobadas, Materia materia){
        List<Materia> correlativas = materia.getMateriasCorrelativas();
        return materiasAprobadas.containsAll(correlativas);
    }
}
