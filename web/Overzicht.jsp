<%@ page import="domain.Programma" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 10/6/2020
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Programma> programmas = (ArrayList<Programma>) request.getAttribute("programmas");
    %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stijl.css">
    <meta name="viewport" content="width=device-width, intial-scale=1.0">
    <title>Overzicht</title>
</head>
<body>
<header>
    <h1>Prgramma Fitness</h1>
    <nav>
        <ul>
            <li><a href= "Programma?command=home">Home</a> </li>
            <li><a href="DagenToevoegen.jsp">DagenToevoegen</a> </li>
            <li><a href="Programma?command=overzicht">Overzicht</a> </li>
            <li><a href="zoeken.jsp">Zoeken</a> </li>
        </ul>
    </nav>
</header>


<main>
    <h2>Overzicht van alle dagen</h2>
    <table>
        <tr>
            <th>Dag</th>
            <th>Groep Spier</th>
            <th>Aantal uur</th>
        </tr>

        <%for(Programma programma : programmas) { %>
        <tr>
            <td><%= programma.getDag()%></td>
            <td><%= programma.getGroepSpier()%></td>
            <td><%= programma.getAantalUur()%></td>
            <td><a href="Programma?command=deleteConfirmation&dag=<%=programma.getDag()%>&groepspier=<%=programma.getGroepSpier()%>">Verwijder</a> </td>
        </tr>
        <%}%>



    </table>
    <section>${totaaluren}</section>
</main>
</body>
</html>
