package ui.controller;

import domain.Pragrammadb;
import domain.Programma;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
            case "zoeken":
                destination= zoeken(request,response);
                break;
            case "deleteConfirmation":
                destination = "delete.jsp";
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


    private String delete(HttpServletRequest request , HttpServletResponse response){

        String dag = request.getParameter("dag");
        String groepSpier = request.getParameter("groepspier");
        db.verwijder(dag,groepSpier);
        return overzicht(request,response);

    }

    private String zoeken( HttpServletRequest request, HttpServletResponse response ){
        String dag = request.getParameter("dag");
        String groepSpier = request.getParameter("groepspier");

        request.setAttribute("gezocht",db.zoeken(dag , groepSpier));

        return "zoeken.jsp";
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("programmas" , db.getProgrammas());
        String totaaluren = "Totaal uren per week " + db.totaalUren();
        request.setAttribute("totaaluren", totaaluren);
        return "Overzicht.jsp";

    }

    private String add(HttpServletRequest request , HttpServletResponse response){

        String dag = request.getParameter("dag");
        String groepSpier= request.getParameter("groepspier");
        String aantalUur = request.getParameter("Aantaluur");

        if (dag != null && groepSpier != null && aantalUur != null){
            Programma programma = new Programma(dag,groepSpier,Integer.parseInt(aantalUur));
            db.addProgramma(programma);
            request.setAttribute("programmas",db.getProgrammas());
            request.setAttribute("totaaluren", db.totaalUren());
            return "Overzicht.jsp";
        }
        return "DagenToevoegen.jsp";

    }
}
