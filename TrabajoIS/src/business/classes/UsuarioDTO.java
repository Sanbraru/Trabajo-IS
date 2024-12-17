package business.classes;

public class UsuarioDTO {
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String dni;

    // Constructor vacío
    public UsuarioDTO() {
        // El constructor vacío no hace nada por defecto.
    }

    // Constructor parametrizado
    public UsuarioDTO(String correo, String contrasena, String nombre, String apellidos, String dni) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
