package exercitiul2;

import exemplul1.Persoana;

import java.util.stream.IntStream;

public class PerecheNumere {
    private int nr1;
    private int nr2;

    public PerecheNumere(int nr1, int nr2) {
        this.nr1 = nr1;
        this.nr2 = nr2;
    }

    public PerecheNumere() {

    }

    public int getNr1() {
        return nr1;
    }

    public int getNr2() {
        return nr2;
    }

    public void setNr1(int nr1) {
        this.nr1 = nr1;
    }

    public void setNr2(int nr2) {
        this.nr2 = nr2;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "nr1=" + nr1 +
                ", nr2=" + nr2 +
                '}';
    }
    public boolean suntConsecutiveFibonnaci(){
        int a = 0;
        int b = 1;
        while (b <= Math.max(nr1, nr2)){
            if((a == nr1 && b == nr2) || (a == nr2 && b == nr1)){
                return true;
            }
            int c = a + b;
            a = b;
            b = c;
        }
        return false;
    }

    public int celMaiMicMultipluComun(){
        if(nr1 == 0 || nr2 == 0)
            return 0;
        return Math.abs(nr1 * nr2) / cmmdc(nr1, nr2);
    }
    private int cmmdc(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //cod C style :))
   /* public int sumaCifre(int nr){
        int suma = 0;
        while (nr != 0){
            suma = suma + nr % 10;
            nr = nr /10;
        }
        return suma;
    }

    public boolean sumaCifEgala(int nr1, int nr2){
      if (sumaCifre(nr1) == sumaCifre(nr2))
          return true;
      return false;
    }*/

    private int sumaCifre(int nr) {
        return String.valueOf(Math.abs(nr))
                .chars()
                .map(c -> c - '0')
                .sum();
    }

    public boolean sumaCifEgala() {
        return sumaCifre(nr1) == sumaCifre(nr2);
    }

    private int cifrePare(int nr) {
        return (int) String.valueOf(Math.abs(nr))
                .chars()
                .map(c -> c - '0')
                .filter(d -> d % 2 == 0)
                .count();
    }

    public boolean nrCifrePare() {
        return cifrePare(nr1) == cifrePare(nr2);
    }


}
