<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voeg Toe | Verlanglijst</title>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <%@ include file="navigation.jspf" %>
</header>
<main>
    <h2>Voeg een item toe aan de verlanglijst</h2>
    <form method="POST" action="Controller">
        <input type="hidden" name="command" value="add">
        <p>
            <label>Naam: </label>
            <input type="text" id="naam" name="naam">
        </p>

        <p>
            <label>Prijs: </label>
            <input type="text" id="prijs" name="prijs">
        </p>

        <p>
            <label>Hoeveelheid: </label>
            <input type="text" id="hvl" name="hvl">
        </p>
        <p>
            <label>Kleur: </label>
            <select id="kleur" name="kleur">
                <option>Zwart</option>
                <option>Grijs</option>
                <option>Wit</option>
            </select>
        </p>
        <button type="submit" value="add">Indienen</button>
    </form>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>