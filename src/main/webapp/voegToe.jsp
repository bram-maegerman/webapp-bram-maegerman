<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voeg Toe | Verlanglijst</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <jsp:include page="navigation.jspf"/>
</header>
<main>
    <h2>Voeg een item toe aan de verlanglijst</h2>

    <c:if test="${foutmeldingen.size() != 0}">
        <ul>
            <c:forEach var="foutmelding" items="${foutmeldingen}">
                <li><strong>${foutmelding}</strong></li>
            </c:forEach>
        </ul>
    </c:if>
    <form method="POST" action="Controller" id="voegToe">
        <input type="hidden" name="command" value="add">
        <p>
            <label for="naam">Naam: </label>
            <input type="text" id="naam" name="naam" required>
        </p>

        <p>
            <label for="prijs">Prijs: </label>
            <input type="text" id="prijs" name="prijs" required>
        </p>

        <p>
            <label for="hvl">Hoeveelheid: </label>
            <input type="text" id="hvl" name="hvl" required>
        </p>
        <p>
            <label for="kleur">Kleur: </label>
            <select id="kleur" name="kleur">
                <option>Zwart</option>
                <option>Grijs</option>
                <option>Wit</option>
            </select>
        </p>
        <button id="submit" type="submit" value="add">Indienen</button>
    </form>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>