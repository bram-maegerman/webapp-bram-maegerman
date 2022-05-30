<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <title>Overzicht | Verlanglijst</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <jsp:include page="navigation.jspf"/>
</header>
<main>
    <h2>Overzicht verlanglijst</h2>
    <table>
        <thead>
            <tr>
                <th>Naam</th>
                <th>Prijs</th>
                <th>Hoeveelheid</th>
                <th>Kleur</th>
                <th>Pas aan</th>
                <th>Verwijder</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${lijst}">
                <tr>
                    <td>${item.getNaam()}</td>
                    <td>${item.getPrijs()}</td>
                    <td>${item.getHoeveelheid()}</td>
                    <td>${item.getKleur()}</td>
                    <td><form method="POST" action="Controller"><input type="hidden" name="command" value="pasAan"><input type="hidden" name="id" value=${item.getId()}><button id="pasAan" type="submit">Pas Aan</button></form></td>
                    <td><form method="POST" action="Controller"><input type="hidden" name="command" value="verwijderConfirm"><input type="hidden" name="id" value=${item.getId()}><button id="verwijder" type="submit">Verwijder</button></form></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>Het duurste item in mijn lijst is <strong>${duurste.getNaam()}</strong> en kost <strong>€${duurste.getPrijs()}</strong></p>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>