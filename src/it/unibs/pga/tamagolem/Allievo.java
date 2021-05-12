package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;
import java.util.ArrayList;

public class Allievo {

    private String nome;
    private ArrayList<TamaGolem> tamagolem= new ArrayList<TamaGolem>();
    private ArrayList<Pietra> scortaPietre= new ArrayList<Pietra>();
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

    public ArrayList<TamaGolem> getTamagolem() {
        return tamagolem;
    }

    public void setTamagolem(ArrayList<TamaGolem> tamagolem) {
        this.tamagolem = tamagolem;
    }

    private void creaScortaPietre(Equilibrio pacchetto_pietre) {
        for (int i=0; i<CostantiNumeriche.getN(); i++) {
            for (int j = 0; j < CostantiNumeriche.getS() / CostantiNumeriche.getN(); j++) {
                scortaPietre.add(pacchetto_pietre.getEquilibrio_del_mondo().get(i));
            }
        }
    }

    public void evocazione(){

        TamaGolem golem = new TamaGolem();

        for (int i=0; i< CostantiNumeriche.getP(); i++){

            //stampa delle pietre disponibili
            System.out.println("Hai disponibili:");
            int num_pietre= 0;
            int tipo_pietra= 0;
            for(int p=0; p<scortaPietre.size(); p++){
                if(p+1<scortaPietre.size()){
                    if (scortaPietre.get(p).equals(scortaPietre.get(p+1)))
                        num_pietre++;
                }else{
                    num_pietre++;
                    System.out.println(String.format("%d pietre di tipo %s.", num_pietre, scortaPietre.get(p).getNome(), tipo_pietra));
                    tipo_pietra++;
                    num_pietre=0;
                }
            }

            //prendo la pietra richiesta e la dò al golem
            boolean pietra_valida= false;
            do {
                String pietra_assegnata = InputDati.leggiStringa("Inserisci il nome della pietra da assegnare");
                int j;
                for (j=0; j<scortaPietre.size(); j++){
                    if(pietra_assegnata.equalsIgnoreCase(scortaPietre.get(i).getNome())){
                        golem.daiPietre(scortaPietre.get(i));
                        scortaPietre.remove(scortaPietre.get(i));
                        pietra_valida=true;
                    }
                }
                if (j>=scortaPietre.size())
                    System.out.println("Non esiste una Pietra con quel nome");

            }while(!pietra_valida);
        }

        tamagolem.add(golem);
    }

}
