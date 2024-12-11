package business.classes;

public class ProfesoradoDTO extends UsuarioDTO
{

    private int telefono;
    private String centroOrigen;
    private boolean solicitaAyuda;
    private boolean realizado;

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
