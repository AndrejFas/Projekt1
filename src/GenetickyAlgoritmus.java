import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.currentTimeMillis;

public class GenetickyAlgoritmus {
    private ArrayList<Predmet> predmety;
    private int kapacitaBatoha;
    private ArrayList<Riesenie> mnozinaRieseni;
    private ArrayList<Riesenie> novaMnozinaRieseni;
    private Riesenie najlepsieNajdeneRiesenie;
    private int cenaNajlepsiehoRiesenia;

    public GenetickyAlgoritmus(ArrayList<Predmet> p,  int kB){
        cenaNajlepsiehoRiesenia = 0;
        novaMnozinaRieseni = new ArrayList<>();
        mnozinaRieseni = new ArrayList<>();
        predmety = p;
        kapacitaBatoha = kB;
    }

    public void vypocitaj(int vMR, boolean enchanced, long trvanie, int pocet, int minPocetIteracii){
        Random ran = new Random();

        if (enchanced) vytvorPociatocnuMnozinuRieseni(pocet, vMR);
        else vytvorPociatocnuMnozinuRieseni(vMR);

        int[] x = new int[predmety.size()];
        for (int i = 0; i < mnozinaRieseni.size(); i++) {
            for (int j = 0; j < predmety.size(); j++) {
                x[j] = x[j] + mnozinaRieseni.get(i).getHodnotuZIndexu(j);
            }
        }
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }

        int counter = 0;

        long start = currentTimeMillis();

