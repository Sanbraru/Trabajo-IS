package business.classes;

public class ProfesoradoDTO extends UsuarioDTO
{

    private int telefono;
    private String centroOrigen;
    private boolean solicitaAyuda;
    private boolean realizado;

    //Constructores

     // Constructor vacío
     public ProfesoradoDTO() {}

    // Constructor parametrizado
    public ProfesoradoDTO(String correo, String contrasena, String nombre, String apellidos, String dni, int idPlan,
                       int telefono, String centroOrigen, boolean solicitaAyuda, boolean realizado)
                        
    {
        super(correo, contrasena, nombre, apellidos, dni, idPlan); // Llamada al constructor de la clase padre
        this.telefono = telefono;
        this.centroOrigen = centroOrigen;
        this.solicitaAyuda = solicitaAyuda;
        this.realizado = realizado;
    }

    // Getters y Setters
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCentroOrigen() {
        return centroOrigen;
    }

    public void setCentroOrigen(String centroOrigen) {
        this.centroOrigen = centroOrigen;
    }

    public boolean isSolicitaAyuda() {
        return solicitaAyuda;
    }

    public void setSolicitaAyuda(boolean solicitaAyuda) {
        this.solicitaAyuda = solicitaAyuda;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

}
