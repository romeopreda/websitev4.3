<%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 10/20/2020
  Time: 11:58 AM
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
    <p>Ben je zeker dat je de ${param.dag} en ${param.groepspier} wilt verwijderen?</p>

    <form method="post">
        <a href="Programma?command=delete&dag=${param.dag}&groepspier=${param.groepspier}">Ja, ik ben zeker</a>
        <a href="Programma?command=overzicht">Nee, ik ben niet zeker</a>
    </form>
</main>
<footer>
    <ul>
        <li>Voor meer vragen : predaromeo20@yahoo.com</li>
    </ul>
</footer>
</body>
</html>
