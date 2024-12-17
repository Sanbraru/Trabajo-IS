package business.classes;

public class AdministradorDTO extends UsuarioDTO
{
    
    private boolean esAdmin;

    //Constructores

    public AdministradorDTO() {}

    public AdministradorDTO(String correo, String contrasena, String nombre, String apellidos, String dni, boolean esAdmin)
    {
        super(correo, contrasena, nombre, apellidos, dni);
        this.esAdmin = esAdmin;
    }

    // Getters y Setters
    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

}
