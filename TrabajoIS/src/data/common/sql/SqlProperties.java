package data.common.sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SqlProperties {
    
    // Método que carga el archivo .properties especificado y obtiene el valor de la clave
    public static String getClave(String archivo, String clave) {
        Properties propiedades = new Properties();
        try (InputStream input = SqlProperties.class.getClassLoader().getResourceAsStream("data/common/sql/" + archivo)) {
            if (input == null) {
                System.err.println("No se pudo encontrar el archivo " + archivo);
                return null;
            }
            propiedades.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        String valor = propiedades.getProperty(clave);
        if (valor == null) {
            System.err.println("Clave no encontrada: " + clave);
            return null;
        }
        return valor;
    }
}