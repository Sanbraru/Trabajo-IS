package display;

import java.util.Scanner;

public class MainAdministrador 
{
    public static void mostrarMenuAdministrador(Scanner scanner) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ver Perfil");
            System.out.println("2. Añadir Plan de Convalidación");
            System.out.println("3. Obtener historial de los Planes de Convalidación");
            System.out.println("4. Cerrar Plan de Convalidación");
            

            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Mostrando perfil del usuario...");
                    break;
                case 2:
                    System.out.println("Accediendo a opciones...");
                    break;
                case 3:
                    System.out.println("Cerrando sesión...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }

        System.out.println("Sesión cerrada. ¡Hasta luego!");
    }	
	

}
