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
<jsp:include page="header.jsp">
    <jsp:param name="" value=""/>
</jsp:include>
<main>
    <p>Ben je zeker dat je de ${param.dag} en ${param.groepspier} wilt verwijderen?</p>

    <form method="post">
        <a href="Programma?command=delete&dag=${param.dag}&groepspier=${param.groepspier}">Ja, ik ben zeker</a>
        <a href="Programma?command=overzicht">Nee, ik ben niet zeker</a>
    </form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="" value=""/>
</jsp:include>