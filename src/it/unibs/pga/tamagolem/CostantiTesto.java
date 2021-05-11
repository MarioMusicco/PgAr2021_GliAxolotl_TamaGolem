package it.unibs.pga.tamagolem;

import java.util.Random;

public class CostantiTesto {

    private static final String ERRORE= "Qualcosa non ha funzionato nella stampa delle stringhe, vai a controllare";


    private static final String INIZIO_PARTITA_1= "Allievi dell'Accademia, volete iniziare una partita?";
    private static final String INIZIO_PARTITA_2= "Siete pronti a combattere allievi?";
    private static final String INIZIO_PARTITA_3= "Allievi, siete pronti a creare un nuovo Equilibrio del mondo?";

    private static final String ULTERIORE_PARTITA_1 = "Volete fare un'altra partita?";
    private static final String ULTERIORE_PARTITA_2 = "Volete combattere ancora?";


    private static final String FINE_PARTITA_1= "L'allievo %s ha giocato con l'Equilibrio del Mondo e ne è uscito vincitore";
    private static final String FINE_PARTITA_2= "%s sconfigge l'avversario umiliandolo nel profondo";
    private static final String FINE_PARTITA_3= "Non importa se vinci di un centimetro o di un chilometro, l'importnte è vincere.\n%s è quindi IL vincitore";//sì e una cit a FF1

    public String nuovaPartita(){

        Random caso= new Random();
        int stringa_da_stampare= caso.nextInt(3);

        switch (stringa_da_stampare){
            case 0:
                return INIZIO_PARTITA_1;
            case 1:
                return INIZIO_PARTITA_2;
            case 2:
                return INIZIO_PARTITA_3;
        }

        return ERRORE;
    }

    public String ulteriorePartita(){

        Random caso= new Random();
        int stringa_da_stampare= caso.nextInt(3);

        switch (stringa_da_stampare){
            case 0:
                return ULTERIORE_PARTITA_1;
            case 1:
                return ULTERIORE_PARTITA_2;
        }

        return ERRORE;
    }


    public static String finePartita(){

        Random caso= new Random();
        int stringa_da_stampare= caso.nextInt(3);

        switch (stringa_da_stampare){
            case 0:
                return FINE_PARTITA_1;
            case 1:
                return FINE_PARTITA_2;
            case 2:
                return FINE_PARTITA_3;
        }

        return ERRORE;
    }
}
