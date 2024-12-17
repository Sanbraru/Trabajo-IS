package business.gestores;

import business.classes.UsuarioDTO;
import data.dao.UsuarioDAO;


public class GestorUsuarios
{
    public static String iniciarSesion(String usuario, String contrasena) 
    {   
    	int idUsuario = 0;
    	idUsuario = UsuarioDAO.loginUsuario(usuario, contrasena);
    
    	if(idUsuario != 0)
    	{
    		return UsuarioDAO.searchID(idUsuario);
    	}
    	else
    	{
    		return null;
    	}
    }
    
    public static boolean crearUsuario(UsuarioDTO nuevoUsuario)
    {
    	return UsuarioDAO.addUser(nuevoUsuario);
    }
    
    public static boolean crearAlumno(UsuarioDTO nuevoUsuario)
    {
    	return UsuarioDAO.addStudent(nuevoUsuario);
    }
    
    public static boolean crearProfesor(UsuarioDTO nuevoUsuario)
    {
    	return UsuarioDAO.addTeacher(nuevoUsuario);
    }
}

