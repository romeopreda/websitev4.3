<%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 11/27/2020
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/stijl.css">
    <meta name="viewport" content="width=device-width, intial-scale=1.0">
    <title>Gevonden</title>
</head>
<jsp:include page="header.jsp">
    <jsp:param name="activeItem" value="index"/>
</jsp:include>

<main>
   <p>Je vroeg naar volgende gegevens:  Dag: </p> <p> ${programma.getDag()}</p>  <p>GroepSpier: ${programma.getGroepSpier()} </p>   <p>AantalUur: ${programma.getAantalUur()}</p>

</main>
<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>