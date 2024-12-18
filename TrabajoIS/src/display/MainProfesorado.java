package display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.classes.AsignaturaDTO;
import business.classes.Plan_AsignaturasDTO;
import business.classes.PlanesDeConvalidacionDTO;
import business.gestores.GestorAlumnado;
import business.gestores.GestorProfesorado;

public class MainProfesorado
{
    public static void mostrarMenuProfesorado(Scanner scanner) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU PROFESORADO ===");
            System.out.println("1. Mostrar Planes de Convalidación disponibles");
            System.out.println("2. Inscribirse a un Plan de Convalidación");
            System.out.println("3. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
System.out.println("Estos son todos los Planes de Convalidación disponibles.");
                    
                    List<PlanesDeConvalidacionDTO> Planes = new ArrayList<>();
                    		
                    Planes = GestorProfesorado.mostrarPlanes();
                    
                    for (PlanesDeConvalidacionDTO plan : Planes) 
                    {
                        // Imprimir cada uno de los atributos
                        System.out.printf("ID: %d\n", plan.getId());
                        System.out.printf("Tipo Usuario: %b\n", plan.isTipoUsuario());
                        System.out.printf("Tiempo Plan: %d\n", plan.getTiempoPlan());
                        System.out.printf("Centro Destino: %s\n", plan.getCentroDestino());
                        System.out.printf("Vigente: %b\n", plan.isVigente());
                        System.out.printf("Año Académico: %d\n", plan.getAnioAcademico());
                        
                        System.out.printf("Asignaturas asociadas:");
                        
                        List<Plan_AsignaturasDTO> asignaturasPlan = GestorProfesorado.mostrarPlanesAsignaturas(plan.getId());

                        if (asignaturasPlan.isEmpty()) {
                            System.out.println("No hay asignaturas asociadas a este plan.");
                        } else {
                            for (Plan_AsignaturasDTO ap : asignaturasPlan) {
                                
                                List<AsignaturaDTO> asignaturas = GestorProfesorado.mostrarAsignaturas(ap.getIdAsignatura());
                            
                                for (AsignaturaDTO asignatura : asignaturas) {
                                    // Imprimir los atributos de la asignatura
                                    System.out.printf("   ID: %d\n", asignatura.getID());
                                    System.out.printf("   Nombre: %s\n", asignatura.getNombre());
                                    if (asignaturas.isEmpty()) {
                                        System.out.printf("No se encontraron asignaturas para ID Asignatura: %d\n", ap.getIdAsignatura());
                                    }
                                }
                            }
                        }
                        System.out.println("--------------------------------------------------");
                    }
                    
                    break;
                case 2:
                    System.out.println("Escriba el ID del Plan al que quiere inscribirse:");
                    int numero = scanner.nextInt();
                	scanner.nextLine(); 
                	System.out.println("Escriba su contraseña para confirmar:");
                	String contrasena = scanner.nextLine();
                	
                	GestorProfesorado.inscribirse(numero, contrasena);
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
