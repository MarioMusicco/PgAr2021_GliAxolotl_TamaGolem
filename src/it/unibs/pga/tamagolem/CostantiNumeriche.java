package it.unibs.pga.tamagolem;

public class CostantiNumeriche {

    //vita massima tamagolem
    public static final int HPMAX= 20;

    //num elementi
    private static int N;
    //num pietre per golem
    private static int P;
    //num golem per allievo
    private static int G;
    //num pietre nel sacchetto
    private static int S;

    public CostantiNumeriche(int N) {
        this.N= N;
        P = (int) creaP(N);
        G = (int)creaG(N);
        S = (int) Math.ceil((2*creaG(N)*creaP(N))/N) * N;
    }

    public static int getN() {
        return N;
    }

    public static int getP() {
        return P;
    }

    public static int getG() {
        return G;
    }

    public static int getS() {
        return S;
    }

    private double creaP(int N){
        double n= (double) N;
        return Math.ceil((n + 1) / 3) + 1;
    }

    private double creaG(int N){
        double n= (double) N;
        return Math.ceil((n-1)*(n-2)/(2*creaP(N)));
    }

}
