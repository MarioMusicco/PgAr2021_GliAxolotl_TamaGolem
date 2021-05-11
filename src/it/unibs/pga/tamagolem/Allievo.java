package it.unibs.pga.tamagolem;

import java.util.ArrayList;

public class Allievo {

    private String nome;
    private ArrayList<TamaGolem> tamagolem;
    //private ArrayList<> scortaPietre;
    private boolean is_vincitore;

    public Allievo(String nome){
        this.nome= nome;
        creaScortaPietre();
        is_vincitore= false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isIs_vincitore() {
        return is_vincitore;
    }

    public void setIs_vincitore(boolean is_vincitore) {
        this.is_vincitore = is_vincitore;
    }

    private void creaScortaPietre() {

    }

    private void creaTamaGolem(){
        TamaGolem golem = new TamaGolem();
        for (int i=0; i< CostantiNumeriche.getP(); i++)
        tamagolem.add(golem);
    }

}
