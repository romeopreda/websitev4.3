package domain;

import java.awt.print.PrinterGraphics;

public class Programma {
    private String dag;
    private String groepSpier;
    private int AantalUur;


    public Programma(String dag, String groepSpier ,  int AantalUur){

        setDag(dag);
        setAantalUur(AantalUur);
        setGroepSpier(groepSpier);

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
            throw new IllegalArgumentException("geen valide dag");
        }
    }


    public String getGroepSpier(){
        return groepSpier;
    }

    public void setGroepSpier(String groepSpier){
        if (isValidString(groepSpier)){
            this.groepSpier=groepSpier;
        }else{
            throw new IllegalArgumentException("geen valide groepspier");
        }
    }

    public int getAantalUur(){
        return AantalUur;
    }

    public static boolean isValidAantalUur(int Aantaluur){
        return Aantaluur > 0;
    }

    public void setAantalUur(int Aantaluur){
        if(isValidAantalUur(Aantaluur)){
            this.AantalUur = Aantaluur;
        }else{
            throw new IllegalArgumentException("geen valide aantaluur");
        }
    }


}
