package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.Random;

public class Battaglia {

    public void combattimento(){

        Equilibrio pacchetto_pietre= faseI();

       Allievo allievo1= creaAllievo(pacchetto_pietre);
        Allievo allievo2= creaAllievo(pacchetto_pietre);

        faseII(allievo1, allievo2);
        faseIII(allievo1, allievo2, pacchetto_pietre);

    }

    public Equilibrio faseI (){

        int num_elementi= InputDati.leggiIntero("Quanti elementi vuoi usare?", 3, 10);
        new CostantiNumeriche(num_elementi);

        int[][] matrice= new int[num_elementi][num_elementi];
        Random rn = new Random ();

        for (int i= 0; i< CostantiNumeriche.getN(); i++){
            //crea equilibrio
                //crea interazioni in una matrice
                //crea pietre
            for (int j=0; j< CostantiNumeriche.getN(); j++){

                matrice[i][j]= rn.nextInt(10);


            }
        }

        Equilibrio eq= new Equilibrio(matrice);
        return eq;
    }

    public void faseII(Allievo allievo1, Allievo allievo2){
        //evocazione iniziale
        System.out.println("allievo1 procedi all'evocazione");
        allievo1.evocazione();

        System.out.println("allevo2 provcedi all'evocazione");
        allievo2.evocazione();

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

            if (danno>=0){
                new_HP= allievo1.getTamagolem().get(golem_g1_attuale).getHP() -danno;
                allievo1.getTamagolem().get(golem_g1_attuale).setHP(new_HP);
                System.out.println("Il tamagolem di g1 ha subito -- danni");
            }else {
                new_HP= allievo2.getTamagolem().get(golem_g2_attuale).getHP() +danno;
                allievo2.getTamagolem().get(golem_g2_attuale).setHP(new_HP);
                //System.out.println("Il tamagolem di g1 ha subito -- danni");
            }

            //evocazioni successive
            //isVincitore= true
            if(allievo1.getTamagolem().get(golem_g1_attuale).getHP()<=0) {
                System.out.println("Il tamagolem di g1 è stato sconfitto");
                if (allievo1.getTamagolem().size() == CostantiNumeriche.getG()) {
                    allievo2.setIs_vincitore(true);
                }
                else{
                    allievo1.evocazione();
                    golem_g1_attuale++;
                }
            }

            if(allievo2.getTamagolem().get(golem_g2_attuale).getHP()<=0){
                //System.out.println("Il tamagolem di g1 è stato sconfitto");
                if (allievo2.getTamagolem().size() == CostantiNumeriche.getG()) {
                    allievo1.setIs_vincitore(true);
                }else{
                    allievo2.evocazione();
                    golem_g2_attuale++;
                }
            }


        }while(!allievo1.isIs_vincitore() && !allievo2.isIs_vincitore());
    }

    public void faseIII(Allievo allievo1, Allievo allievo2, Equilibrio pacchetto_di_pietre){

        if (allievo1.isIs_vincitore()){
            System.out.println(String.format(CostantiTesto.finePartita(), allievo1.getNome()));
        }else{
            System.out.println(String.format(CostantiTesto.finePartita(), allievo2.getNome()));
        }

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


    private Allievo creaAllievo(Equilibrio pacchetto_pietre){
        String nome= InputDati.leggiStringaNonVuota("nome allievo");
        Allievo allievo= new Allievo(nome, pacchetto_pietre);

        return allievo;
    }
}
