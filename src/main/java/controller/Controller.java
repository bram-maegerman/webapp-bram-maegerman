package controller;

import domain.db.VerlanglijstDB;
import domain.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private final VerlanglijstDB db = new VerlanglijstDB();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String command = request.getParameter("command");
        String destination = "";
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
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String command = request.getParameter("command");
        String destination = "";
        switch(command){
            case "add":
                destination = this.add(request);
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String index(HttpServletRequest request){
        return "index.jsp";
    }

    private String voegToe(HttpServletRequest request){
        return "voegToe.jsp";
    }

    private String overzicht(HttpServletRequest request){
        request.setAttribute("lijst", db.getVerlanglijst());
        request.setAttribute("duurste", db.getDuurste());
        return "overzicht.jsp";
    }

    private String add(HttpServletRequest request){
        db.voegtoe(new Item(request.getParameter("naam"), Double.parseDouble(request.getParameter("prijs")), Integer.parseInt(request.getParameter("hvl")), request.getParameter("kleur")));
        return overzicht(request);
    }
}