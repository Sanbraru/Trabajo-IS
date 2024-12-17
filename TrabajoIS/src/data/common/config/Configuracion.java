package data.common.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// FICHERO PARA CONFIGURAR ESTO:
// config.properties: almacena los parámetros de configuración y cadena de acceso a
// la base de datos (nombre de servidor, puerto, usuario, contraseña).

public class Configuracion {
    private static Properties propiedades = new Properties();

    static {
        try (InputStream input = Configuracion.class.getClassLoader().getResourceAsStream("data/common/config/config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("No se pudo encontrar el archivo config.properties");
            }
            propiedades.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getClave(String clave) {
        String valor = propiedades.getProperty(clave);
        if (valor == null) {
            System.err.println("Clave no encontrada: " + clave);
            return null;
        }
        return valor;
    }
}