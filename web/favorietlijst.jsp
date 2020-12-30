<%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 12/29/2020
  Time: 5:04 PM
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
    <title>Favoriet Lijst</title>
</head>
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
    <jsp:param name="" value=""/>
</jsp:include>

<main>
    <h2>Favoriet</h2>
    <th>

        <a href="Programma?command=setCookieDagF&cookieDag=Maandag">Maandag</a>
        <a href="Programma?command=setCookieDagF&cookieDag=Dinsdag">Dinsdag</a>
        <a href="Programma?command=setCookieDagF&cookieDag=Woensdag">Woensdag</a>
        <a href="Programma?command=setCookieDagF&cookieDag=Donderdag">Donderdag</a>
        <a href="Programma?command=setCookieDagF&cookieDag=Vrijdag">Vrijdag</a>
        <a href="Programma?command=setCookieDagF&cookieDag=Alles">Alles</a>


    </th>
    <table>
        <tr>
            <th>Dag</th>
            <th>Groep Spier</th>
            <th>Aantal uur</th>
        </tr>


        <c:forEach var="programma" items="${lijst}">
            <tr>
                <th>${programma.getDag()}</th>
                <th>${programma.getGroepSpier()}</th>
                <th>${programma.getAantalUur()}</th>

            </tr>

        </c:forEach>


    </table>

</main>
<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
