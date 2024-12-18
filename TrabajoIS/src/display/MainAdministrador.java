package display;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl;

import business.classes.*;
import business.gestores.*;
import data.dao.AsignaturaDAO;


public class MainAdministrador 
{
    public static void mostrarMenuAdministrador(Scanner scanner) {

        GestorAdministradores gestor = new GestorAdministradores();
        AdministradorDTO adminDTO = new AdministradorDTO();
        
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1. Obtener lista de personas inscritas a un plan de convalidación");
            System.out.println("2. Añadir Plan de Convalidación");
            System.out.println("3. Obtener historial de los Planes de Convalidación");
            System.out.println("4. Cerrar Plan de Convalidación");
            System.out.println("5. Añadir Asignatura");
            System.out.println("6. Cerrar Sesión");

            

            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el ID del Plan: ");
                    int idPlan = scanner.nextInt();

                    ArrayList<AdministradorDTO> listaApuntados = gestor.buscarApuntados(idPlan);

                    
                    break;
                case 2:
                    System.out.println("Introduzca los datos del nuevo Plan de convalidación: ");
                    System.out.print("ID del nuevo Plan: ");
                    idPlan = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("El plan será para maestros?(true|false): ");
                    Boolean tipoUsuario = scanner.nextBoolean();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Duración del Plan en meses: ");
                    int tiempoPlan = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Centro de Destino: ");
                    String centroDestino = scanner.nextLine();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Asingaturas de Origen(Escriba 'siguiente' cuando haya terminado): ");
                    ArrayList<String> listaAsignaturasOrigen = new ArrayList<>();
                    String asignatura; 
                    while((asignatura = scanner.nextLine()) != "siguiente")
                    {
                        listaAsignaturasOrigen.add(asignatura);
                    }
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Asingaturas de Destino(Escriba 'siguiente' cuando haya terminado): ");
                    ArrayList<String> listaAsignaturasDestino = new ArrayList<>();
                    while((asignatura = scanner.nextLine()) != "siguiente")
                    {
                        listaAsignaturasDestino.add(asignatura);
                    }
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Año academico: ");
                    int anioAcademico = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    PlanesDeConvalidacionDTO NuevoPlan = new PlanesDeConvalidacionDTO(idPlan, tipoUsuario, tiempoPlan, centroDestino, listaAsignaturasOrigen, listaAsignaturasDestino, true, anioAcademico);
                    
                    if(gestor.insertarPlan(NuevoPlan))
                    {

                    }

                    break;
                case 3:
                System.out.println("Accediendo a opciones...");
                break;
                case 4:
                System.out.println("Accediendo a opciones...");
                break;
                case 5:

                System.out.println("Introduzca los datos de la nueva asignatura: ");
                System.out.println("ID de la nueva asignatura: ");
                int idAsignatura = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                System.out.println("Nombre de la nueva asignatura: ");
                String nombre = scanner.nextLine();
                scanner.nextLine(); // Limpiar buffer

                AsignaturaDTO nuevaAsig = new AsignaturaDTO(idAsignatura, nombre);

                if(!gestor.insertarAsignatura(nuevaAsig))
                {
                    System.out.println("Error al insertar la asignatura");
                }
                else
                {
                System.out.println("Asignatura insertada con exito");
                }

                break;
                case 6:
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
