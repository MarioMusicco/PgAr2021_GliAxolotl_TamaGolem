package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;
import java.util.*;

public class Battaglia {

    /**
     * metodo che permette lo svolgere del combattimento,
     * andando a creare i due allievi-avversari
     * e chiamando le tre fasi che compongono il combattimento
     */
    public void combattimento(){

        String primo_nome= InputDati.leggiStringa(CostantiTesto.NOME_PRIMO_ALLIEVO);
        String secondo_nome= InputDati.leggiStringa(CostantiTesto.NOME_SECONDO_ALLIEVO);

        PacchettoPietre pacchetto_pietre= faseI();

        Allievo allievo1;
        Allievo allievo2;
        if(System.currentTimeMillis()%2==0){
            allievo1= new Allievo(primo_nome);
            allievo2= new Allievo(secondo_nome);
            System.out.println(CostantiTesto.ANNUNCIO_GIOCATORE_1 + allievo1.getNome());
        }else{
            allievo1= new Allievo(secondo_nome);
            allievo2= new Allievo(primo_nome);
            System.out.println(CostantiTesto.ANNUNCIO_GIOCATORE_1 + allievo1.getNome());
        }
        faseII(allievo1, allievo2, pacchetto_pietre);
        faseIII(allievo1, allievo2, pacchetto_pietre);

    }

    /**
     * metodo che permette di creare un pacchetto di pietre e quindi il preliminare equilibrio.
     * viene chiesto all'utente di inserire il numero di elementi della partita
     * @return
     */
    private PacchettoPietre faseI (){

        //domanda
        int num_elementi= InputDati.leggiIntero(CostantiTesto.RICHIESTA_DIFFICOLTA, 3, 10);
        new CostantiNumeriche(num_elementi);

        PacchettoPietre equilibrio= new PacchettoPietre();
        return equilibrio;
    }

