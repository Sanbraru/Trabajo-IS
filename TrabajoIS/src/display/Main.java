package display;

import java.util.Scanner;
import business.gestores.*;

public class Main 
{
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean salir = false;
        String rol = null;
        
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Crear Cuenta");
            System.out.println("3. Eliminar Cuenta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                	do {
                        System.out.print("Ingrese su correo: ");
                        String correo = scanner.nextLine();

                        System.out.print("Ingrese su contraseña: ");
                        String contrasena = scanner.nextLine();

                        // Llamar a la función que devuelve el rol
                        rol = GestorUsuarios.iniciarSesion(correo, contrasena);

                        if (rol == null) { // Si no se devuelve un rol válido
                            System.out.println("Correo o contraseña incorrectos. Inténtelo nuevamente.");
                            System.out.println("¿Desea salir? (s/n): ");
                            String respuesta = scanner.nextLine();
                            if (respuesta.equalsIgnoreCase("s")) {
                                System.out.println("Saliendo del programa...");
                                System.exit(0); // Finalizar la aplicación
                            }
                        }

                    } while (rol == null);

                    // Redirigir según el rol obtenido
                    switch (rol) {
                        case "alumno":
                            System.out.println("Redirigiendo al menú de Alumnado...");
                            MainAlumnado.mostrarMenuAlumnado(scanner);
                            break;
                        case "profesor":
                            System.out.println("Redirigiendo al menú de Profesorado...");
                            MainProfesorado.mostrarMenuProfesorado(scanner);
                            break;
                        case "administrador":
                            System.out.println("Redirigiendo al menú de Administrador...");
                            MainAdministrador.mostrarMenuAdministrador(scanner);
                            break;
                        default:
                            System.out.println("Error: Rol desconocido. Saliendo...");
                            System.exit(0);
                    }
                    break;
                    
                case 2:
                    //GestorUsuario.crearCuenta(); //NO
                    break;
                case 3:
                    //GestorUsuario.eliminarCuenta(); //NO
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intentelo de nuevo.");
            }
        }
    }
}

