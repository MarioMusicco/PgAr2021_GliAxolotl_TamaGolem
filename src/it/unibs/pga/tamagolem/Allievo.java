package it.unibs.pga.tamagolem;

import it.unibs.fp.mylib.InputDati;
import java.util.ArrayList;

public class Allievo {

    private String nome;
    private ArrayList<TamaGolem> tamagolem = new ArrayList<TamaGolem>();
    private boolean is_vincitore;

    public Allievo(String nome) {
        this.nome = nome;
        is_vincitore = false;
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


    public void evocazione(ArrayList<Pietra> scortaPietre) {

        TamaGolem golem = new TamaGolem();

        for (int i = 0; i < CostantiNumeriche.getP(); i++) {

            //stampa delle pietre disponibili
            System.out.println("Il sacchetto di Pietre contiene:");
            int num_pietre = 0;
            int tipo_pietra = 0;
            int r;
            for (int p = 0; p < scortaPietre.size(); p++) {
                r = p + 1;
                if (controlloQtaPietre(p, scortaPietre)) {
                    num_pietre++;
                } else {
                    num_pietre++;
                    System.out.println(String.format("- %d pietre di tipo %s", num_pietre, scortaPietre.get(p).getNome(), tipo_pietra));
                    tipo_pietra++;
                    num_pietre = 0;
                }
            }

            //prendo la pietra richiesta e la dò al golem
            boolean pietra_valida = false;
            do {
                String pietra_assegnata = InputDati.leggiStringa("Inserisci il nome della pietra da assegnare");
                int j;
                for (j = 0; j < scortaPietre.size(); j++) {
                    if (pietra_assegnata.equalsIgnoreCase(scortaPietre.get(j).getNome())) {
                        golem.daiPietre(scortaPietre.get(j));
                        scortaPietre.remove(scortaPietre.get(j));
                        pietra_valida = true;
                        j--;
                        break;
                    }
                }
                if (j >= scortaPietre.size())
                    System.out.println("Non esiste una Pietra con quel nome");

            } while (!pietra_valida);
        }

        tamagolem.add(golem);
    }

    /**
     * metodo che serve per controllare che la pietra successiva esista
     * e che sia uguale alla attuale
     * @param p
     * @param scortaPietre
     * @return
     */
    private boolean controlloQtaPietre(int p, ArrayList<Pietra> scortaPietre){

        if(p+1<scortaPietre.size()){
            if (scortaPietre.get(p).getNome().equals(scortaPietre.get(p+1).getNome()))
                return true;
            return false;
        }
        return false;
    }
}
