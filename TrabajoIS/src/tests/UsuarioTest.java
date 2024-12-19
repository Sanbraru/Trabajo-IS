package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class UsuarioTest
{
    Usuario usuario = new Usuario("correo@ejemplo.com", "contraseña123");
    assertEquals("correo@ejemplo.com", usuario.getCorreo());
}

