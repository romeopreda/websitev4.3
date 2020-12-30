<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Programma" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 10/6/2020
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stijl.css">
    <meta name="viewport" content="width=device-width, intial-scale=1.0">
    <title>Overzicht</title>
</head>
<jsp:include page="header.jsp">
    <jsp:param name="activeItem" value="Overzicht"/>
</jsp:include>

<main>
    <h2>Overzicht van alle dagen</h2>
    <th>

        <a href="Programma?command=setCookieDag&cookieDag=Maandag">Maandag</a>
        <a href="Programma?command=setCookieDag&cookieDag=Dinsdag">Dinsdag</a>
        <a href="Programma?command=setCookieDag&cookieDag=Woensdag">Woensdag</a>
        <a href="Programma?command=setCookieDag&cookieDag=Donderdag">Donderdag</a>
        <a href="Programma?command=setCookieDag&cookieDag=Vrijdag">Vrijdag</a>
        <a href="Programma?command=setCookieDag&cookieDag=Alles">Alles</a>


    </th>
    <table>
        <tr>
            <th>Dag</th>
            <th>Groep Spier</th>
            <th>Aantal uur</th>
        </tr>


        <c:forEach var="programma" items="${programmas}">
        <tr>
            <th>${programma.getDag()}</th>
            <th>${programma.getGroepSpier()}</th>
            <th>${programma.getAantalUur()}</th>
            <td><a href="Programma?command=deleteConfirmation&dag=${programma.getDag()}&groepspier=${programma.getGroepSpier()}">Verwijder</a> </td>
            <td><a href="Programma?command=update&dag=${programma.getDag()}">Update</a> </td>
            <td><a href="Programma?command=favorietlijst&dag=${programma.getDag()}">Favoriet</a></td>
        </tr>

        </c:forEach>


    </table>
    <section>${totaaluren}</section>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
