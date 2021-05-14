package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;

public class Main {

    public static void main(String[] args) {

        /*boolean che controlla se si vuole fare una partita
        e se si vuole farne un'altra dopo la fine di quella precedente
        */
        boolean si_vuole_giocare= InputDati.yesOrNo(CostantiTesto.nuovaPartita());

        while(si_vuole_giocare){

            //partita in se
            Battaglia btg= new Battaglia();
            btg.combattimento();

            //controllo se si vuole fare un ulteriore partita
            if (InputDati.yesOrNo(CostantiTesto.ulteriorePartita())) {
                GestioneSchermo.ClearConsole();
                si_vuole_giocare = InputDati.yesOrNo(CostantiTesto.nuovaPartita());
            }else{
                si_vuole_giocare=false;
            }
        }
        System.out.println("Grazie per aver giocato. ");
    }
}
