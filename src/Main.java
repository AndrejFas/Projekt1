import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //otestujCasovo();
        otestujPocet();
    }

    private static void test() {
        ArrayList<Predmet> predmety = vygenerujPredmetyRovnomerne(2000);
        int kapacitaBatoha = 1000;

        GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
        g.test(100,true,100000,20,200);
    }

    public static void otestujPocet(){
        int velkostMnozinyRieseni = 75;
        int minPocetIteracii = 400;

        //=============================== Uloha 1
        ArrayList<Predmet> predmety = vygenerujPredmetyRovnomerne(2000);
        int kapacitaBatoha = 1000;


        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,50, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,55, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,60, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 2
        predmety = vygenerujPredmetyRovnomerne(5000);
        kapacitaBatoha = 2000;


        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,100, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,105, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,110, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 3
        predmety = vygenerujPredmetyRovnomerne(8000);
        kapacitaBatoha = 3000;


        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,150, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,155, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,160, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);
        //=============================== Uloha 4
        predmety = vygenerujPredmetyLinearne(2000);
        kapacitaBatoha = 1000;


        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,20, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,25, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,30, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 5
        predmety = vygenerujPredmetyLinearne(5000);
        kapacitaBatoha = 2000;


        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,40, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,45, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,50, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 6
        predmety = vygenerujPredmetyLinearne(8000);
        kapacitaBatoha = 3000;


        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,65, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,70, minPocetIteracii);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,75, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);
    }

    public static void otestujCasovo(){
        int velkostMnozinyRieseni = 75;
        int minPocetIteracii = 800;

        //=============================== Uloha 1
        ArrayList<Predmet> predmety = vygenerujPredmetyRovnomerne(2000);
        int kapacitaBatoha = 1000;

        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,32, 500);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,25, 600);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,25, 700);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,25, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 2
        predmety = vygenerujPredmetyRovnomerne(5000);
        kapacitaBatoha = 2000;

        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, 500);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, 600);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, 700);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 3
        predmety = vygenerujPredmetyRovnomerne(8000);
        kapacitaBatoha = 3000;

        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,75, 500);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,75, 600);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,75, 700);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,75, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);
        //=============================== Uloha 4
        predmety = vygenerujPredmetyLinearne(2000);
        kapacitaBatoha = 1000;

        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,21, 500);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,21, 600);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,21, 700);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,21, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 5
        predmety = vygenerujPredmetyLinearne(5000);
        kapacitaBatoha = 2000;

        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, 500);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, 600);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, 700);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 30000,46, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);

        //=============================== Uloha 6
        predmety = vygenerujPredmetyLinearne(8000);
        kapacitaBatoha = 3000;

        for (int i = 0; i < 5; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 20000,5, 100);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,69, 600);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,69, 700);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 60000,69, minPocetIteracii);
        }
        vypocitajNecelociselne(predmety, kapacitaBatoha);
    }

    public static ArrayList<Predmet> vygenerujPredmetyRovnomerne(int pocet){
        ArrayList<Predmet> p = new ArrayList<>();
        Random r = new Random(1);

        for (int i = 0; i < pocet; i++) {
            p.add(new Predmet(r.nextInt(90) + 10, r.nextInt(90) + 10));
        }

        return p;
    }

    public static ArrayList<Predmet> vygenerujPredmetyLinearne(int pocet){
        ArrayList<Predmet> p = new ArrayList<>();
        Random r1 = new Random(1);
        Random r2 = new Random(3);

        for (int i = 0; i < pocet; i++) {
            p.add(new Predmet(Math.max(r1.nextInt(90),r2.nextInt(90)) + 10, Math.max(r1.nextInt(90),r2.nextInt(90) + 10)));
        }

        return p;
    }
    public static  void vypocitajNecelociselne(ArrayList<Predmet> predmets, int kapacitaBatoha){
        double sum = 0;
        double priestorVBatohu = kapacitaBatoha;
        int[] pouzite = new int[predmets.size()];
        Arrays.fill(pouzite,0);

        while(true){
            int index = 0;
            double maxKoef = 0;
            for (int i = 0; i < predmets.size(); i++) {
                if (predmets.get(i).getKoeficient() > maxKoef && pouzite[i] == 0){
                    maxKoef = predmets.get(i).getKoeficient();
                    index = i;
                }
            }
            if (priestorVBatohu > predmets.get(index).getVaha()){
                sum = sum + predmets.get(index).getCena();
                priestorVBatohu = priestorVBatohu - predmets.get(index).getVaha();
                pouzite[index] = 1;

            } else {
                sum = sum + (predmets.get(index).getCena() * (priestorVBatohu / predmets.get(index).getVaha()));
                break;
            }
        }

        System.out.println("Necelociselne riesenie: " + sum);

    }
}