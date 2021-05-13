package it.unibs.pga.tamagolem;

public class GestioneSchermo {

    /**
     * metodo usato per "pulire" lo schermo,
     * così che un giocatore non spii l'altro
     *
     * Non è il metodo più corretto tra tutti,
     * ma è stato approvato da un paio di insegnanti
     */
    public static void clearScreen(){

        for (int i=0; i<1000; i++){
            System.out.println("\n");
        }
    }

    /**
     * metodo che chiede all'utente di premere invio
     * quando pronto a proseguire
     */
    public static void screenPausa(){

        //Daniele
    }


}
