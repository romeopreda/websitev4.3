<%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 11/17/2020
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stijl.css">
    <meta name="viewport" content="width=device-width, intial-scale=1.0">
    <title>Update</title>
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
    <h2>Update je dag: ${param.dag}</h2>

    <div class="container">
        <form method="post"  action="Programma?command=add" novalidate>
            <p>Update de groep spier en aantaluuren</p>
            <p><label for="dag">Dag</label>
                <input type="text" id="dag" name="dag" placeholder="Dag..." value="${param.dag}" required></p>

            <p><label for="lGroepSpier">GroepSpier</label>
                <input type="text" id="lGroepSpier" name="groepspier" placeholder="Welke groep ga jij trainen.." value="${groepSpierPreviousValue}" required ></p>

            <p><label for="aantalUur">Aantal uur</label>
                <input type="number" id="aantalUur" name="Aantaluur" placeholder="Aantal uur dat jij traint.." value="${AantalUurPreviousValue}" required></p>

            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${error}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>

            <input type="submit" value="Update Dag">
        </form>
    </div>
</main>
<footer>
    <ul>
        <li>Voor meer vragen : predaromeo20@yahoo.com</li>
    </ul>
</footer>
</body>
</html>
