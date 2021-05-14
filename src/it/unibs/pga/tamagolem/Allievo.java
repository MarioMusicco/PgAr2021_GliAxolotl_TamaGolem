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


    /**
     * metodo che permette di evocare un tamagolem.
     * inizia dicendo che pietre ci sono nel sacchetto,
     * poi chiede al giocatore di inserire le varie pietre da dare al golem
     * (andando a controllare che siano disponibili)
     * @param scortaPietre
     */
    public void evocazione(ArrayList<Pietra> scortaPietre) {

        TamaGolem golem = new TamaGolem();

        for (int i = 0; i < CostantiNumeriche.getP(); i++) {

            //stampa delle pietre disponibili
            System.out.println(CostantiTesto.MESSAGGIO_SACCHETTO);
            int num_pietre = 0;
            int tipo_pietra = 0;
            for (int p = 0; p < scortaPietre.size(); p++) {
                if (controlloQtaPietre(p, scortaPietre)) {
                    num_pietre++;
                } else {
                    num_pietre++;
                    System.out.println(String.format(CostantiTesto.QTA_E_TIPO_DI_PIETRE, num_pietre, scortaPietre.get(p).getNome(), tipo_pietra));
                    tipo_pietra++;
                    num_pietre = 0;
                }
            }

            //prendo la pietra richiesta e la dò al golem se disponibile
            boolean pietra_valida = false;
            do {
                String pietra_assegnata = InputDati.leggiStringa(CostantiTesto.RICHIESTA_PIETRA);
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
                    System.out.println(CostantiTesto.INESISTENZA_PIETRA_INSERITA);

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
