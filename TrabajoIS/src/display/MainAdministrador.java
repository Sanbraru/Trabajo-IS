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

            

            System.out.println("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el ID del Plan: ");
                    int idPlan = scanner.nextInt();

                    ArrayList<UsuarioDTO> listaApuntados = GestorAdministradores.buscarApuntados(idPlan);

                    
                    break;
                case 2:
                    System.out.println("Introduzca los datos del nuevo Plan de convalidación: ");
                    System.out.println("ID del nuevo Plan: ");
                    idPlan = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("El plan será para maestros?(true|false): ");
                    Boolean tipoUsuario = scanner.nextBoolean();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Duración del Plan en meses: ");
                    int tiempoPlan = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Centro de Destino: ");
                    String centroDestino = scanner.nextLine();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Asingaturas de Origen(Escriba 'siguiente' cuando haya terminado): ");
                    ArrayList<AsignaturaDTO> listaAsignaturasOrigen = new ArrayList<>();
                    AsignaturaDTO asignatura = new AsignaturaDTO();
                    while((scanner.nextLine()) != "siguiente")
                    {
                        System.out.println("Introduzca el ID de la asignatura(O 'siguiente' si quiere terminar): ");
                        int idAsignatura = scanner.nextInt();
                        if((asignatura = GestorAdministradores.buscarAsignatura(idAsignatura)) != null)
                        {
                            listaAsignaturasOrigen.add(asignatura);
                        }
                        else
                        {
                            System.out.println("Error al buscar la asignatura.");

                        }
                    }
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Asingaturas de Destino(Escriba 'siguiente' cuando haya terminado): ");
                    ArrayList<AsignaturaDTO> listaAsignaturasDestino = new ArrayList<>();
                    while((scanner.nextLine()) != "siguiente")
                    {
                        System.out.println("Introduzca el ID de la asignatura(O 'siguiente' si quiere terminar): ");
                        int idAsignatura = scanner.nextInt();
                        if((asignatura = GestorAdministradores.buscarAsignatura(idAsignatura)) != null)
                        {
                            listaAsignaturasDestino.add(asignatura);
                        }
                        else
                        {
                            System.out.println("Error al buscar la asignatura.");

                        }
                    }
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("Año academico: ");
                    int anioAcademico = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    PlanesDeConvalidacionDTO nuevoPlan = new PlanesDeConvalidacionDTO(idPlan, tipoUsuario, tiempoPlan, centroDestino, listaAsignaturasOrigen, listaAsignaturasDestino, true, anioAcademico);

                    if(GestorAdministradores.insertarPlan(nuevoPlan))
                    {
                        System.out.println("Plan de Convalidacion insertado con éxito.");
                    }
                    else
                    {
                        System.out.println("Error al crear el nuevo Plan de Convalidacion.");
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

                if(!GestorAdministradores.insertarAsignatura(nuevaAsig))
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