package business.classes;
import java.util.List;

public class SistemaDTO 
{

    private List<PlanesDeConvalidacionDTO> listaPlanes; //A revisar
    private List<AlumnadoDTO> listaAlumnado; //A revisar
    private List<ProfesoradoDTO> listaProfesores; //A revisar

    // Getters y Setters
    public List<PlanesDeConvalidacionDTO> getListaPlanes() {
        return listaPlanes;
    }

    public void setListaPlanes(List<PlanesDeConvalidacionDTO> listaPlanes) {
        this.listaPlanes = listaPlanes;
    }

    public List<AlumnadoDTO> getListaAlumnado() {
        return listaAlumnado;
    }

    public void setListaAlumnado(List<AlumnadoDTO> listaAlumnado) {
        this.listaAlumnado = listaAlumnado;
    }

    public List<ProfesoradoDTO> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<ProfesoradoDTO> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

}
