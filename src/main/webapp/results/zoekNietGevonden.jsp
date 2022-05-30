<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Niet gevonden</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <jsp:include page="/navigation.jspf"/>
</header>
<main>
    <h2>Niet gevonden</h2>
    <p>We konden item met naam "${naam}" niet vinden.</p>
    <c:if test="${findClosest != null}">
        <p>Bedoelde je misschien <a href="Controller?command=zoekItem&naam=${findClosest.getNaam()}">${findClosest.getNaam()}</a>?</p>
    </c:if>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>
