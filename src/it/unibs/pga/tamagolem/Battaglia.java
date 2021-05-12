package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;

public class Battaglia {

    public void combattimento(){

        Equilibrio pacchetto_pietre= faseI();

        Allievo allievo1= creaAllievo(pacchetto_pietre);
        Allievo allievo2= creaAllievo(pacchetto_pietre);

        faseII(allievo1, allievo2);
        faseIII(allievo1, allievo2);

    }

    public Equilibrio faseI (){

        int num_elementi= InputDati.leggiIntero("Quanti elementi vuoi usare?", 3, 10);
        new CostantiNumeriche(num_elementi);

        for (int i= 0; i< CostantiNumeriche.getN(); i++){
            //crea equilibrio
                //crea interazioni in una matrice
                //crea pietre
        }
    }

    public void faseII(Allievo allievo1, Allievo allievo2){
        //evocazione iniziale

        do{

        }while(!allievo1.isIs_vincitore() && !allievo2.isIs_vincitore());
    }

    public void faseIII(Allievo allievo1, Allievo allievo2){

        if (allievo1.isIs_vincitore()){
            System.out.println(String.format(CostantiTesto.finePartita(), allievo1.getNome()));
        }else{
            System.out.println(String.format(CostantiTesto.finePartita(), allievo2.getNome()));
        }

        //rivelazione equilibrio
    }

    private Allievo creaAllievo(Equilibrio pacchetto_pietre){
        String nome= InputDati.leggiStringaNonVuota("nome allievo");
        Allievo allievo= new Allievo(nome, pacchetto_pietre);

        return allievo;
    }
}
