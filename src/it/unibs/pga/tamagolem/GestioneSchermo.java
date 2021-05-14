package it.unibs.pga.tamagolem;

public class GestioneSchermo {

    /**
     * "pulisce" la console, andando a capo molte volte
     */
    public static void ClearConsole(){
        for(int clear = 0; clear < 500; clear++)
        {
            System.out.println("\b") ;
        }
    }

    /**
     * il programma aspetta un input dell'utente per riprendere il funzionamento
     */
    public static void pausa(){
        System.out.println(CostantiTesto.PREMI_INVIO_PER_CONTINUARE);
        new java.util.Scanner(System.in).nextLine();
    }

    /**
     * il programma aspetta 3 secondi e riprende il funzionamento
     */
    public static void pausa3sec() {
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
