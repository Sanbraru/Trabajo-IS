package display;

import java.util.Scanner;

import business.classes.*;
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
            System.out.println("3. Salir");
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
                	
                	System.out.println("Ha iniciado sesión correctamente.");

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
                	
                    System.out.print("Ingrese su correo: ");
                    String correo = scanner.nextLine();
                    
                    System.out.print("Ingrese su contraseña: ");
                    String contrasena = scanner.nextLine();
                    
                    System.out.print("Ingrese su nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Ingrese sus apellidos: ");
                    String apellidos  = scanner.nextLine();
                    
                    System.out.print("Ingrese sus dni: ");
                    String dni  = scanner.nextLine();
                    
                    int idPlan = -1;
                    
                    UsuarioDTO nuevoUsuario = new UsuarioDTO(correo, contrasena, nombre, apellidos, dni, idPlan);
                    
                    System.out.print("¿Usted es un Alumno o un Profesor? (a/p).");
                    
                    String respuesta = scanner.nextLine();
                    
                    int idUsuario = GestorUsuarios.crearUsuario(nuevoUsuario);
                    
                    if (respuesta.equalsIgnoreCase("a"))
                    {
                    	System.out.println("Como 'Alumno' tendrás que añadir más datos.");

                    	System.out.print("Ingrese su Número de Teléfono: ");
                    	int telefono = scanner.nextInt();
                    	scanner.nextLine();  // Limpiar buffer

                    	System.out.print("Ingrese su Año Académico: ");
                    	int anoAcademico = scanner.nextInt();
                    	scanner.nextLine();  // Limpiar buffer

                    	System.out.print("Ingrese su Centro de Origen: ");
                    	String centroorigen = scanner.nextLine();
                    	
                    	int solicitaayuda = 0;
                    	int inscrito = 0;
                    	int realizado = 0;
               
                    	// Crear el objeto AlumnadoDTO con los datos recogidos
                    	AlumnadoDTO nuevoAlumno = new AlumnadoDTO(
                    	    correo, 
                    	    contrasena, 
                    	    nombre, 
                    	    apellidos, 
                    	    dni, 
                    	    idPlan,
                    	    telefono, 
                    	    anoAcademico, 
                    	    centroorigen, 
                    	    solicitaayuda == 0,   // Convertir 1/0 a booleano
                    	    inscrito == 0,  // Puede pedir otro dato si se requiere para 'inscrito'
                    	    realizado == 0 // Convertir 1/0 a booleano
                    	);

                        if(GestorAlumnado.crearAlumno(nuevoAlumno, idUsuario) == true)
                        {
                        	System.out.println("Su cuenta ha sido creada satisfactoriamente.");
                        }
                    	else
                    	{
                    		System.out.println("Su cuenta no ha sido creada satisfactoriamente.");
                    	}
                 
                    }
                    else if(respuesta.equalsIgnoreCase("p"))
                    {	
                    	System.out.println("Como 'Profesor' tendrás que añadir más datos.");

                    	System.out.print("Ingrese su Número de Teléfono: ");
                    	int telefono = scanner.nextInt();
                    	scanner.nextLine();  // Limpiar buffer

                    	System.out.print("Ingrese su Centro de Origen: ");
                    	String centroorigen = scanner.nextLine();
                    	
                    	int solicitaayuda = 0;
                    	int realizado = 0;
               
                    
                    	ProfesoradoDTO nuevoProfesor = new ProfesoradoDTO(
                    	    correo, 
                    	    contrasena, 
                    	    nombre, 
                    	    apellidos, 
                    	    dni, 
                    	    idPlan,
                    	    telefono, 
                    	    centroorigen, 
                    	    solicitaayuda == 0,   // Convertir 1/0 a booleano
                    	    realizado == 0 // Convertir 1/0 a booleano
                    	);
                    	
                    	if(GestorProfesorado.crearProfesor(nuevoProfesor, idUsuario) == true)
                        {
                        	System.out.println("Su cuenta ha sido creada satisfactoriamente.");
                        }
                    	else
                    	{
                    		System.out.println("Su cuenta no ha sido creada satisfactoriamente.");
                    	}
                    }
                    else
                    {
                    	System.out.println("Error al identificarse. No se ha podido crear su cuenta.");
                    }
                    
                    break;
            
                case 3:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                   
                default:
                    System.out.println("Opción inválida. Intentelo de nuevo.");
            }
        }
    }
}

