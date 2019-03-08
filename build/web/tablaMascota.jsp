<%-- 
    Author     : J. Carlos F. Vico <jfervic933@maralboran.es>
--%>

<%@page import="modelo.MascotaDAO"%>
<%@page import="modelo.Mascota"%>

<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mascotas</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Tabla mascotas</h1>
        <%
            if (session.getAttribute("nombre") != null) {
        %>
        <h1>Has insertado a la mascota ${sessionScope['nombre']}, del dueño con id ${sessionScope['dueno']}</h1>
        <%} else {%>
        <h1>Bienvenido, estas viendo la lista de mascotas</h1>
        <%}%>
        <table border ="1">

            <tr>
                <th>
                    <b>Mascota</b>
                </th>
                <th>
                    <b>Dueño</b>
                </th>
            </tr>

            <%
                // Lista ordenada por votos, de mayor a menor
                ArrayList<Mascota> lista = MascotaDAO.consultarMascotas();
                for (Mascota j : lista) {
                    out.print("<tr><td>");
                    out.print(j.getNombre());
                    out.print("</td><td>");
                    out.print(j.getDueno());
                    out.print("</td><tr>");
                }
                session.setAttribute("nombre", null);
                session.setAttribute("dueno", null);
            %>

        </table>

        <button type="button" onclick="location.href = './index.html'">Volver</button>   

    </body>
</html>