        while (start + trvanie > currentTimeMillis() || counter < minPocetIteracii){

            int celkovySum = 0;
            for (Riesenie r: mnozinaRieseni) {
                celkovySum = celkovySum + r.getCenuRiesenia(predmety);
            }

            for (int i = 0; i < vMR; i++) {
                Riesenie[] dveRiesenia = parovanie(celkovySum, ran);
                dveRiesenia = krizenie(dveRiesenia, ran);
                Riesenie noveR1 =  mutacia(dveRiesenia[0], ran);
                Riesenie noveR2 =  mutacia(dveRiesenia[1], ran);

                int cenaR1 = noveR1.getCenuRiesenia(predmety);
                int cenaR2 = noveR2.getCenuRiesenia(predmety);


                if ( cenaR1 > cenaR2){
                    novaMnozinaRieseni.add(noveR1);
                    if (cenaR1 > cenaNajlepsiehoRiesenia) {
                        cenaNajlepsiehoRiesenia = cenaR1;
                        najlepsieNajdeneRiesenie = noveR1;
                        //System.out.println("Naslo sa nove najlepsie riesenie:" + cenaNajlepsiehoRiesenia);

                    }
                } else {
                    novaMnozinaRieseni.add(noveR2);
                    if (cenaR2 > cenaNajlepsiehoRiesenia) {
                        cenaNajlepsiehoRiesenia = cenaR2;
                        najlepsieNajdeneRiesenie = noveR2;
                        //System.out.println("Naslo sa nove najlepsie riesenie:" + cenaNajlepsiehoRiesenia);

                    }
                }
            }

            mnozinaRieseni = novaMnozinaRieseni;
            novaMnozinaRieseni = new ArrayList<>();

            counter++;
        }
        System.out.println(cenaNajlepsiehoRiesenia + " ; " + counter + " ; " + (currentTimeMillis() - start)/1000);
    }


    private Riesenie[] parovanie(int cS, Random random){
        Riesenie[] retRiesenia = new Riesenie[2];
        Riesenie r1 = null;
        Riesenie r2 = null;

        int celkovySum = 0;
        for (Riesenie r: mnozinaRieseni) {
            celkovySum = celkovySum + r.getCenuRiesenia(predmety);
        }


        double sum = 0;

        double randomDouble1 = random.nextDouble();
        double randomDouble2 = random.nextDouble();

        for (int i = 0; i < mnozinaRieseni.size(); i++) {
            sum = sum + ((double)mnozinaRieseni.get(i).getCenuRiesenia(predmety) / cS);
            if (sum > randomDouble1 && r1 == null) {
                r1 = mnozinaRieseni.get(i);
            }
            if (sum > randomDouble2 && r2 == null) {
                r2 = mnozinaRieseni.get(i);
            }
            if (r1 != null && r2 != null) break;
        }
        retRiesenia[0] = r1;
        retRiesenia[1] = r2;

        return  retRiesenia;
    }

    private Riesenie[] krizenie(Riesenie[] vstupRiesenia, Random random){
        Riesenie r1 = new Riesenie(predmety.size());
        Riesenie r2 = new Riesenie(predmety.size());

        int x = random.nextInt(predmety.size());

        for (int i = 0; i < predmety.size(); i++) {
            if (x > i){
                r1.nastavNaIndexeHodnotu(i,vstupRiesenia[0].getHodnotuZIndexu(i));
                r2.nastavNaIndexeHodnotu(i,vstupRiesenia[1].getHodnotuZIndexu(i));
            } else {
                r1.nastavNaIndexeHodnotu(i,vstupRiesenia[1].getHodnotuZIndexu(i));
                r2.nastavNaIndexeHodnotu(i,vstupRiesenia[0].getHodnotuZIndexu(i));
            }
        }
        return new Riesenie[]{r1 , r2};
    }

    private Riesenie mutacia(Riesenie vstupR, Random random){
        Riesenie vystupR;

        ArrayList<Integer> indexyNepouzitych = new ArrayList<>();
        for (int i = 0; i < predmety.size(); i++) {
            if (vstupR.getHodnotuZIndexu(i) == 0) indexyNepouzitych.add(i);
        }

        double sumPravd = 0;
        for (int i = 0; i < indexyNepouzitych.size(); i++) {
            sumPravd = sumPravd + predmety.get(indexyNepouzitych.get(i)).getKoeficient();
        }

        double x = random.nextDouble();
        double sumP = 0;
        for (int i = 0; i < indexyNepouzitych.size(); i++) {
            sumP = sumP + (predmety.get(indexyNepouzitych.get(i)).getKoeficient() / sumPravd);
            if (x < sumP){
                vstupR.nastavNaIndexeHodnotu(indexyNepouzitych.get(i), 1);
                indexyNepouzitych.remove(i);
                break;
            }
        }
        vystupR =  nahodneOpravRiesenie(vstupR, random);

        return vystupR;
    }

    private void vytvorPociatocnuMnozinuRieseni(int pocet) {
        Random random = new Random();
        for (int i = 0; i < pocet; i++) {
            Riesenie riesenie = new Riesenie(predmety.size());
            while (true){
                int x = random.nextInt(predmety.size());

                riesenie.nastavNaIndexeHodnotu(x,1);
                if (riesenie.getVahuRiesenia(predmety) > kapacitaBatoha){
                    riesenie.nastavNaIndexeHodnotu(x,0);
                    break;
                } else if (riesenie.getVahuRiesenia(predmety) == kapacitaBatoha) {
                    break;
                }
            }

            mnozinaRieseni.add(riesenie);

            if (najlepsieNajdeneRiesenie == null){
                najlepsieNajdeneRiesenie = riesenie;
                cenaNajlepsiehoRiesenia = riesenie.getCenuRiesenia(predmety);
            } else {
                int cenaNovehoRiesenia = riesenie.getCenuRiesenia(predmety);
                if (cenaNajlepsiehoRiesenia < cenaNovehoRiesenia) {
                    cenaNajlepsiehoRiesenia = cenaNovehoRiesenia;
                    najlepsieNajdeneRiesenie = riesenie;
                }
            }
        }
    }

    private Riesenie nahodneOpravRiesenie(Riesenie vstupR, Random random){
        ArrayList<Integer> indexyPouzitych = new ArrayList<>();
        for (int i = 0; i < predmety.size(); i++) {
            if (vstupR.getHodnotuZIndexu(i) == 1) indexyPouzitych.add(i);
        }
        while (vstupR.getVahuRiesenia(predmety) > kapacitaBatoha){

            double sumPravd = 0;
            for (int i = 0; i < indexyPouzitych.size(); i++) {
                sumPravd = sumPravd + predmety.get(indexyPouzitych.get(i)).getKoeficient();
            }

            double x = random.nextDouble();
            double sumP = 0;
            for (int i = 0; i < indexyPouzitych.size(); i++) {
                sumP = sumP + (( 1 / predmety.get(indexyPouzitych.get(i)).getKoeficient())  / sumPravd);
                if (x < sumP){
                    vstupR.nastavNaIndexeHodnotu(indexyPouzitych.get(i), 0);
                    indexyPouzitych.remove(i);
                    break;
                }
            }
        }
        return vstupR;
    }

    private void vytvorPociatocnuMnozinuRieseni(int pocet, int pocetRieseni){
        Random random = new Random(123);
        predmety.sort(Predmet::compareTo);

        int pocetVyhodnych = predmety.size() / 10;

        ArrayList<Integer> vytvaraciArr = null;
        int prekryv = 0;
        while (vytvaraciArr == null){
            vytvaraciArr = mptPostup(pocetVyhodnych, pocet+1, prekryv);
            prekryv++;
        }

        int posun = ((vytvaraciArr.size() - (pocetRieseni * pocet)) / pocetRieseni)/pocet;

        if (vytvaraciArr.size() >= pocet*pocetRieseni) {
            int index = 0;
            for (int i = 0; i < pocetRieseni; i++) {
                Riesenie r = new Riesenie(predmety.size());
                for (int j = 0; j < pocet; j++) {
                    r.nastavNaIndexeHodnotu(vytvaraciArr.get(index), 1);
                    index++;
                }
                index += posun*pocet;
                while (true){
                    int id = random.nextInt(predmety.size()-pocetVyhodnych) + pocetVyhodnych;
                    r.nastavNaIndexeHodnotu(id,1);
                    if (r.getVahuRiesenia(predmety) > kapacitaBatoha){
                        r.nastavNaIndexeHodnotu(id,0);
                        break;
                    }
                }

                mnozinaRieseni.add(r);
                if (r.getVahuRiesenia(predmety) <= kapacitaBatoha) {
                    if (najlepsieNajdeneRiesenie == null) {
                        najlepsieNajdeneRiesenie = r;
                        cenaNajlepsiehoRiesenia = r.getCenuRiesenia(predmety);
                    } else {
                        int cenaNovehoRiesenia = r.getCenuRiesenia(predmety);
                        if (cenaNajlepsiehoRiesenia < cenaNovehoRiesenia) {
                            cenaNajlepsiehoRiesenia = cenaNovehoRiesenia;
                            najlepsieNajdeneRiesenie = r;
                        }
                    }
                }
            }
        } else {
            System.out.println("Nepodarilo sa vytvorit pociatocnu mnozinu, uprav parametre");
            System.exit(-5);
        }
    }

    private ArrayList<Integer> mptPostup(int m, int p, int t){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        ArrayList<Integer> Amn = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int x = 0;
        for (int i = 2; i < p; i++) {

            x = a.get(i-1) + 1;

            a.add(0);
            while (a.get(i) == 0 && x < m){
                Amn.clear();
                for (int j = 0; j < i; j++) {
                    for (int k = 0; k < j; k++) {
                        Amn.add(a.get(j) - a.get(k)%m);
                        Amn.add(a.get(k) - a.get(j)%m);
                    }
                }
                int y = 1;
                for (int j = 0; j < i; j++) {
                    int value = x-a.get(j)%m;
                    int sum = 0;
                    for (int cislo:Amn) {
                        if (cislo == value) sum++;
                    }
                    if (sum < t) {
                        y = y * 1;
                        Amn.add(value);
                    } else {
                        y = y * 0;
                    }

                    value = a.get(j)%m;
                    sum = 0;
                    for (int cislo:Amn) {
                        if (cislo == value) sum++;
                    }
                    if (sum < t){
                        y = y * 1;
                        Amn.add(value);
                    } else {
                        y = y * 0;
                    }
                }
                if (y == 1){
                    a.set(i,x);
                } else {
                    x = x + 1;
                }

            }
            if (a.get(i) == 0){
                break;
            }
        }
        Amn.sort(Integer::compareTo);

        if (a.size() <= p-1){
            return null;
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    b.add(i+a.get(j)%m);
                }
            }
        }
        return b;
    }
}
