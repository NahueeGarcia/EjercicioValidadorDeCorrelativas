package domain.inscripciones;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Probamos que cumple las correlativas")
    public void esInscripto() {
        // Creo las materias
        Materia syo = new Materia(1,"syo");
        Materia algoritmos = new Materia(2,"algoritmos y estructuras de datos");
        Materia ads = new Materia(3,"ads");

        // Defino las correlativas de ads
        List<Materia> correlativasAds = new ArrayList<>();
        correlativasAds.add(syo);
        correlativasAds.add(algoritmos);
        ads.setMateriasCorrelativas(correlativasAds);

        // Creo el alumno y asigno materias aprobadas
        Alumno alumno = new Alumno("Nahuel", "Garcia", 19732890);
        List<Materia> materiasAprobadasAlumno = new ArrayList<>();
        materiasAprobadasAlumno.add(syo);
        materiasAprobadasAlumno.add(algoritmos);
        alumno.setMateriasAprobadas(materiasAprobadasAlumno);

        // Creo la inscripción
        List<Materia> materiasAInscribir = new ArrayList<>();
        materiasAInscribir.add(ads);
        materiasAInscribir.add(algoritmos);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribir);

        // Testeo que cumple las correlativas para ads
        Assertions.assertTrue(inscripcion.esAprobado());
    }

    @Test
    @DisplayName("Probamos que no cumple las correlativas")
    public void noEsInscripto() {
        // Creo las materias
        Materia syo = new Materia(1,"syo");
        Materia algoritmos = new Materia(2,"algoritmos y estructuras de datos");
        Materia ads = new Materia(3,"ads");

        // Defino las correlativas de ads
        List<Materia> correlativasAds = new ArrayList<>();
        correlativasAds.add(syo);
        correlativasAds.add(algoritmos);
        ads.setMateriasCorrelativas(correlativasAds);

        // Creao el alumno y asigno materias aprobadas
        Alumno alumno = new Alumno("Nahuel", "Garcia", 19732890);
        List<Materia> materiasAprobadasAlumno = new ArrayList<>();
        materiasAprobadasAlumno.add(algoritmos);
        alumno.setMateriasAprobadas(materiasAprobadasAlumno);

        // Creo la inscripción

        List<Materia> materiasAInscribir = new ArrayList<>();
        materiasAInscribir.add(ads);
        materiasAInscribir.add(algoritmos);
        Inscripcion inscripcion = new Inscripcion(alumno, materiasAInscribir);

        // Testeo que no cumple las correlativas para ads
        Assertions.assertFalse(inscripcion.esAprobado());
    }

}