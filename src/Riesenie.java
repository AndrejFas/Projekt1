import java.util.ArrayList;
import java.util.Arrays;

public class Riesenie {
    private final int[] riesenie;

    public Riesenie(int x){
        riesenie = new int[x];
        Arrays.fill(riesenie, 0);
    }

    public int getCenuRiesenia(ArrayList<Predmet> p){
        int sum = 0;
        for (int i = 0; i < riesenie.length; i++) {
            sum = sum + riesenie[i]*p.get(i).getCena();
        }
        return sum;
    }

    public int getVahuRiesenia(ArrayList<Predmet> p){
        int sum = 0;
        for (int i = 0; i < riesenie.length; i++) {
            sum = sum + riesenie[i]*p.get(i).getVaha();
        }
        return sum;
    }

    public void nastavNaIndexeHodnotu(int index, int hodnota){
        riesenie[index] = hodnota;
    }

    public int getHodnotuZIndexu(int index){
        return riesenie[index];
    }

}
