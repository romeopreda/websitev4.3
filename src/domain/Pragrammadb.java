package domain;

import java.util.ArrayList;

public class Pragrammadb {

    private ArrayList<Programma> programmas = new ArrayList<Programma>();


    public Pragrammadb(){


    }

    public void addProgramma(Programma programma){
        if(programma == null) throw new IllegalArgumentException("geen programma");
        this.programmas.add(programma);
    }

    public ArrayList<Programma> getProgrammas(){

        return programmas;
    }
    public int totaalUren(){
        int total = 0;
        for (Programma p : programmas) {
            total += p.getAantalUur();
        }
        return total;
    }


    public void verwijder(String dag, String groepSpier){

        Programma teVerwijderen = null;
        for (Programma programma : programmas){

            if (programma.getDag().equals(dag) && programma.getGroepSpier().equals(groepSpier)){
                teVerwijderen = programma;
            }
        }
        programmas.remove(teVerwijderen);
    }

    public Object zoeken(String dag , String groepSpier){
        Programma P = null;

        for(Programma programma : programmas){
            if (programma.getDag().equals(dag) && programma.getGroepSpier().equals(groepSpier)){
                P = programma;
            }
        }

        if (P == null){
            return "Programma bestaat niet";
        }

        return "Dag: " + P.getDag() + ",SpierGroep: " + P.getGroepSpier() + ", aantal uren: " + P.getAantalUur();

    }

}
