package display;

import java.util.ArrayList;
import java.util.Scanner;


import business.classes.*;
import business.gestores.*;


public class MainAdministrador 
{
    public static void mostrarMenuAdministrador(Scanner scanner) {

        
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

                    ArrayList<UsuarioDTO> Usuarios = GestorAdministradores.obtenerUsuarios(idPlan);

                    for(UsuarioDTO usuario : Usuarios)
                    {
                        System.out.println(usuario.toString());
                    }
                    
                    break;
                case 2:
                    System.out.println("Introduzca los datos del nuevo Plan de convalidación: ");
                    System.out.println("ID del nuevo Plan: ");
                    idPlan = scanner.nextInt();
                    if(GestorAdministradores.buscarPlan(idPlan))
                    {
                        System.out.println("Ese plan ya eiste.");
                    }
                    else
                    {
                        scanner.nextLine(); // Limpiar buffer
                        System.out.println("El plan será para maestros?(true|false): ");
                        Boolean tipoUsuario = scanner.nextBoolean();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.println("Duración del Plan en meses: ");
                        int tiempoPlan = scanner.nextInt();
                        System.out.println("Centro de Destino: ");
                        String centroDestino = scanner.nextLine();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.println("Año academico: ");
                        int anioAcademico = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        PlanesDeConvalidacionDTO nuevoPlan = new PlanesDeConvalidacionDTO(idPlan, tipoUsuario, tiempoPlan, centroDestino, true, anioAcademico);

                        if(GestorAdministradores.insertarPlan(nuevoPlan))
                        {
                            System.out.println("Plan Insertado con exito");
                        }
                        else

                        {
                            System.out.println("Error al insertar el plan");
                        }


                        System.out.println("Asignaturas de Origen y Destino: ");
                        System.out.println("Estas son las asignaturas existentes: ");

                        ArrayList<AsignaturaDTO> listaAsig = GestorAdministradores.obtenerAsignaturas();
                        while(scanner.nextLine() != "siguiente")
                        {
                        
                            for(AsignaturaDTO asignatura : listaAsig)
                            {
                                System.out.println(asignatura.toString());
                            }
                            System.out.println("Elija una(O escriba un numero igual o menor que '0' para salir): ");
                            int idAsignatura = scanner.nextInt();

                            System.out.println("Ahora elija si quiere ponerla de Origen o de Destino(true = Origen | false = Destino): ");
                            Boolean elecTipo = scanner.nextBoolean();
                            String tipo = (elecTipo ? "Origen" : "Destino");

                            if(idAsignatura > 0)
                            {
                                Plan_AsignaturasDTO aux = new Plan_AsignaturasDTO(idPlan, idAsignatura, tipo);

                                if(!GestorAdministradores.asignarAsignaturaAPlan(aux))
                                {
                                    System.out.println("Asignatura añadida con exito.");

                                }
                                else
                                {

                                    System.out.println("Error al asignar asignatura a plan.");
                                    break;
                                    
                                }
                            }
                            

                        }
                    }
                    break;
                case 3:
                System.out.println("Accediendo al historial de los planes...");
                System.out.println("PLANES DE CONVALIDACION ---");

                ArrayList<PlanesDeConvalidacionDTO> planes = GestorAdministradores.obtenerPlanes();
                for(PlanesDeConvalidacionDTO plan : planes)
                {
                    System.out.println(plan.toString());
                }

                //Falta la logica


                break;
                case 4:
                System.out.println("Accediendo al historial de los planes...");
                System.out.println("PLANES DE CONVALIDACION ---");

                planes = GestorAdministradores.obtenerPlanes();
                for(PlanesDeConvalidacionDTO plan : planes)
                {
                    System.out.println(plan.toString());
                }

                scanner.nextLine(); // Limpiar buffer

                System.out.println("Elija un plan de convalidacion: ");
                int id = scanner.nextInt();
                if(id > 0)
                {
                    if(GestorAdministradores.modificarVigencia(id))
                    {
                        System.out.println("Plan dado de baja con exito");
                    }
                    else
                    {
                        System.out.println("Error al dar de baja el plan");

                    }
                }

                break;
                case 5:
                System.out.println("Introduzca los datos de la nueva asignatura: ");
                System.out.println("ID de la nueva asignatura: ");
                int idAsignatura = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                if(GestorAdministradores.buscarAsignatura(idAsignatura))
                {
                    System.out.println("Esta asignatura ya existe.");
                    break;
                }
                System.out.println("Nombre de la nueva asignatura: ");
                String nombre = scanner.nextLine();
                scanner.nextLine(); // Limpiar buffer

                AsignaturaDTO nuevaAsig = new AsignaturaDTO(idAsignatura, nombre);

                if(GestorAdministradores.insertarAsignatura(nuevaAsig))
                {
                    System.out.println("Asignatura insertada con exito.");
                }
                else
                {
                    System.out.println("Error al insertar la asignatura.");

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