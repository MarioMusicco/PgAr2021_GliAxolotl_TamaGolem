package it.unibs.pga.tamagolem;

import java.util.ArrayList;
import java.util.Random;

public class PacchettoPietre {

    private ArrayList<Pietra> equilibrio_del_mondo= new ArrayList<Pietra>();

    public PacchettoPietre() {
        addPietra();
    }

    public ArrayList<Pietra> getEquilibrio_del_mondo() {
        return equilibrio_del_mondo;
    }

    private void addPietra (){

        int potenza [][]= creaEquilibrio();

        for (int i=0; i<CostantiNumeriche.getN(); i++){
            Pietra pt= new Pietra(String.valueOf(Elementi.values()[i]), potenza[i]);
            equilibrio_del_mondo.add(pt);
        }
    }

    private int[][] creaEquilibrio(){

        int[][] matrice= new int[CostantiNumeriche.getN()][CostantiNumeriche.getN()];

        //crea equilibrio
        for (int i= 0; i< CostantiNumeriche.getN(); i++){
            for (int j=i; j< CostantiNumeriche.getN(); j++){

                long inizio_tempo= System.currentTimeMillis();
                long fine_tempo= inizio_tempo+ 1000;

                if(i==j) {
                    matrice[i][j] = 0;

                }else if(j== CostantiNumeriche.getN()-1 ){

                    //penultima riga, terzultima colonna
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

    private boolean controlloValidoPenultimo(int pos, int interazione){

        if (pos== CostantiNumeriche.getN()-2 && interazione==0){
            return false;
        }
        return true;
    }


}
