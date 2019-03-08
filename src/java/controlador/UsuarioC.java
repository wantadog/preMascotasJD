package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDAO;


/**
 *
 * @author J. Carlos F. Vico <jfervic933@maralboran.es>
 */
public class UsuarioC extends HttpServlet {    
    // El siguiente método procesa la petición para métodos GET y POST
    // Tiene dos parámetros:
    //  -   request objeto tipo HTTPServletRequest con info de la 
    //      petición del cliente
    //  -   response objeto tipo HTTPServletResponse con info de la 
    //      respuesta al cliente
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Se establece el tipo de contenido a enviar en la respuesta
        response.setContentType("text/html;charset=UTF-8");
       
        // Obtengo la sesion de la petición HTTP, si existe. 
        // Con true, si no está creada se crea
        HttpSession sesion = request.getSession(true);
        
        // Guardo el nombre del visitante en un String
        String nombre = request.getParameter("txtNombre");
        // Asigno ese nombre del visitante al atributo de la sesión y así lo puedo usar en la vista
        sesion.setAttribute("nombre", nombre);
        
        // Obtengo al jugador votado
        
        String email = request.getParameter("txtMail");
        // Si el visitante ha elegido "otros", hay que obtener el valor de la caja de texto
        
      
        // Asigno ese nombre del jugador al atributo de la sesión y así lo puedo usar en la vista
        sesion.setAttribute("email", email);

        // Obtengo la lista de jugadores que hay en la base de datos
        // ordenada por nombre
        
        //ArrayList<Usuario> lista = UsuarioDAO.consultarJugadores(false);
        
        // En este punto miramos si el jugador existe en la lista o no
        // Si existe, habría que sumarle uno a los votos - UPDATE
        // Si no existe, hay que insertarlo poniendo a 1 sus votos - INSERT

            UsuarioDAO.insertarUsuario(nombre,email);
        

       // Obtengo la lista actualizada de jugadores, ordenada por votos
         ArrayList<Usuario> lista = UsuarioDAO.consultarUsuarios();
        
        // Expresión lambda para imprimir los elementos de la lista
        lista.forEach(System.out::println);
        
        // Una vez realizada la operación, redirigimos a la vista
        response.sendRedirect(response.encodeRedirectURL("tablaUsuario.jsp"));

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    // Método que hace búsqueda de un Jugador por su nombre
    // dentro de la lista de Jugadores
  /*
    private static boolean buscarJugador (ArrayList<Jugador> lista, String nombre){
        // Ejemplo de uso de expresiones lambda y API Stream de Java 8
        return lista.stream().anyMatch((jugador) -> (jugador.getNombre().equals(nombre)));
    }
*/
}