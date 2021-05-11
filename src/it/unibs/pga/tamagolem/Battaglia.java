package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;

public class Battaglia {

    public void combattimento(){

        faseI();
        faseII();
        faseIII();

    }

    public void faseI (){

        int num_elementi= InputDati.leggiIntero("Quanti elementi vuoi usare?", 3, 10);
        CostantiNumeriche cs = new CostantiNumeriche(num_elementi);

        for (int i= 0; i< cs.N; i++){
            //crea equilibrio
                //crea interazioni in una matrice
                //crea pietre
        }



    }

    public void faseII(){

    }

    public void faseIII(){

    }
}
