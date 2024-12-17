package business.gestores;

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
}

