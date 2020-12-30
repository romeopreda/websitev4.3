<body>
<header>
    <h1>Prgramma Fitness</h1>
    <nav>
        <ul>

            <li class="unlist" ${param.active eq "index" ? "id = activeItem" : ""}>
                <a href="index.jsp">Home</a></li>

            <li class="unlist" ${param.active eq "DagenToevoegen" ? "id = activeItem" : ""}>
                <a href="DagenToevoegen.jsp">Dagen Toevoegen</a></li>

            <li class="unlist" ${param.active eq "Overzicht" ? "id = activeItem" : ""}>
                <a href="Programma?command=overzicht">Overzicht</a></li>

            <li class="unlist" ${param.active eq "Zoeken" ? "id = activeItem" : ""}>
                <a href="zoeken.jsp">Zoeken</a></li>
            <li class="unlist" ${param.active eq "FavorietLijst" ? "id = activeItem" : ""}>
                <a href="Programma?command=overviewF">Favoriet</a></li>





        </ul>
    </nav>
</header>
