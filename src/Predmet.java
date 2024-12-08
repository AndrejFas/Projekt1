public class Predmet implements Comparable<Predmet> {
    private final int vaha;
    private final int cena;

    public Predmet(int v, int c){
        vaha = v;
        cena = c;
    }

    public int getVaha() {
        return vaha;
    }

    public int getCena() {
        return cena;
    }

    public double getKoeficient(){
        return (double)cena / (vaha);
    }

    @Override
    public int compareTo(Predmet o) {
        if(getKoeficient() - o.getKoeficient() < 0) return 1;
        else if (getKoeficient() - o.getKoeficient() > 0) return -1;
        else return 0;
    }
}
