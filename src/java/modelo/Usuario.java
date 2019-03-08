package modelo;

/**
 *
 * @author J. Carlos F. Vico <jfervic933@maralboran.es>
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + '}';
    }
    

   
}
