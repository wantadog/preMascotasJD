<%@page import="modelo.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de mascotas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <p><font size="6">Registro de mascotas</font></p>

        <form action="./Mascota" method="POST">

            <p> Nombre de la mascota   <input type="text" size="20" name="txtMascota">   </p>
            <p> Dueño     
                <select name="txtForanea">
                    <%
                        ArrayList<Usuario> lista = UsuarioDAO.consultarUsuarios();
                        for (Usuario j : lista) {
                            out.print("<option value=" + j.getId() + ">");
                            out.print(j.getNombre());
                            out.print("</option>");
                        }
                    %>
                </select>
            <p> 
                <input type="submit" name="buttonSubmit" value="Registrar"> 
                <input type="reset" name="buttonReset" value="Reset">
                <button type="button" onclick="location.href = './index.html'">Volver</button>
            </p>
        </form>
    </body>
</html>
