<%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 10/6/2020
  Time: 11:16 AM
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
    <title>DagenToevoegen</title>
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
    <h2>Dagen toevoegen</h2>

    <div class="container">
        <form method="post"  action="Programma?command=add">
            <p><label for="fdag">Dag</label>
                <input type="text" id="fdag" name="dag" placeholder="Dag..."></p>

            <p><label for="lGroepSpier">GroepSpier</label>
                <input type="text" id="lGroepSpier" name="groepspier" placeholder="Welke groep ga jij trainen.."></p>

            <p><label for="aantalUur">Aantal uur</label>
                <input type="number" id="aantalUur" name="Aantaluur" placeholder="Aantal uur dat jij traint.."></p>


            <input type="submit" value="Verstuur">
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