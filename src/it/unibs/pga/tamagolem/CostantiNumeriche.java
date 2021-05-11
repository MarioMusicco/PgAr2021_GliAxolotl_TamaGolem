package it.unibs.pga.tamagolem;

public class CostantiNumeriche {

    private static int N;
    private static int P;
    private static int G;
    private static int S;

    public CostantiNumeriche(int N) {
        this.N= N;
        P = (int) Math.ceil((N + 1) / 3) + 1;
        G = (int) Math.ceil((N-1)*(N-2)/(2*P));
        S = (int) Math.ceil((2*N*P)/N) * N;
    }

    public static int getN() {
        return N;
    }

    public static void setN(int n) {
        N = n;
    }

    public static int getP() {
        return P;
    }

    public static void setP(int p) {
        P = p;
    }

    public static int getG() {
        return G;
    }

    public static void setG(int g) {
        G = g;
    }

    public static int getS() {
        return S;
    }

    public static void setS(int s) {
        S = s;
    }
}
