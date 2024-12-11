package business.classes;

public class AdministradorDTO extends UsuarioDTO
{
    
    private boolean esAdmin;

    // Getters y Setters
    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

}
