package ui.controller;

import domain.DomainException;
import domain.Pragrammadb;
import domain.Programma;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            case "verwijderFavorietLijst":
                destination = verwijderFavorietLijst(request);
                break;
            case "favorietlijst":
                destination = voegToeFavorietlijst(request,response);
                break;
            case "setCookieDagF":
                destination = setFavorietlijstCookieDag(request,response);
                break;
            case "overviewF":
                destination = overzichtF(request, response);
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
            case "updateProduct":
                destination = UpdateDag(request,response);
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

    private String overzichtF(HttpServletRequest request, HttpServletResponse response){
        Cookie favorietlijstCookie = getCookieWithKey(request, "favorietlijstCookie");
        String c = favorietlijstCookie == null ? "alles" : favorietlijstCookie.getValue();
        return overzichtF(request, response, c);
    }

    private  String overzichtF(HttpServletRequest request , HttpServletResponse response , String favorietlijstCookie){
        HttpSession session = request.getSession();
        ArrayList<Programma> lijst = (ArrayList<Programma>) session.getAttribute("lijst");
        ArrayList<Programma> lijstDag = new ArrayList<>();

        request.setAttribute("lijst", lijstDag);
        return "favorietlijst.jsp";
    }

    private String setFavorietlijstCookieDag(HttpServletRequest request , HttpServletResponse response){
        Cookie favorietlijstCookie = new Cookie("favorietlijstCookie" , request.getParameter("favorietlijstCookieDag"));
        response.addCookie(favorietlijstCookie);
        return overzichtF(request , response , request.getParameter("cookieDag"));
    }

    private String voegToeFavorietlijst(HttpServletRequest request , HttpServletResponse response){
        Programma programma = db.zoeken(request.getParameter("dag"));
        HttpSession session = request.getSession();


        List<Programma> favorietlijst = (List<Programma>) session.getAttribute("lijst");
        if (favorietlijst == null){
            favorietlijst = new ArrayList<>();
        }
        if (!favorietlijst.contains(programma)){
            favorietlijst.add(programma);

        }

        session.setAttribute("lijst", favorietlijst);
        return overzicht(request,response);
    }


    private String verwijderFavorietLijst(HttpServletRequest request){

        HttpSession session = request.getSession();

        ArrayList<Programma> favorietlijst = (ArrayList<Programma>) session.getAttribute("lijst");

        if (favorietlijst !=null){
            favorietlijst.remove(db.zoeken(request.getParameter("dag")));
            session.setAttribute("lijst", favorietlijst);

        }
        return "favorietlijst.jsp";
    }


    private String UpdateDag(HttpServletRequest request , HttpServletResponse response){
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







    }

    private void setDag(Programma programma, HttpServletRequest request , ArrayList<String> errors){
        String dag = request.getParameter("dag");

        try{

            programma.setDag(dag);
            if(!(dag.equalsIgnoreCase("Maandag")|| dag.equalsIgnoreCase("Dinsdag")|| dag.equalsIgnoreCase("Woensdag")|| dag.equalsIgnoreCase("Donderdag")|| dag.equalsIgnoreCase("Vrijdag")|| dag.equalsIgnoreCase("Zaterdag")|| dag.equalsIgnoreCase("Zondag"))){
                throw new DomainException("Dag moet dag van de week zijn");
            }
            request.setAttribute("dagPreviousValue", dag);

        }catch (DomainException exc){
            errors.add(exc.getMessage());
        }

    }

    private void setGroepspier(Programma programma, HttpServletRequest request , ArrayList<String> errors){
        String groepSpier= request.getParameter("groepspier");

        try {
            programma.setGroepSpier(groepSpier);
            if (!(groepSpier.equalsIgnoreCase("Armen")|| groepSpier.equalsIgnoreCase("Bennen")||groepSpier.equalsIgnoreCase("Rug") ||groepSpier.equalsIgnoreCase("Schouders"))){
                throw new DomainException("Moet een normale Spier Groep zijn");
            }
            request.setAttribute("groepSpierPreviousValue", groepSpier);
        }catch (DomainException exc){
            errors.add(exc.getMessage());
        }
    }

    private void setAantalUur(Programma programma, HttpServletRequest request , ArrayList<String> errors){
        String aantalUur = request.getParameter("Aantaluur");
        try{
            programma.setAantalUur(Integer.parseInt(aantalUur));
            if (!(aantalUur.equals("1") || aantalUur.equals("2")|| aantalUur.equals("3"))){
                throw new DomainException("Aantaluuren mag minimum 1 zijn en maximum 3");
            }
            request.setAttribute("AantalUurPreviousValue", aantalUur);
        }catch (NumberFormatException exc){
            errors.add("vul een geldige nummer in (boven 0)");
        }

        catch (DomainException exc){
            errors.add(exc.getMessage());
        }
    }
}
