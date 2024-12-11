package business.classes;

public class AlumnadoDTO extends UsuarioDTO
{

    private int telefono;
    private int anioAcademico;
    private String centroOrigen;
    private boolean solicitaAyuda;
    private boolean inscrito;
    private boolean realizado;

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
