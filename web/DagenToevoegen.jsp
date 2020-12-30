<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="header.jsp">
    <jsp:param name="activeItem" value="DagenToevoegen"/>
</jsp:include>
<main>
    <h2>Dagen toevoegen</h2>

    <div class="container">
        <form method="post"  action="Programma?command=add" novalidate>
            <p><label for="dag">Dag</label>
                <input type="text" id="dag" name="dag" placeholder="Dag..." value=${dagPreviousValue}></p>

            <p><label for="lGroepSpier">GroepSpier</label>
                <input type="text" id="lGroepSpier" name="groepspier" placeholder="Welke groep ga jij trainen.." value=${groepSpierPreviousValue} ></p>

            <p><label for="aantalUur">Aantal uur</label>
                <input type="number" id="aantalUur" name="Aantaluur" placeholder="Aantal uur dat jij traint.." value=${AantalUurPreviousValue}></p>

            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${error}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>

            <input type="submit" id="Verstuur" value="Verstuur">
        </form>
    </div>
</main>


<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>