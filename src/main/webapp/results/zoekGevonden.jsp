<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gevonden</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <jsp:include page="/navigation.jspf"/>
</header>
<main>
    <h2>Gevonden Item:</h2>
    <article class="zoek-resultaat">
        <div>
            <p>Naam:</p>
            <p>Prijs:</p>
            <p>Hoeveelheid:</p>
            <p>Kleur:</p>
        </div>
        <div>
            <p>${gevondenItem.getNaam()}</p>
            <p>${gevondenItem.getPrijs()}</p>
            <p>${gevondenItem.getHoeveelheid()}</p>
            <p>${gevondenItem.getKleur()}</p>
        </div>
    </article>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>