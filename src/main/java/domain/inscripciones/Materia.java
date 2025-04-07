package domain.inscripciones;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Materia {
    private Integer idMateria;
    private String nombre;
    private List<Materia> materiasCorrelativas;

    public Materia(Integer idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.materiasCorrelativas = new ArrayList<>();
    }
}
