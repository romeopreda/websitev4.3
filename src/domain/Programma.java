package domain;

import java.awt.print.PrinterGraphics;

public class Programma {
    private String dag;
    private String groepSpier;
    private int AantalUur;


    public Programma(String dag){

        setDag(dag);
        setAantalUur(AantalUur);
        setGroepSpier(groepSpier);

    }

    public Programma() {

    }





    public static boolean isValidString(String input){
        return (input != null) && !(input.trim().isEmpty());
    }


    public String getDag(){
        return dag;
    }

    public void setDag(String dag){
        if(isValidString(dag)){
            this.dag = dag;
        }else{
            throw new DomainException("geen valide dag");
        }
    }


    public String getGroepSpier(){
        return groepSpier;
    }

    public void setGroepSpier(String groepSpier){
        if (isValidString(groepSpier)){
            this.groepSpier=groepSpier;
        }else{
            throw new DomainException("geen valide groepspier");
        }
    }

    public int getAantalUur(){
        return AantalUur;
    }

    public static boolean isValidAantalUur(int Aantaluur){
        return Aantaluur > 0 && Aantaluur <= 3;
    }

    public void setAantalUur(int Aantaluur){
        if(isValidAantalUur(Aantaluur)){
            this.AantalUur = Aantaluur;
        }else{
            throw new DomainException("Uur moet tussen 1 en 3 zijn");
        }
    }

    public boolean heeftDag(String dag){
        return dag.equals(this.getDag());
    }
}
