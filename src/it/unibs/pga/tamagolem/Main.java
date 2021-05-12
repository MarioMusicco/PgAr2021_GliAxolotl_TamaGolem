package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;

public class Main {

    public static void main(String[] args) {

       CostantiTesto cst= new CostantiTesto();
        boolean si_vuole_giocare= InputDati.yesOrNo(cst.nuovaPartita());

        while(si_vuole_giocare){

            Battaglia btg= new Battaglia();
            //btg.combattimento();


            if (InputDati.yesOrNo(cst.ulteriorePartita()))
                si_vuole_giocare= InputDati.yesOrNo(cst.nuovaPartita());
            else
                si_vuole_giocare=false;
        }


    }
}
