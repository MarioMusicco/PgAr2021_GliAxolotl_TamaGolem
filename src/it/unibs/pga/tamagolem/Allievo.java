package it.unibs.pga.tamagolem;

import java.util.ArrayList;

public class Allievo {

    private String nome;
    private ArrayList<TamaGolem> tamagolem= new ArrayList<TamaGolem>();
    private ArrayList<Equilibrio> scortaPietre= new ArrayList<Equilibrio>();
    private boolean is_vincitore;

    public Allievo(String nome, Equilibrio pacchetto_pietre){
        this.nome= nome;
        creaScortaPietre(pacchetto_pietre);
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

    private void creaScortaPietre(Equilibrio pacchetto_pietre) {
        for (int i=0; i<CostantiNumeriche.getP()/CostantiNumeriche.getS(); i++){
            scortaPietre.add(pacchetto_pietre);
        }
    }

    private void evocazione(){
        TamaGolem golem = new TamaGolem();
        for (int i=0; i< CostantiNumeriche.getP(); i++){

        }
        tamagolem.add(golem);
    }

}
