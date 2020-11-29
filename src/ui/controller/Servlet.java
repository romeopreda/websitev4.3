package ui.controller;

import domain.DomainException;
import domain.Pragrammadb;
import domain.Programma;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet( "/Programma")
public class Servlet extends HttpServlet {


    private Pragrammadb db = new Pragrammadb();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request,response);

    }

    private void processRequest(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
        String destination;
        String command = request.getParameter("command");
        if(command== null) command="";
        switch (command){
            case "overzicht":
                destination = overzicht(request,response);
                break;
            case "add":
                destination = add(request,response);
                break;
            case "home":
                destination = home(request,response);
                break;
            case "deleteConfirmation":
                destination = "delete.jsp";
                break;
            case "zoeken":
                destination = zoeken(request,response);
                break;
            case"zoekenn":
                destination = zoekenn(request,response);
                break;
            case "update":
                destination = "update.jsp";
                break;
            case "setCookieDag":
                destination = setCookieDag(request, response);
                break;
            case "delete":
                destination = delete(request,response);
                break;
            default:
                destination = home(request,response);
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }


    private String UpdateProduct(HttpServletRequest request , HttpServletResponse response){
        String dag = request.getParameter("dag");
        String groepSpier = request.getParameter("groepspier");
        String aantaluur = request.getParameter("Aantaluur");
        int Aantaluur = Integer.parseInt(aantaluur);
        db.update(dag,groepSpier,Aantaluur);
        return overzicht(request,response);

    }




    private String delete(HttpServletRequest request , HttpServletResponse response){

        String dag = request.getParameter("dag");
        String groepSpier = request.getParameter("groepspier");
        db.verwijder(dag,groepSpier);
        return overzicht(request,response);

    }

    private String zoeken( HttpServletRequest request, HttpServletResponse response ){
        String dag = request.getParameter("dag");
        ArrayList<String> errors = new ArrayList<>();
        try{
            Programma programma = db.zoeken(dag);
            request.setAttribute("programma", programma);
            return "gevonden.jsp";

        }catch (DomainException exc){
            errors.add(exc.getMessage());
        }
        request.setAttribute("error", errors);
        return "zoeken.jsp";
    }

    private String zoekenn(HttpServletRequest request , HttpServletResponse response){
        return "zoeken.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = getCookieWithKey(request,"Dag") != null ? getCookieWithKey(request,"Dag"): new Cookie("Dag","Alles");
        String c = getCookieWithKey(request,"Dag") == null ? "alles": cookie.getValue();
        return overzicht(request,response,c);
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response, String cookieDag) {
        request.setAttribute("programmas" , db.getProgrammasDag(cookieDag));
        String totaaluren = "Totaal uren per week " + db.totaalUren(cookieDag);
        request.setAttribute("totaaluren", totaaluren);
        return "Overzicht.jsp";

    }

    private String setCookieDag(HttpServletRequest request , HttpServletResponse response){
        Cookie dagCookie = new Cookie("Dag", request.getParameter("cookieDag"));
        response.addCookie(dagCookie);
        return overzicht(request,response,request.getParameter("cookieDag"));
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }

    private String add(HttpServletRequest request , HttpServletResponse response){


        ArrayList<String> errors = new ArrayList<>();

        Programma programma = new Programma();

        setDag(programma,request,errors);
        setGroepspier(programma,request,errors);
        setAantalUur(programma,request,errors);


        if (errors.size() == 0){
            try {
                db.addProgramma(programma);
                return overzicht(request,response);
            }catch (IllegalArgumentException exc){
                errors.add(exc.getMessage());
            }
        }

        request.setAttribute("error",errors);
        return "DagenToevoegen.jsp";





       /* String dag = request.getParameter("dag");
        String groepSpier= request.getParameter("groepspier");
        String aantalUur = request.getParameter("Aantaluur");

        if (dag.trim().isEmpty() || groepSpier.trim().isEmpty() || aantalUur.trim().isEmpty()) {
            String error = "U moet alle velden invullen";
            request.setAttribute("error", error);
            return "DagenToevoegen.jsp";

        }else{
            Programma programma = new Programma(dag,groepSpier,Integer.parseInt(aantalUur));
            db.addProgramma(programma);
            return overzicht(request,response);
        }
        */

    }

    private void setDag(Programma programma, HttpServletRequest request , ArrayList<String> errors){
        String dag = request.getParameter("dag");

        try{
            programma.setDag(dag);
            request.setAttribute("dagPreviousValue", dag);
        }catch (DomainException exc){
            errors.add(exc.getMessage());
        }

    }

    private void setGroepspier(Programma programma, HttpServletRequest request , ArrayList<String> errors){
        String groepSpier= request.getParameter("groepspier");

        try {
            programma.setGroepSpier(groepSpier);
            request.setAttribute("groepSpierPreviousValue", groepSpier);
        }catch (DomainException exc){
            errors.add(exc.getMessage());
        }
    }

    private void setAantalUur(Programma programma, HttpServletRequest request , ArrayList<String> errors){
        String aantalUur = request.getParameter("Aantaluur");
        try{
            programma.setAantalUur(Integer.parseInt(aantalUur));
            request.setAttribute("AantalUurPreviousValue", aantalUur);
        }catch (NumberFormatException exc){
            errors.add("vul een geldige nummer in (boven 0)");
        }

        catch (DomainException exc){
            errors.add(exc.getMessage());
        }
    }
}
