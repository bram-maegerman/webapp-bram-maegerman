<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Aanpassen</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <jsp:include page="/navigation.jspf"/>
</header>
<main>
    <h2>Pas dit item aan</h2>
    <c:if test="${foutmeldingen.size() != 0}">
        <ul>
            <c:forEach var="foutmelding" items="${foutmeldingen}">
                <li><strong>${foutmelding}</strong></li>
            </c:forEach>
        </ul>
    </c:if>
    <form method="POST" action="Controller">
        <input type="hidden" name="command" value="pasAanConfirm">
        <input type="hidden" name="id" value=${aanpasItem.getId()}>
        <p>
            <label for="naam">Naam: </label>
            <input type="text" id="naam" name="naam" value="${aanpasItem.getNaam()}">
        </p>

        <p>
            <label for="prijs">Prijs: </label>
            <input type="text" id="prijs" name="prijs" value=${aanpasItem.getPrijs()}>
        </p>

        <p>
            <label for="hvl">Hoeveelheid: </label>
            <input type="text" id="hvl" name="hvl" value=${aanpasItem.getHoeveelheid()}>
        </p>
        <p>
            <label for="kleur">Kleur: </label>
            <select id="kleur" name="kleur">
                <option hidden="hidden" selected="selected">${aanpasItem.getKleur()}</option>
                <option>Zwart</option>
                <option>Grijs</option>
                <option>Wit</option>
            </select>
        </p>
        <button type="submit">Aanpassen</button>
    </form>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>