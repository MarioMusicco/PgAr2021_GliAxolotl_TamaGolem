package it.unibs.pga.tamagolem;

import java.util.HashMap;
import java.util.Map;

public class Pietra {

    private String nome;
    private Map<String, Integer> danni_elementi = new HashMap<>();

    public Pietra(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void creaDanno(String elemento, int potenza){
        danni_elementi.put(elemento, potenza);
    }
}
