package business.classes;

public class AlumnadoDTO extends UsuarioDTO
{

    private int telefono;
    private int anioAcademico;
    private String centroOrigen;
    private boolean solicitaAyuda;
    private boolean inscrito;
    private boolean realizado;

    //Constructores
    // Constructor vacío
    public AlumnadoDTO() {}

    // Constructor parametrizado
    public AlumnadoDTO(String correo, String contrasena, String nombre, String apellidos, String dni, int idPlan,
                    int telefono, int anioAcademico, String centroOrigen,
                    boolean solicitaAyuda, boolean inscrito, boolean realizado) 
    {

        super(correo, contrasena, nombre, apellidos, dni, idPlan); // Llamada al constructor de la clase padre
        this.telefono = telefono;
        this.anioAcademico = anioAcademico;
        this.centroOrigen = centroOrigen;
        this.solicitaAyuda = solicitaAyuda;
        this.inscrito = inscrito;
        this.realizado = realizado;
    }

    // Getters y Setters
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getAnioAcademico() {
        return anioAcademico;
    }

    public void setAnioAcademico(int anioAcademico) {
        this.anioAcademico = anioAcademico;
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

    public boolean isInscrito() {
        return inscrito;
    }

    public void setInscrito(boolean inscrito) {
        this.inscrito = inscrito;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

}
