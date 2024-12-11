package business.classes;
import java.util.List;

public class PlanesDeConvalidacionDTO 
{

    private String id;
    private boolean tipoUsuario;
    private String tiempoPlan;
    private String centroDestino;
    private List<String> asignaturasOrigen; //A revisar
    private List<String> asignaturasDestino;//A revisar
    private boolean vigente;
    private int anioAcademico;
    private List<String> listaInscritos;//A revisar

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTiempoPlan() {
        return tiempoPlan;
    }

    public void setTiempoPlan(String tiempoPlan) {
        this.tiempoPlan = tiempoPlan;
    }

    public String getCentroDestino() {
        return centroDestino;
    }

    public void setCentroDestino(String centroDestino) {
        this.centroDestino = centroDestino;
    }

    public List<String> getAsignaturasOrigen() {
        return asignaturasOrigen;
    }

    public void setAsignaturasOrigen(List<String> asignaturasOrigen) {
        this.asignaturasOrigen = asignaturasOrigen;
    }

    public List<String> getAsignaturasDestino() {
        return asignaturasDestino;
    }

    public void setAsignaturasDestino(List<String> asignaturasDestino) {
        this.asignaturasDestino = asignaturasDestino;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public int getAnioAcademico() {
        return anioAcademico;
    }

    public void setAnioAcademico(int anioAcademico) {
        this.anioAcademico = anioAcademico;
    }

    public List<String> getListaInscritos() {
        return listaInscritos;
    }

    public void setListaInscritos(List<String> listaInscritos) {
        this.listaInscritos = listaInscritos;
    }

}
