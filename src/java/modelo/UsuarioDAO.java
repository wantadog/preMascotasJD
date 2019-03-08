
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author J. Carlos F. Vico <jfervic933@maralboran.es>
 */
public class UsuarioDAO {
    
    // Este método devuelve una lista de Jugadores ordenada por Nombre
    // si creterio es FALSE o por votos si criterio es TRUE
    public static ArrayList<Usuario> consultarUsuarios(){
        Statement st;
        ResultSet res;
        ArrayList<Usuario> lista = new ArrayList();
        
        // Guardo la consulta SQL realizar en una cadena
        String sql = "select * from usuarios order by id desc";
  
        Conexion conexion = new Conexion();
        
        try {
            
            // Preparamos Statement
            st = conexion.getConexion().createStatement(); 
            // Ejecutamos la sentencia y obtenemos la tabla resultado
            res = st.executeQuery(sql);
            // Ahora construimos la lista
            while (res.next()){
                Usuario j = new Usuario();
                // Recogemos los datos del turismo, guardamos en un objeto
                j.setId(res.getInt("id"));
                j.setNombre(res.getString("nombre"));
                j.setEmail(res.getString("email"));

                //Añadimos el objeto al array
                lista.add(j);
            }
            // Cerramos el recurso PreparedStatement 
            st.close();
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla usuarios");
            System.out.println(e);
            
        }

        return lista;  
    }
    
    public static int insertarUsuario(String nombre,String email){
        
        // Cadena con la consulta parametrizada
        //String sql = "insert into usuarios values (?,?)";
        String sql = "insert into usuarios(nombre, email) values ('"+nombre+"','"+email+"')";
        Conexion conexion = new Conexion();
        
        PreparedStatement prest;

        try { 
            // Preparamos la inserción de datos  mediante un PreparedStatement
            prest = conexion.getConexion().prepareStatement(sql);

            // Procedemos a indicar los valores que queremos insertar
            // Usamos los métodos setXXX(indice, valor)
            // indice indica la posicion del argumento ?, empieza en 1
            // valor es el dato que queremos insertar
            //prest.setString(1, nombre);
            //prest.setString(2, email);

            // Ejecutamos la sentencia de inserción preparada anteriormente
            int nfilas = prest.executeUpdate();
    
            // Cerramos el recurso PreparedStatement 
            prest.close();
            
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla Jugadores");
            System.out.println(e);
            return -1;
        }
    }
    
    public static int actualizarJugador(String nombre,String email){
        // Cadena con la consulta 
        String sql = "update Jugadores set votos = votos+1 where nombre like '" + nombre + "' and ";
        Conexion conexion = new Conexion();
        try {

            int nfilas;
            // Ejecutamos la sentencia de modificación
            //try-with-resources
            try (Statement prest = conexion.getConexion().createStatement()) {
                // Ejecutamos la sentencia de modificación
                nfilas = prest.executeUpdate(sql);
                // Cerramos el recurso PreparedStatement
            }
            // Cerramos la conexión 
            conexion.cerrarConexion();
            // La inserción se realizó con éxito, devolvemos filas afectadas
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la modificación de datos en la tabla Jugadores");
            System.out.println(e);
            return -1;
        }
    }
    
}
