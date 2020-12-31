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

    public ArrayList<Programma>getProgrammasDag(String dag) {
        ArrayList<Programma> lijst = new ArrayList<>();
        if (dag.equalsIgnoreCase("Alles")){
            return getProgrammas();
        }
        for (Programma programma : programmas) {
            if (programma.getDag().equals(dag)) {
                lijst.add(programma);
            }

        }
        return lijst;
    }



    public ArrayList<Programma> getProgrammas(){

        return programmas;
    }
    public int totaalUren(String dag){
        int total = 0;
        if (dag.equalsIgnoreCase("Alles")){
            return totaalUrenn();
        }
        for (Programma p : programmas) {
            if (p.getDag().equals(dag)) {
                total += p.getAantalUur();
            }
        }
        return total;
    }

    public int totaalUrenn(){
        int total = 0;
        for (Programma p : programmas){
            total += p.getAantalUur();
        }
        return total;
    }

    public void update(String dag , String groepSpier, int AantalUur){
        for (Programma p : programmas){
            if (p.getDag().equals(dag)){
                p.setGroepSpier(groepSpier);
                p.setAantalUur(AantalUur);
            }
        }
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

    public Programma zoeken(String dag){
        for (Programma programma : programmas){
            if(programma.heeftDag(dag)){
                return programma;
            }
        }
        throw new DomainException("De dag is niet juist");
    }

    public ArrayList<String> zoekenn(String dag){
        ArrayList<String> matches = new ArrayList<>();
        for (Programma programma : programmas){
            if (programma.heeftDag(dag)){
                matches.add(dag);
                return matches;
            }
        }
        return null;
    }

}
