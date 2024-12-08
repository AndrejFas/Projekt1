import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //otestujCasovo();

        mojAlg(200,50,20);

    }

    private static void mojAlg(int rozsah,int dlzka,int pocet) {
        int[][] vysledok = new int[pocet][dlzka];
        int[] pocetNastavenych = new int[pocet];
        int castDlzka = rozsah/pocet;

        //jednoducho rozdelim co sa da rozdelit
        for (int i = 0; i < pocet; i++) {
            for (int j = 0; j < castDlzka; j++) {
                vysledok[i][j] = i*castDlzka + j;
                pocetNastavenych[i]++;
            }
        }

        //prerozdelim zvysok
        for (int i = 0; i < rozsah - (castDlzka*pocet); i++) {
            vysledok[i][pocetNastavenych[i]] = (castDlzka*pocet) + i;
            pocetNastavenych[i]++;
        }

        //doplnovanie
        int posunStlpcov = 0;
        while (vysledok[0][dlzka-1] == 0){
            for (int i = 0; i < pocet; i++) {
                int riadok = 1;
                int stlpec = 0;
                int poc = pocetNastavenych[i]+pocet-1;
                for (int j = pocetNastavenych[i]; j < poc; j++) {
                    if ((i + riadok) % pocet == i) {
                        riadok++;
                        stlpec++;
                    }
                    if (j == dlzka) break;
                    vysledok[i][j] = vysledok[(i + riadok) % pocet][(i + stlpec) + posunStlpcov];
                    pocetNastavenych[i]++;
                    riadok++;
                }
            }
            posunStlpcov += castDlzka;
        }



        for (int i = 0; i < pocet; i++) {
            for (int j = 0; j < dlzka; j++) {
                System.out.print(vysledok[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < pocet-1; i++) {
            for (int j = i+1; j < pocet; j++) {
                int sum = 0;
                for (int k = 0; k < dlzka; k++) {
                    for (int l = 0; l < dlzka; l++) {
                        if (vysledok[i][k] == vysledok[j][l]) sum++;
                    }
                }
                System.out.println(sum + " ");
            }
            System.out.println();
        }

        /*int[] kontrola = new int[rozsah];
        for (int i = 0; i < pocet; i++) {
            for (int j = 0; j < dlzka; j++) {
                kontrola[vysledok[i][j]]++;
            }
        }

        for (int i = 0; i < kontrola.length; i++) {
            System.out.print(kontrola[i] + " ");
        }*/

    }

    public static void otestujCasovo(){
        int velkostMnozinyRieseni = 75;
        int minPocetIteracii = 800;

        //=============================== Uloha 1
        ArrayList<Predmet> predmety = vygenerujPredmetyRovnomerne(2000);
        int kapacitaBatoha = 1000;

        GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
        g.vypocitaj(velkostMnozinyRieseni, true, 10000,25, 300);


        /*for (int i = 0; i < 10; i++) {
            GenetickyAlgoritmus g = new GenetickyAlgoritmus(predmety, kapacitaBatoha);
            g.vypocitaj(velkostMnozinyRieseni, true, 10000,32, 500);
        }*/
        /*System.out.println();
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
        }*/
        vypocitajNecelociselne(predmety, kapacitaBatoha);

/*        //=============================== Uloha 2
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
        }/*
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
        vypocitajNecelociselne(predmety, kapacitaBatoha);*/
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