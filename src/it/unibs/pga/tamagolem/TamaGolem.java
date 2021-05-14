package it.unibs.pga.tamagolem;

import java.util.ArrayList;


public class TamaGolem {

    private int HP;
    private ArrayList<Pietra> pietre_degli_elementi= new ArrayList<Pietra>();

    public TamaGolem() {
        this.HP = CostantiNumeriche.HPMAX;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public ArrayList<Pietra> getPietre_degli_elementi() {
        return pietre_degli_elementi;
    }

    public void setPietre_degli_elementi(ArrayList<Pietra> pietre_degli_elementi) {
        this.pietre_degli_elementi = pietre_degli_elementi;
    }

    public void daiPietre(Pietra pt){
        pietre_degli_elementi.add(pt);
    }
}
