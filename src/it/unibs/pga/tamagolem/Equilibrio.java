package it.unibs.pga.tamagolem;

import java.util.ArrayList;

public class Equilibrio {

    private ArrayList<Pietra> equilibrio_del_mondo= new ArrayList<Pietra>();

    public Equilibrio(int[][] potenza) {
        addPietra(potenza);
    }

    public void addPietra (int potenza [][]){

        for (int i=0; i<CostantiNumeriche.getN(); i++){
            Pietra pt= new Pietra(String.valueOf(Elementi.values()[i]), potenza[i]);
            equilibrio_del_mondo.add(pt);
        }
    }
}
