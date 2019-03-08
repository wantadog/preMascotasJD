<%-- 
    Author     : J. Carlos F. Vico <jfervic933@maralboran.es>
--%>

<%@page import="modelo.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Tabla usuarios</h1>
        <%
            if (session.getAttribute("nombre") != null) {
        %>
        <h1>Has insertado al usuario ${sessionScope['nombre']} con email ${sessionScope['email']}</h1>
        <%} else {%>
        <h1>Bienvenido, estas viendo la lista de usuarios</h1>
        <%}%>
        <table border ="1">

            <tr>
                <th>
                    <b>Nombre</b>
                </th>
                <th>
                    <b>email</b>
                </th>
            </tr>

            <%
                // Lista ordenada por votos, de mayor a menor
                ArrayList<Usuario> lista = UsuarioDAO.consultarUsuarios();
                for (Usuario j : lista) {
                    out.print("<tr><td>");
                    out.print(j.getNombre());
                    out.print("</td><td>");
                    out.print(j.getEmail());
                    out.print("</td><tr>");
                }
                session.setAttribute("nombre", null);
                session.setAttribute("email", null);
            %>

        </table>

        <button type="button" onclick="location.href = './index.html'">Volver</button>   

    </body>
</html>
