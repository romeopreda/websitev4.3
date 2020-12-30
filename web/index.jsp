<%--
  Created by IntelliJ IDEA.
  User: romeo
  Date: 10/1/2020
  Time: 1:11 PM
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
  <title>Home</title>
</head>
<jsp:include page="header.jsp">
  <jsp:param name="activeItem" value="index"/>
</jsp:include>

<main>
  <article>
    <h2>Programma fitness Romeo</h2>

    <section>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet asperiores incidunt maiores voluptatibus. Aperiam aspernatur autem commodi, consequuntur, doloribus eaque, eos exercitationem illo modi nihil obcaecati provident quasi suscipit tenetur!</p>

    </section>
    <section>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet asperiores incidunt maiores voluptatibus. Aperiam aspernatur autem commodi, consequuntur, doloribus eaque, eos exercitationem illo modi nihil obcaecati provident quasi suscipit tenetur!</p>

    </section>


  </article>
</main>

<jsp:include page="footer.jsp">
  <jsp:param name="" value=""/>
</jsp:include>