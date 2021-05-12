package it.unibs.pga.tamagolem;

import java.util.HashMap;
import java.util.Map;

public class Pietra {

    private String nome;
    private Map<String, Integer> danni_elementi = new HashMap<>();

    public Pietra(String nome, int[] potenza) {
        this.nome = nome;
       creaDanno(potenza);
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Integer> getDanni_elementi() {
        return danni_elementi;
    }

    public void creaDanno(int[] potenza){

        for (int i=0; i< CostantiNumeriche.getN(); i++){
            String elemento= String.valueOf(Elementi.values()[i]);
            danni_elementi.put(elemento, potenza[i]);
        }
    }
}
