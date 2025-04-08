import org.example.Alumno;
import org.example.Inscripcion;
import org.example.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InscripcionTest {

    Materia algoritmos;
    Materia paradigmas;
    Materia disenio;
    Materia proyectoFinal;

    @BeforeEach
    void setUp() {
        algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        paradigmas = new Materia("Paradigmas de Programación", algoritmos);
        disenio = new Materia("Diseño de Sistemas", paradigmas);
        proyectoFinal = new Materia("Proyecto Final",paradigmas,disenio);
    }

    @Test
    void testInscripcionAprobada() {
        Alumno nahuel = new Alumno("Nahuel", "Orlando", "173XXX", algoritmos, paradigmas);
        Inscripcion inscripcion = new Inscripcion(nahuel, List.of(disenio));
        assertTrue(inscripcion.aprobada());
    }

    @Test
    void testInscripcionRechazada1() {
        Alumno nahuel = new Alumno("Nahuel", "Orlando", "173XXX");
        Inscripcion inscripcion = new Inscripcion(nahuel, List.of(paradigmas,algoritmos));
        assertFalse(inscripcion.aprobada());
    }


    @Test
    void testInscripcionRechazada2() {
        Alumno nahuel = new Alumno("Nahuel", "Orlando", "173XXX", disenio);
        Inscripcion inscripcion = new Inscripcion(nahuel, List.of(proyectoFinal));
        assertFalse(inscripcion.aprobada());
    }
}
