<%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 10/20/2020
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stijl.css">
    <meta name="viewport" content="width=device-width, intial-scale=1.0">
    <title>Verwijder dag</title>
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
    <p><%=request.getAttribute("gezocht")%></p>

    <form method="post" action="Programma?command=zoeken">
        <fieldset>
            <legend>
                Bepaalde programma zoeken:
            </legend>
            <label for="Dag">Dag:</label>
            <input type="text" id="Dag" name="dag" required autofocus placeholder="Dag">
            <label for="GroepSpier">Groepspier:</label>
            <input type="text" id="GroepSpier" name="groepspier" required autofocus placeholder="Groepspier">
            <input type="submit" id="Indienen" name="Indienen" value="Indienen">
        </fieldset>
    </form>

</main>

</body>
</html>
