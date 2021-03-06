package it.unibs.pga.tamagolem;

import java.util.ArrayList;
import java.util.Random;

public class PacchettoPietre {

    private ArrayList<Pietra> pietre_dell_equilibrio= new ArrayList<Pietra>();

    public PacchettoPietre() {
        addPietre();
    }

    public ArrayList<Pietra> getEquilibrio_del_mondo() {
        return pietre_dell_equilibrio;
    }

    /**
     * metodo che serve al costruttore per aggiungere le pietre di tutti gli elementi all'arraylist
     */
    private void addPietre (){

        int potenza [][]= creaEquilibrio();

        for (int i=0; i<CostantiNumeriche.getN(); i++){
            Pietra pt= new Pietra(String.valueOf(Elementi.values()[i]), potenza[i]);
            pietre_dell_equilibrio.add(pt);
        }
    }

    /**
     * metodo che crea l'equilibrio del mondo.
     * crea e riempie una matrice con tutte le interazione tra i vari elementi,
     * andando a controllare che le interazini (in abs) non superino i ps massimi del golem
     * e che non siano mai nulle tranne che con elementi uguali
     * @return
     */
    private int[][] creaEquilibrio(){

        int[][] matrice= new int[CostantiNumeriche.getN()][CostantiNumeriche.getN()];

        //avvio un ciclo che mi riempie la matrice di interazioni tra elementi
        for (int i= 0; i< CostantiNumeriche.getN(); i++){
            for (int j=i; j< CostantiNumeriche.getN(); j++){

                //variabili che servono per evitare particolari problemi
                long inizio_tempo= System.currentTimeMillis();
                long fine_tempo= inizio_tempo+ 1000;

                if(i==j) {//lungo la diagonale principale della matrice(in cui si incontrano elementi uguali) interazione è nulla
                    matrice[i][j] = 0;

                }else if(j== CostantiNumeriche.getN()-1 ){//le interazioni dell'ultima colonna portano l'interazione totale a zero

                    int interazione_totale=0;
                    for (int k=0; k<j; k++){
                        interazione_totale+= matrice[i][k];
                    }
                    matrice[i][j]= -interazione_totale;
                    matrice[j][i]= interazione_totale;

                }else{

                    boolean valido= false;
                    do {

                        //creo un'interazione tra un elemento e un altro
                        matrice[i][j] = creaInterazione();
                        //creo l'opposto di quella interazione(l'altro con l'uno)
                        matrice[j][i] = -matrice[i][j];

                        int interazione_parziale_oriz=0;
                        int interazione_parziale_vert=0;
                        for (int k = 0; k <= j; k++) {
                            interazione_parziale_oriz += matrice[i][k];
                        }
                        for (int h=0; h<=i; h++){
                            interazione_parziale_vert+= matrice[h][j];
                        }

                        //controllo la validità di un elemento, andando a verificare che
                        //l'interazione totale non superi un valore per cui non possa mai tornare a zero
                        //senza superare gli HP massimi del tamagolem
                        if(controlloValidoPenultimo(j, interazione_parziale_oriz)){
                            if(Math.abs(interazione_parziale_oriz)< CostantiNumeriche.HPMAX*(CostantiNumeriche.getN()-1 -j)) {
                                valido = true;
                                if(i== CostantiNumeriche.getN()-3 && j== CostantiNumeriche.getN()-2 ){
                                    if(Math.abs(interazione_parziale_vert)>CostantiNumeriche.HPMAX || Math.abs(interazione_parziale_vert)== 0){
                                        valido = false;
                                    }
                                }
                            }
                        }

                        //controllo che resetta la matrice se necessita di un numero preciso per essere ottenuto randomicamente
                        if(System.currentTimeMillis()> fine_tempo){
                            i=0;
                            j=-1;
                            break;
                        }

                    }while (!valido);
                }
            }
        }
        return matrice;
    }

    /**
     * metodo di appoggio che serve a creare il numero pseudo-causale
     * che andrà a definire l'interazione tra due elementi
     * @return
     */
    private int creaInterazione(){

        int interazione;
        boolean segno;
        Random rn = new Random ();

        interazione= rn.nextInt(CostantiNumeriche.HPMAX)+1;

        segno= rn.nextBoolean();
        if(!segno){
            interazione= -interazione;
        }

        return interazione;
    }

    /**
     * metodo di appoggio che gestisce una delle condizioni
     * di controllo per la validità di un valore di interazione
     * @param pos
     * @param interazione
     * @return
     */
    private boolean controlloValidoPenultimo(int pos, int interazione){

        if (pos== CostantiNumeriche.getN()-2 && interazione==0){
            return false;
        }
        return true;
    }


}
