package it.unibs.pga.tamagolem;

import java.util.ArrayList;

public class Allievo {

    private String nome;
    private ArrayList<TamaGolem> tamaGolem;
    private ArrayList<> scortaPietre;

    public Allievo(String nome){
        this.nome= nome;
        creaScortaPietre();
    }

    private void creaScortaPietre() {

    }

    private void creaTamaGolem(){
        TamaGolem golem = new TamaGolem();
        for (int i=0; i< P; i++)
        tamaGolem.add(golem);
    }

}
