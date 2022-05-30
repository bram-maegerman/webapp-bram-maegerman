<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home | Verlanglijst</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
    <header>
        <h1>Verlanglijst</h1>
        <jsp:include page="navigation.jspf"/>
    </header>
    <main id="index">
        <h2>Mijn verlanglijst</h2>
        <p>Dit is een lijst van de dingen die ik graag nodig heb of graag zou willen kopen.</p>
        <p>Het duurste item in mijn lijst is <strong>${duurste.getNaam()}</strong> en kost <strong>€${duurste.getPrijs()}</strong></p>

        <c:choose>
            <c:when test="${cookie.laatstAangepastVerwijderd.getValue().equals('true')}">
                <p>Item met id: <strong>${cookie.laatstAangepastId.getValue()}</strong> is verwijderd uit de lijst.</p>
            </c:when>
            <c:when test="${cookie.laatstAangepastNaam.getValue() != null}">
                <p>Het laatst aangepaste item in mijn lijst is: <strong>${cookie.laatstAangepastNaam.getValue().replaceAll("_", " ")}</strong></p>
            </c:when>
            <c:otherwise>
                <p>Nog niets aangepast</p>
            </c:otherwise>
        </c:choose>

        <c:if test="${!empty sessionScope.laatstVerwijderdeItem}">
            <p>Laatst verwijderde item:</p>
            <article class="index-verwijder-resultaat">
                <div>
                    <p>Naam:</p>
                    <p>Prijs:</p>
                    <p>Hoeveelheid:</p>
                    <p>Kleur:</p>
                </div>
                <div>
                    <strong><p>${sessionScope.laatstVerwijderdeItem.getNaam()}</p>
                    <p>${sessionScope.laatstVerwijderdeItem.getPrijs()}</p>
                    <p>${sessionScope.laatstVerwijderdeItem.getHoeveelheid()}</p>
                    <p>${sessionScope.laatstVerwijderdeItem.getKleur()}</p></strong>
                </div>
            </article>
            <form method="POST" action="Controller" class="button-form">
                <input type="hidden" name="command" value="verwijderOngedaanMaken">
                <button type="submit">Ongedaan maken</button>
            </form>
        </c:if>
        <c:if test="${empty sessionScope.laatstVerwijderdeItem}">
            <p>Nog niets verwijderd</p>
        </c:if>

    </main>
    <footer>
        <p>Bram Maegerman - 2021-2022</p>
    </footer>
</body>
</html>