    private void faseII(Allievo allievo1, Allievo allievo2, PacchettoPietre pacchetto_pietre){

        ArrayList<Pietra> scortaPietre = new ArrayList<Pietra>();
        for (int i = 0; i < CostantiNumeriche.getN(); i++) {
            for (int j = 0; j < CostantiNumeriche.getS() / CostantiNumeriche.getN(); j++) {
                scortaPietre.add(pacchetto_pietre.getEquilibrio_del_mondo().get(i));
            }
        }

        //evocazione iniziale

        System.out.println(allievo1.getNome() + CostantiTesto.MESSAGGIO_EVOCAZIONE);
        allievo1.evocazione(scortaPietre);

        GestioneSchermo.ClearConsole();
        GestioneSchermo.pausa();

        System.out.println( allievo2.getNome() + CostantiTesto.MESSAGGIO_EVOCAZIONE);
        allievo2.evocazione(scortaPietre);

        GestioneSchermo.ClearConsole();
        GestioneSchermo.pausa();

        int turno_pietra_1=0;
        int golem_g1_attuale=0;
        int turno_pietra_2=0;
        int golem_g2_attuale=0;

        controlloPietre(allievo1.getTamagolem().get(golem_g1_attuale).getPietre_degli_elementi(), allievo2.getTamagolem().get(golem_g2_attuale).getPietre_degli_elementi());

        do{
            //scontro
            Pietra ptg1= allievo1.getTamagolem().get(golem_g1_attuale).getPietre_degli_elementi().get(turno_pietra_1);
            Pietra ptg2= allievo2.getTamagolem().get(golem_g2_attuale).getPietre_degli_elementi().get(turno_pietra_2);

            System.out.println(String.format(CostantiTesto.MESSAGGIO_LANCIO_PIETRE, allievo1.getNome(), allievo1.getTamagolem().get(golem_g1_attuale).getPietre_degli_elementi().get(turno_pietra_1).getNome(),
                    allievo2.getNome(),  allievo2.getTamagolem().get(golem_g2_attuale).getPietre_degli_elementi().get(turno_pietra_2).getNome()));

            int danno= ptg1.getDanni_elementi().get(ptg2.getNome());
            int new_HP;

            if (danno>0){
                new_HP= allievo1.getTamagolem().get(golem_g1_attuale).getHP() -danno;
                allievo1.getTamagolem().get(golem_g1_attuale).setHP(new_HP);
                System.out.println(String.format(CostantiTesto.MESSAGGIO_DANNO_PIETRE,  allievo1.getNome() , allievo2.getTamagolem().get(golem_g2_attuale).getPietre_degli_elementi().get(turno_pietra_2).getNome()));
            }else if(danno<0){
                new_HP= allievo2.getTamagolem().get(golem_g2_attuale).getHP() +danno;
                allievo2.getTamagolem().get(golem_g2_attuale).setHP(new_HP);
                System.out.println(String.format(CostantiTesto.MESSAGGIO_DANNO_PIETRE,  allievo2.getNome(), allievo1.getTamagolem().get(golem_g1_attuale).getPietre_degli_elementi().get(turno_pietra_1).getNome()));
            }else{
                System.out.println(CostantiTesto.MESSAGGIO_PARITA_PIETRE);
            }

            //evocazioni successive
            //isVincitore= true
            if(allievo1.getTamagolem().get(golem_g1_attuale).getHP()<=0) {
                System.out.println(String.format(CostantiTesto.MORTE_TAMAGOLEM, allievo1.getNome() ));
                if (allievo1.getTamagolem().size() == CostantiNumeriche.getG()) {
                    allievo2.setIs_vincitore(true);
                }
                else{
                    GestioneSchermo.pausa();
                    System.out.println("");
                    allievo1.evocazione(scortaPietre);
                    golem_g1_attuale++;
                    turno_pietra_1=0;
                    turno_pietra_2= resetPietreVicitore(turno_pietra_2, allievo2, golem_g2_attuale);
                    controlloPietre(allievo1.getTamagolem().get(golem_g1_attuale).getPietre_degli_elementi(), allievo2.getTamagolem().get(golem_g2_attuale).getPietre_degli_elementi());
                }
            }else if(allievo2.getTamagolem().get(golem_g2_attuale).getHP()<=0){
                System.out.println(String.format(CostantiTesto.MORTE_TAMAGOLEM, allievo2.getNome() ));
                if (allievo2.getTamagolem().size() == CostantiNumeriche.getG()) {
                    allievo1.setIs_vincitore(true);
                }else{
                    GestioneSchermo.pausa();
                    System.out.println("");
                    allievo2.evocazione(scortaPietre);
                    golem_g2_attuale++;
                    turno_pietra_1= resetPietreVicitore(turno_pietra_1, allievo1, golem_g1_attuale);
                    turno_pietra_2=0;
                    controlloPietre(allievo1.getTamagolem().get(golem_g1_attuale).getPietre_degli_elementi(), allievo2.getTamagolem().get(golem_g2_attuale).getPietre_degli_elementi());
                }
            }else {
                turno_pietra_1 = (turno_pietra_1 + 1) % CostantiNumeriche.getP();
                turno_pietra_2 = (turno_pietra_2 + 1) % CostantiNumeriche.getP();
            }

            //GestioneSchermo.pausa();
            GestioneSchermo.pausa3sec();

        }while(!allievo1.isIs_vincitore() && !allievo2.isIs_vincitore());
    }

    /**
     * metodo che mi decreta il vincitore
     * in base al numero di tamagolem, cioè in base all'allievo che non ha più tamagolem,
     * l'altro viene annunciato vincitore
     * @param allievo1
     * @param allievo2
     * @param pacchetto_di_pietre
     */
    private void faseIII(Allievo allievo1, Allievo allievo2, PacchettoPietre pacchetto_di_pietre){

        //stampa il vincitore
        if (allievo1.isIs_vincitore()){
            System.out.println(String.format(CostantiTesto.finePartita(), allievo1.getNome()));
        }else{
            System.out.println(String.format(CostantiTesto.finePartita(), allievo2.getNome()));
        }

        //stampa l'equilibrio del mondo per quella partita
        stampaEquilibrio(pacchetto_di_pietre);

    }

