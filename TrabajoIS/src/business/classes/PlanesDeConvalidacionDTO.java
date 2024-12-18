package business.classes;
import java.util.ArrayList;
import java.util.List;

public class PlanesDeConvalidacionDTO 
{

    private int id;
    private boolean tipoUsuario;
    private int tiempoPlan;
    private String centroDestino;
    private List<AsignaturaDTO> asignaturasOrigen; //A revisar
    private List<AsignaturaDTO> asignaturasDestino;//A revisar
    private boolean vigente;
    private int anioAcademico;
    private List<UsuarioDTO> listaInscritos;//A revisar

    // Constructor vacío
    public PlanesDeConvalidacionDTO() {}

    // Constructor parametrizado
    public PlanesDeConvalidacionDTO(int id, boolean tipoUsuario, int tiempoPlan, String centroDestino,
                                List<AsignaturaDTO> asignaturasOrigen, List<AsignaturaDTO> asignaturasDestino,
                                boolean vigente, int anioAcademico) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.tiempoPlan = tiempoPlan;
        this.centroDestino = centroDestino;
        this.asignaturasOrigen = asignaturasOrigen;
        this.asignaturasDestino = asignaturasDestino;
        this.vigente = vigente;
        this.anioAcademico = anioAcademico;
        this.listaInscritos = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getTiempoPlan() {
        return tiempoPlan;
    }

    public void setTiempoPlan(int tiempoPlan) {
        this.tiempoPlan = tiempoPlan;
    }

    public String getCentroDestino() {
        return centroDestino;
    }

    public void setCentroDestino(String centroDestino) {
        this.centroDestino = centroDestino;
    }

    public List<AsignaturaDTO> getAsignaturasOrigen() {
        return asignaturasOrigen;
    }

    public void setAsignaturasOrigen(List<AsignaturaDTO> asignaturasOrigen) {
        this.asignaturasOrigen = asignaturasOrigen;
    }

    public List<AsignaturaDTO> getAsignaturasDestino() {
        return asignaturasDestino;
    }

    public void setAsignaturasDestino(List<AsignaturaDTO> asignaturasDestino) {
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

    public List<UsuarioDTO> getListaInscritos() {
        return listaInscritos;
    }

    public void setListaInscritos(List<UsuarioDTO> listaInscritos) {
        this.listaInscritos = listaInscritos;
    }

}
