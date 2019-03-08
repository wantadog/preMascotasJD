package modelo;

/**
 *
 * @author J. Carlos F. Vico <jfervic933@maralboran.es>
 */
public class Mascota {
    private int id;
    private String nombre;
    private int dueno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDueno() {
        return dueno;
    }

    public void setDueno(int dueno) {
        this.dueno = dueno;
    }

    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", nombre=" + nombre + ", dueno=" + dueno + '}';
    }
    

    
}
