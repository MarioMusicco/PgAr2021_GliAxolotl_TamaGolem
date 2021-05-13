package it.unibs.pga.tamagolem;

public class GestioneSchermo {
    public static void ClearConsole(){
        for(int clear = 0; clear < 500; clear++)
        {
            System.out.println("\b") ;
        }
    }
    public static void pausa(){
        System.out.println("Premi invio per continuare...");
        new java.util.Scanner(System.in).nextLine();
    }
    public static void pausa2sec() {
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
