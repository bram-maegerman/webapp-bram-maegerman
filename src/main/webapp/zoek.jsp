<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zoek | Verlanglijst</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <jsp:include page="navigation.jspf"/>
</header>
<main>
    <h2>Zoek naar een item uit de lijst</h2>
    <form method="POST" action="Controller">
        <input type="hidden" name="command" value="zoekItem">
        <p>
            <label>Naam: </label>
            <input type="text" id="naam" name="naam" required>
        </p>
        <button type="submit" value="add" id="submit">Zoeken</button>
    </form>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>