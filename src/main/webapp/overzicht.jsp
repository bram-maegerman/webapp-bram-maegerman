<%@ page import="domain.model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Overzicht | Verlanglijst</title>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
<header>
    <h1>Verlanglijst</h1>
    <%@ include file="navigation.jspf" %>
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
            <%  List<Item> lijst = (List<Item>) request.getAttribute("lijst");%>
            <% for(Item i : lijst){ %>
                <tr>
                    <td><%=i.getNaam()%></td>
                    <td><%=i.getPrijs()%></td>
                    <td><%=i.getHoeveelheid()%></td>
                    <td><%=i.getKleur()%></td>
                    <td>Pas aan</td>
                    <td>Verwijder</td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <%Item duurste = (Item) request.getAttribute("duurste");%>
    <p>Het duurste item in mijn lijst is <%= duurste.getNaam()%> en kost <%= duurste.getPrijs()%></p>
</main>
<footer>
    <p>Bram Maegerman - 2021-2022</p>
</footer>
</body>
</html>