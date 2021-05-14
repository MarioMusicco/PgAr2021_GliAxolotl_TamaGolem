package it.unibs.pga.tamagolem;

import java.util.Random;


//questa classe contiene metodi statici che scelgono in modo randomico tra più stringhe possibili
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

    public static final String NOME_PRIMO_ALLIEVO = "Allievo numero Uno inserisci il tuo nome: ";
    public static final String NOME_SECONDO_ALLIEVO = "Allievo numero Due inserisci il tuo nome: ";
    public static final String ANNUNCIO_GIOCATORE_1 = "Inizierà il giocatore ";

    public static final String RICHIESTA_DIFFICOLTA = "Quanti elementi volete inserire?\n-Difficoltà facile: 3 - 5;\n" +
            "-Difficoltà media: 6 - 8;\n-Difficoltà difficile: 9 - 10.\n";

    public static final String NON_SBIRCIARE= "%s girati e non sbriciare finchè %s non ha finito...\nO SUBIRAI LA FURIA DEGLI DEI DEGLI ELEMENTI!";

    public static final String MESSAGGIO_EVOCAZIONE = " procedi all'evocazione";
    public static final String MESSAGGIO_SACCHETTO = "Il sacchetto di Pietre contiene:";
    public static final String QTA_E_TIPO_DI_PIETRE = "- %d pietre di tipo %s";
    public static final String RICHIESTA_PIETRA = "Inserisci il nome della pietra da assegnare --> ";
    public static final String INESISTENZA_PIETRA_INSERITA = "Non esiste una Pietra con quel nome";

    public static final String MESSAGGIO_RIMESCOLO_PIETRE = "Vi preghiamo di portare pazienza.\nDato il fatto che: le pietre dei giocatori avevano lo stsso ordine, un'entità superiore è intervenuta e ha rimescolato l'ordine delle pietre di entrambi i giocatori";

    public static final String MESSAGGIO_LANCIO_PIETRE = "Il tamagolem di %s lancia una Pietra %s, quello di %s usa una Roccia di tipo %s";
    public static final String MESSAGGIO_DANNO_PIETRE = "Il tamagolem di %s ha subito danni dalla Pietra %s\n";
    public static final String MESSAGGIO_PARITA_PIETRE = "Le Pietre si annullano a vicenda, non c'è stato danno\n";
    public static final String MORTE_TAMAGOLEM = "Il tamagolem di %s è stato sconfitto";

    public static final String PREMI_INVIO_PER_CONTINUARE = "Premi invio per continuare...";

    public static String nuovaPartita(){

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

    public static String ulteriorePartita(){

        Random caso= new Random();
        int stringa_da_stampare= caso.nextInt(2);

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
