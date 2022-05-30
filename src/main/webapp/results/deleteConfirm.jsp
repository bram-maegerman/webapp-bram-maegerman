<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Verwijder Bevestiging</title>
    <style><jsp:include page="/style/style.css"/></style>
</head>
<body>
<main>
    <h1>Verwijder Bevestiging</h1>
    <div class="delete-confirm">
        <p>Ben je zeker dat je ${naam} wilt verwijderen?</p>
        <div class="delete-confirm-buttons">
            <form method="POST" action="Controller" class="button-form"><input type="hidden" name="command" value="verwijder"><input type="hidden" name="id" value="${id}"><button id="ja" type="submit">Ja</button></form>
            <form method="GET" action="Controller" class="button-form"><input type="hidden" name="command" value="overzicht"><button type="submit" name>Annuleren</button></form>
        </div>
    </div>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>
