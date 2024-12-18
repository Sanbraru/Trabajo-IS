package business.classes;

public class AsignaturaDTO 
{
    
    int ID;
    String nombre;

    //Constructores
    public AsignaturaDTO(){}

    public AsignaturaDTO(int ID, String nombre)
    {
        this.ID = ID;
        this.nombre = nombre;
    }

    //Getters

    public int getID()
    {
        return this.ID;
    }
    public String getNombre()
    {
        return this.nombre;
    }

    //Setters

    public void setID(int ID)
    {
        this.ID = ID;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    //toString
    @Override
    public String toString()
    {
        return "Asignatura [Id: " + ID +
               ", Nombre: " + nombre + "]"; 
    }
}
