<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voeg Toe | Verlanglijst</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="voegToe.jsp">Voeg Toe</a></li>
            <li><a href="overzicht.jsp">0verzicht</a></li>
        </ul>
    </nav>
</header>
<main>
    <h2>Voeg een item toe aan de verlanglijst</h2>
    <form>
        <label>Naam: </label>
        <input type="text"><br>
        <label>Prijs: </label>
        <input type="text"><br>
        <label>Hoeveelheid: </label>
        <input type="text"><br>
        <label>Kleur: </label>
        <select>
            <option>Zwart</option>
            <option>Grijs</option>
            <option>Wit</option>
        </select>
    </form>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>