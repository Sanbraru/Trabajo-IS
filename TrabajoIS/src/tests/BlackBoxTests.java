package tests;

// Ejemplo de pruebas de caja negra
import static org.junit.Assert.*;

import org.junit.Test;

// Importar dependencias necesarias
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import business.classes.AlumnadoDTO;
import business.classes.AsignaturaDTO;
import business.classes.ProfesoradoDTO;
import business.classes.UsuarioDTO;
import data.dao.AlumnadoDAO;
import data.dao.UsuarioDAO;

public class BlackBoxTests {

    // 1. Prueba de inicialización en UsuarioDTO
    @Test
    public void testUsuarioDTOInitialization() {
        UsuarioDTO usuario = new UsuarioDTO("correo@example.com", "1234", "Juan", "Pérez", "12345678A", 1);
        assertEquals("correo@example.com", usuario.getCorreo());
        assertEquals("Juan", usuario.getNombre());
    }

    // 2. Prueba de getter/setter en AsignaturaDTO
    @Test
    public void testAsignaturaDTOSettersAndGetters() {
        AsignaturaDTO asignatura = new AsignaturaDTO();
        asignatura.setID(101);
        asignatura.setNombre("Matemáticas");
        assertEquals(101, asignatura.getID());
        assertEquals("Matemáticas", asignatura.getNombre());
    }

    // 3. Prueba de inserción en UsuarioDAO
    @Test
    public void testUsuarioDAOInsert() {
        UsuarioDTO usuario = new UsuarioDTO("juanperez@example.com", "1234", "Juan", "Pérez", "123678A", 0);
        int result = UsuarioDAO.addUser(usuario);
        assertTrue(result > 0); // Asume que la inserción es exitosa
    }

    // 5. Prueba de caso límite: inserción de datos inválidos en AlumnadoDAO
    @Test
    public void testAlumnadoDAOInsertInvalidData() {
        AlumnadoDTO alumno = new AlumnadoDTO(null, "", "", "", "", -1, -1, -1, "", false, false);
        boolean result = AlumnadoDAO.addStudent(alumno, 0);
        assertFalse(result); // Asume que la inserción falla por datos inválidos
    }

    // 6. Prueba de validación de atributos en ProfesoradoDTO
    @Test
    public void testProfesoradoDTOAttributes() {
        ProfesoradoDTO profesor = new ProfesoradoDTO("correo@profesor.com", "abcd", "María", "Gómez", "87654321B", 2, 555123456, "Escuela X", true, false);
        assertEquals("María", profesor.getNombre());
        assertTrue(profesor.isSolicitaAyuda());
    }

    // Método principal para ejecutar las pruebas
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BlackBoxTests.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("Todas las pruebas se ejecutaron correctamente.");
        } else {
            System.out.println("Algunas pruebas fallaron.");
        }
    }
}

