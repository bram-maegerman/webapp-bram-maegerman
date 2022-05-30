package controller;

import domain.DomainException;
import domain.db.VerlanglijstDB;
import domain.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet{
    private final VerlanglijstDB db = new VerlanglijstDB();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String destination = index(request);
        if(command != null){
        switch(command){
            case "index":
                destination = index(request);
                break;
            case "voegToe":
                destination = voegToe(request);
                break;
            case "overzicht":
                destination = overzicht(request);
                break;
            case "zoek":
                destination = zoek(request);
                break;
            case "add":
                destination = add(request);
                break;
            case "zoekItem":
                destination = zoekItem(request);
                break;
            case "pasAan":
                destination = pasAanPagina(request);
                break;
            case "pasAanConfirm":
                destination = pasAan(request, response);
                break;
            case "verwijder":
                destination = verwijder(request, response);
                break;
            case "verwijderConfirm":
                destination = verwijderConfirmation(request);
                break;
            case "verwijderOngedaanMaken":
                destination = verwijderOngedaanMaken(request);
                break;
        }}

        request.getRequestDispatcher(destination).forward(request, response);
    }



    private String index(HttpServletRequest request){
        request.setAttribute("duurste", db.getDuurste());
        return "index.jsp";
    }

    private String voegToe(HttpServletRequest request){
        return "voegToe.jsp";
    }

    private String zoek(HttpServletRequest request){
        return "zoek.jsp";
    }

    private String overzicht(HttpServletRequest request){
        request.setAttribute("lijst", db.getVerlanglijst());
        request.setAttribute("duurste", db.getDuurste());
        return "overzicht.jsp";
    }



    private String add(HttpServletRequest request){
        ArrayList<String> foutmeldingen = new ArrayList<>();
        
        Item item = new Item();

        this.setItem(item, request, foutmeldingen);

        if(foutmeldingen.size() == 0){
            item.setKleur(request.getParameter("kleur"));
            db.voegtoe(item);
        }
        else{
            request.setAttribute("foutmeldingen", foutmeldingen);
            return voegToe(request);
        }
        return overzicht(request);
    }

    private String zoekItem(HttpServletRequest request){
        String naam = request.getParameter("naam");
        Item gevonden = db.zoekItem(naam);

        if(gevonden == null){
            request.setAttribute("naam", naam);
            request.setAttribute("findClosest", db.findClosest(naam, this.db.getVerlanglijst(), 0, false));
            return "results/zoekNietGevonden.jsp";
        }
        else{
            request.setAttribute("gevondenItem", gevonden);
            return "results/zoekGevonden.jsp";
        }
    }

    private String pasAanPagina(HttpServletRequest request) {
        Item aanpasItem = db.searchById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("aanpasItem", aanpasItem);
        return "results/pasAan.jsp";
    }

    private String pasAan(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> foutmeldingen = new ArrayList<>();
        Item item = new Item();
        this.setItem(item, request, foutmeldingen);

        if(foutmeldingen.size() == 0) {
            item.setKleur(request.getParameter("kleur"));

            int id = Integer.parseInt(request.getParameter("id"));
            if (db.pasAan(id, item)) {
                Cookie laatstAangepastId = new Cookie("laatstAangepastId", String.valueOf(id));
                laatstAangepastId.setMaxAge(-1);
                response.addCookie(laatstAangepastId);
                Cookie laatstAangepastNaam = new Cookie("laatstAangepastNaam", db.searchById(id).getNaam().replaceAll("\\s+", "_"));
                laatstAangepastNaam.setMaxAge(-1);
                response.addCookie(laatstAangepastNaam);
            }
        }
        else{
            request.setAttribute("foutmeldingen", foutmeldingen);
            return pasAanPagina(request);
        }
        return overzicht(request);
    }

    private String verwijderConfirmation(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        request.setAttribute("naam", db.searchById(id).getNaam());
        return "results/deleteConfirm.jsp";
    }

    private String verwijder(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Item verwijderdItem = db.searchById(id);
        if(db.verwijder(id)){
            HttpSession session =  request.getSession();
            session.setAttribute("laatstVerwijderdeItem", verwijderdItem);
            for(Cookie c: request.getCookies()){
                if (c.getName().equals("laatstAangepastId")){
                    if(id == Integer.parseInt(c.getValue())){
                        Cookie laatstAangepastVerwijderd = new Cookie("laatstAangepastVerwijderd", "true");
                        response.addCookie(laatstAangepastVerwijderd);
                    }
                }
            }
        }
        return overzicht(request);
    }



    private void setItem(Item item, HttpServletRequest request, ArrayList<String> foutmeldingen){
        try{
            item.setNaam(request.getParameter("naam"));
        }
        catch(DomainException exc){
            foutmeldingen.add(exc.getMessage());
        }
        try{
            item.setPrijs(Double.parseDouble(request.getParameter("prijs")));
        }
        catch(DomainException exc){
            foutmeldingen.add(exc.getMessage());
        }
        try{
            item.setHoeveelheid(Integer.parseInt(request.getParameter("hvl")));
        }
        catch(DomainException exc){
            foutmeldingen.add(exc.getMessage());
        }
    }

    private String verwijderOngedaanMaken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Item item = (Item) session.getAttribute("laatstVerwijderdeItem");
        db.voegtoe(item, item.getId());
        session.setAttribute("laatstVerwijderdeItem", null);
        return overzicht(request);
    }
}