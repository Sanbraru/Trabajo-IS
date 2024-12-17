package business.gestores;

import data.dao.UsuarioDAO;

public class GestorUsuarios
{
    public static String iniciarSesion(String usuario, String contrasena) 
    {   
    	return UsuarioDAO.loginUsuario(usuario, contrasena);
    }
}