    /**
     * metodo per la stampa a video dell'equilibrio
     * @param pacchetto_di_pietre
     */
    private void stampaEquilibrio(PacchettoPietre pacchetto_di_pietre){

        int[][] matrice;
        matrice = trasformaMatrice(pacchetto_di_pietre);

        //prima riga mi stampa solo elementi a cui poi verranno incolonnati i valori dei danni
        System.out.println("");
        for (int i = 0; i <= CostantiNumeriche.getN(); i++){
            if (i == 0){
                System.out.print(String.format("%10c", '|'));
            }else{
                System.out.print(String.format("%9s", String.valueOf(Elementi.values()[i - 1])) + "|");
            }
        }
        System.out.println("");
        //greghina separatricedi righe
        for(int k = 0; k < (CostantiNumeriche.getN()+1)*10; k++){
            System.out.print("-");
        }
        System.out.println("");
        //stampa della matrice dove la prima colonna sono gli elementi e il resto sono i valori dei danni effettuati, se il numero è
        //positivo, o subiti se il numero è negativo
        for(int i = 0; i < CostantiNumeriche.getN(); i++){
            for(int j = 0; j <= CostantiNumeriche.getN(); j++){
                if(j == 0){
                    System.out.print(String.format("%9s", String.valueOf(Elementi.values()[i])) + "|");
                }else{
                    System.out.print(String.format("%9d", matrice[i][j-1]) + "|");
                }
            }
            System.out.println("");
            for(int k = 0; k < (CostantiNumeriche.getN() + 1)*10; k++){
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * metodo che mi trasforma la mappa in una matrice  da stampare
     * @param pacchetto_di_pietre
     * @return matrice equilibrio
     */
    private int[][] trasformaMatrice(PacchettoPietre pacchetto_di_pietre){
        int[][] matrice = new int[CostantiNumeriche.getN()][CostantiNumeriche.getN()];

        //prendo il valore che l'equilibrio ha generato per le pietre e lo inserisco in una matrice da stamoare
        for(int i =0; i < CostantiNumeriche.getN(); i++){
            for(int j = 0; j < CostantiNumeriche.getN(); j++){
                matrice[i][j] = pacchetto_di_pietre.getEquilibrio_del_mondo().get(i).getDanni_elementi().get(String.valueOf(Elementi.values()[j]));
            }
        }
        return matrice;
    }

    /**
     * metodo di appoggio che controlla che gli allievi non usino pietre uguali
     * in ogni singolo turno generando un loop infinito
     * @param pietre_golem_1
     * @param pietre_golem_2
     */
    private void controlloPietre(ArrayList<Pietra> pietre_golem_1, ArrayList<Pietra> pietre_golem_2){

        boolean uguali= false;
        do{

            if(pietre_golem_1.equals(pietre_golem_2)){
                Collections.shuffle(pietre_golem_1);
                System.out.println(CostantiTesto.MESSAGGIO_RIMESCOLO_PIETRE);
            }else{
                uguali= true;
            }

        }while(!uguali);
    }

    /**
     * metodo di appoggio che, dopo la morte di un tamagolem,
     * risistema l'ordine delle pietre di quello sopravvissuto
     * @param turno_pietra
     * @param allievo
     * @param golem_attuale
     * @return
     */
    public int resetPietreVicitore(int turno_pietra, Allievo allievo, int golem_attuale){
        turno_pietra= (turno_pietra +1)%CostantiNumeriche.getP();
        for (int i=0; i<turno_pietra; i++){
            Pietra pt_temp= allievo.getTamagolem().get(golem_attuale).getPietre_degli_elementi().get(i);
            allievo.getTamagolem().get(golem_attuale).getPietre_degli_elementi().remove(i);
            allievo.getTamagolem().get(golem_attuale).getPietre_degli_elementi().add(pt_temp);
        }
        turno_pietra= 0;
        return turno_pietra;
    }

}
