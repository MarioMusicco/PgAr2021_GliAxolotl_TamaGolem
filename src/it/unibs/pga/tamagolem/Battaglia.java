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

        for (int i= 0; i< num_elementi; i++){

        }

    }

    public void faseII(){

    }

    public void faseIII(){

    }
}
