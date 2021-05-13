package it.unibs.pga.tamagolem;

public class CostantiNumeriche {

    public static final int HPMAX= 20;

    private static int N;
    private static int P;
    private static int G;
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
