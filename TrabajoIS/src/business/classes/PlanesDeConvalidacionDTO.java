package business.classes;
import java.util.ArrayList;
import java.util.List;

public class PlanesDeConvalidacionDTO 
{

    private int id;
    private boolean tipoUsuario;
    private int tiempoPlan;
    private String centroDestino;
    private boolean vigente;
    private int anioAcademico;
    private List<UsuarioDTO> listaInscritos;//A revisar

    // Constructor vacío
    public PlanesDeConvalidacionDTO() {}

    // Constructor parametrizado
    public PlanesDeConvalidacionDTO(int id, boolean tipoUsuario, int tiempoPlan, String centroDestino,
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

    //toString
    @Override
    public String toString()
    {
        return "Plan de Convalidacion [Nombre: " + id +
               ", Destinado a: " + (tipoUsuario ? "Profesores" : "Alumnos") +
               ", Duracion: " + tiempoPlan +
               ", Centro de Destino: " + centroDestino +
               ", Estado de vigencia: " + (vigente ? "Vigente" : "No vigente") + 
               ", Año academico: " + anioAcademico + 
               ", Destinado a: " + listaInscritos + "]"; 
    }

}
