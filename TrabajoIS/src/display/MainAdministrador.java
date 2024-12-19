package display;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

                    if(Usuarios.size() > 0)
                    {
                    	for(UsuarioDTO usuario : Usuarios)
                        {
                            System.out.println(usuario.toString());
                        }
                    }
                    else
                    {
                    	System.out.println("Este plan actualmente no tiene ningún alumno/profesor.");
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

                        // Validar tipoUsuario
                        System.out.println("El plan será para maestros? (true|false): ");
                        if (!scanner.hasNextBoolean()) {
                            System.out.println("Entrada inválida. Debe introducir 'true' o 'false'.");
                            scanner.nextLine(); // Consumir la entrada inválida
                            break;
                        }
                        Boolean tipoUsuario = scanner.nextBoolean();
                        scanner.nextLine(); // Limpiar buffer

                        // Validar duración del plan
                        System.out.println("Duración del Plan en meses (entre 3 y 12): ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Debe introducir un número entero.");
                            scanner.nextLine(); // Consumir la entrada inválida
                            break;
                        }
                        int tiempoPlan = scanner.nextInt();
                        if (tiempoPlan < 3 || tiempoPlan > 12) {
                            System.out.println("La duración debe estar entre 3 y 12 meses.");
                            break;
                        }
                        scanner.nextLine(); // Limpiar buffer

                        // Validar centro de destino
                        System.out.println("Centro de Destino: ");
                        String centroDestino = scanner.nextLine();
                        if (centroDestino.isEmpty()) {
                            System.out.println("El Centro de Destino no puede estar vacío.");
                            break;
                        }

                        // Validar año académico
                        System.out.println("Año académico (debe ser 2024 o posterior): ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Debe introducir un número entero.");
                            scanner.nextLine(); // Consumir la entrada inválida
                            break;
                        }
                        int anioAcademico = scanner.nextInt();
                        if (anioAcademico <= 2024) {
                            System.out.println("El Año Académico debe ser mayor a 2024.");
                            break;
                        }

                        // Si todas las validaciones son correctas, salir del bucle
                        System.out.println("Datos validados correctamente.");
                        
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

                        while(true)
                        {
                        
                        	for(AsignaturaDTO asignatura : listaAsig)
                            {                            	
                                System.out.println(asignatura.toString());
                            }
                            
                        	try {
                                // Pedir al usuario que elija una asignatura o salir
                                System.out.println("Elija una asignatura (O escriba un número igual o menor que '0' para salir): ");
                                int idAsignatura = scanner.nextInt();
                                scanner.nextLine(); // Consumir el salto de línea pendiente después de nextInt()

                                // Salir del bucle si el número es igual o menor a 0
                                if (idAsignatura <= 0) {
                                    System.out.println("Saliendo del bucle...");
                                    break;
                                }

                                // Pedir al usuario que elija si es de Origen o de Destino
                                System.out.println("Ahora elija si quiere ponerla de Origen o de Destino (true = Origen | false = Destino): ");
                                boolean elecTipo = scanner.nextBoolean();
                                scanner.nextLine(); // Consumir el salto de línea pendiente después de nextBoolean()

                                // Asignar el tipo basado en la elección del usuario
                                String tipo = (elecTipo ? "Origen" : "Destino");

                                // Crear un objeto Plan_AsignaturasDTO con los datos introducidos
                                Plan_AsignaturasDTO aux = new Plan_AsignaturasDTO(idPlan, idAsignatura, tipo);

                                // Intentar asignar la asignatura al plan
                                if (GestorAdministradores.asignarAsignaturaAPlan(aux)) {
                                    System.out.println("Asignatura añadida con éxito.");
                                } else {
                                    System.out.println("Error al asignar asignatura a plan.");
                                    break; // Salir del bucle si ocurre un error
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Por favor, introduce los datos correctos.");
                                scanner.nextLine(); // Consumir el input incorrecto para evitar bloqueos
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