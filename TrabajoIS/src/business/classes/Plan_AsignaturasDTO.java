package business.classes;

public class Plan_AsignaturasDTO {
    private int idPlan;
    private int idAsignatura;
    private String tipoAsignatura;

    // Constructor vacío
    public Plan_AsignaturasDTO() {
        // Constructor vacío
    }

    // Constructor parametrizado
    public Plan_AsignaturasDTO(int idPlan, int idAsignatura, String tipoAsignatura) {
        this.idPlan = idPlan;
        this.idAsignatura = idAsignatura;
        this.tipoAsignatura = tipoAsignatura;
    }

    // Getters y setters
    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getTipoAsignatura() {
        return tipoAsignatura;
    }

    public void setTipoAsignatura(String tipoAsignatura) {
        this.tipoAsignatura = tipoAsignatura;
    }

    // Método toString para imprimir el contenido de la clase
    @Override
    public String toString() {
        return "PlanAsignaturasDTO{" +
               "idPlan=" + idPlan +
               ", idAsignatura=" + idAsignatura +
               ", tipoAsignatura='" + tipoAsignatura + '\'' +
               '}';
    }
}
