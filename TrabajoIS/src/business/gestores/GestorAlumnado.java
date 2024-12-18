package business.gestores;

import business.classes.AlumnadoDTO;
import data.dao.AlumnadoDAO;

public class GestorAlumnado
{
    public static boolean crearAlumno(AlumnadoDTO nuevoUsuario, int idUsuario)
    {
    	return AlumnadoDAO.addStudent(nuevoUsuario, idUsuario);
    }
}