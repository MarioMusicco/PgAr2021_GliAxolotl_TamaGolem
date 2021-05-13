package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;
import java.util.Random;

public class Battaglia {

    public void combattimento(){

        Equilibrio pacchetto_pietre= faseI();

        /*Allievo allievo1= creaAllievo();
        Allievo allievo2= creaAllievo();

        faseII(allievo1, allievo2, pacchetto_pietre);*/
        faseIII(/*allievo1, allievo2,*/ pacchetto_pietre);

    }

    public Equilibrio faseI (){

        int num_elementi= InputDati.leggiIntero("Quanti elementi vuoi usare?", 3, 10);
        new CostantiNumeriche(num_elementi);

        int[][] matrice= new int[num_elementi][num_elementi];

        //crea equilibrio
        for (int i= 0; i< CostantiNumeriche.getN(); i++){
            for (int j=i; j< CostantiNumeriche.getN(); j++){

                if(i==j) {
                    matrice[i][j] = 0;

                }else if(j== CostantiNumeriche.getN()-1){

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

                        int interazione_parziale=0;
                        for (int k = 0; k <= j; k++) {
                            interazione_parziale += matrice[i][k];
                        }
                        if(controlloValidoPenultimo(j, interazione_parziale)){
                            if(Math.abs(interazione_parziale)< CostantiNumeriche.HPMAX*(CostantiNumeriche.getN()-1 -j)/*questa condizione fa girare tutto il programma*/) {
                                valido = true;
                            }
                        }

                    }while (!valido);
                }
            }
        }


        Equilibrio equilibrio= new Equilibrio(matrice);
        return equilibrio;
    }

    public void faseII(Allievo allievo1, Allievo allievo2, Equilibrio pacchetto_pietre){

        ArrayList<Pietra> scortaPietre = new ArrayList<Pietra>();
        for (int i = 0; i < CostantiNumeriche.getN(); i++) {
            for (int j = 0; j < CostantiNumeriche.getS() / CostantiNumeriche.getN(); j++) {
                scortaPietre.add(pacchetto_pietre.getEquilibrio_del_mondo().get(i));
            }
        }

        //evocazione iniziale
        System.out.println("allievo1 procedi all'evocazione");
        allievo1.evocazione(scortaPietre);

        System.out.println("allevo2 provcedi all'evocazione");
        allievo2.evocazione(scortaPietre);

        int turno_pietra_1=0;
        int golem_g1_attuale=0;
        int turno_pietra_2=0;
        int golem_g2_attuale=0;

        do{
            //scontro
            Pietra ptg1= allievo1.getTamagolem().get(golem_g1_attuale).getPietre_degli_elementi().get(turno_pietra_1);
            Pietra ptg2= allievo2.getTamagolem().get(golem_g2_attuale).getPietre_degli_elementi().get(turno_pietra_2);

            System.out.println("Il tamagolem di g1 ha -- HP rimanenti" +
                    "Il tamagolem di g2 ha -- HP rimanenti");

            int danno= ptg1.getDanni_elementi().get(ptg2.getNome());
            int new_HP;

            if (danno>0){
                new_HP= allievo1.getTamagolem().get(golem_g1_attuale).getHP() -danno;
                allievo1.getTamagolem().get(golem_g1_attuale).setHP(new_HP);
                System.out.println("Il tamagolem di g1 ha subito -- danni");
            }else if(danno<0){
                new_HP= allievo2.getTamagolem().get(golem_g2_attuale).getHP() +danno;
                allievo2.getTamagolem().get(golem_g2_attuale).setHP(new_HP);
                System.out.println("Il tamagolem di g2 ha subito -- danni");
            }else{
                System.out.println("Le pietre si annullano a vicenda, non c'è stato danno");
            }

            //evocazioni successive
            //isVincitore= true
            if(allievo1.getTamagolem().get(golem_g1_attuale).getHP()<=0) {
                System.out.println("Il tamagolem di g1 è stato sconfitto");
                if (allievo1.getTamagolem().size() == CostantiNumeriche.getG()) {
                    allievo2.setIs_vincitore(true);
                }
                else{
                    allievo1.evocazione(scortaPietre);
                    golem_g1_attuale++;
                }
            }

            if(allievo2.getTamagolem().get(golem_g2_attuale).getHP()<=0){
                System.out.println("Il tamagolem di g2 è stato sconfitto");
                if (allievo2.getTamagolem().size() == CostantiNumeriche.getG()) {
                    allievo1.setIs_vincitore(true);
                }else{
                    allievo2.evocazione(scortaPietre);
                    golem_g2_attuale++;
                }
            }


        }while(!allievo1.isIs_vincitore() && !allievo2.isIs_vincitore());
    }

    public void faseIII(/*Allievo allievo1, Allievo allievo2, */Equilibrio pacchetto_di_pietre){

        /*if (allievo1.isIs_vincitore()){
            System.out.println(String.format(CostantiTesto.finePartita(), allievo1.getNome()));
        }else{
            System.out.println(String.format(CostantiTesto.finePartita(), allievo2.getNome()));
        }*/

        //rivelazione equilibrio
        for (int i=0; i<= CostantiNumeriche.getN(); i++){
            for (int j=0; j<= CostantiNumeriche.getN(); j++){
                if (i==0 && j==0) {
                    System.out.print("---------");
                }else if (i==0){
                    System.out.print(String.valueOf(Elementi.values()[j-1]));
                }else if(j==0){
                    System.out.print(pacchetto_di_pietre.getEquilibrio_del_mondo().get(i-1).getNome());
                }else{
                    System.out.print(pacchetto_di_pietre.getEquilibrio_del_mondo().get(i-1).getDanni_elementi().get(String.valueOf(Elementi.values()[j-1])));
                }
            }
            System.out.println("");
        }

    }

    private Allievo creaAllievo(){
        String nome= InputDati.leggiStringaNonVuota("nome allievo");
        Allievo allievo= new Allievo(nome);

        return allievo;
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
