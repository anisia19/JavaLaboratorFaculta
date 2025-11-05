package exercitiul2;
/**
 * PerecheNumere este o clasa cu doua numere intregi
 * @author Anisia
 * @version 1
 */

import exemplul1.Persoana;

import java.util.stream.IntStream;

public class PerecheNumere {
    /**
     * @param nr1 este primul numar intreg
     * @param nr2 este al doilea numar intreg
     */
    private int nr1;
    private int nr2;

    /**
     * Constructorul clasei PerecheNumere
     * @param nr1
     * @param nr2
     */
    public PerecheNumere(int nr1, int nr2) {
        this.nr1 = nr1;
        this.nr2 = nr2;
    }

    public PerecheNumere() {

    }

    /**
     * Getter care da acces de citire a variabilei membre nr1 care contine primul numar intreg
     * @return primul numar
     */
    public int getNr1() {
        return nr1;
    }

    /**
     * Getter care da acces de citire a variabilei membre nr2 care contine primul numar intreg
     * @return al doilea numar
     */
    public int getNr2() {
        return nr2;
    }

    public void setNr1(int nr1) {
        this.nr1 = nr1;
    }

    public void setNr2(int nr2) {
        this.nr2 = nr2;
    }

    /**
     * Override la metoda toString a clasei Object
     */
    @Override
    public String toString() {
        return "PerecheNumere{" +
                "nr1=" + nr1 +
                ", nr2=" + nr2 +
                '}';
    }

    /**
     * Metoda verifica daca numerele sunt consecutive in sirul lui fibo
     * @return true daca numerele apartin sirului lui fibonnaci si sunt consecutive
     * @return false daca numerele nu apartin sirului lui fibonnaci si nu sunt consecutive
     */
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

    /**
     * @return cel mai mic multiplu comun dintre doua numere
     */
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


    public int sumaCifreC(int nr){
        int suma = 0;
        while (nr != 0){
            suma = suma + nr % 10;
            nr = nr /10;
        }
        return suma;
    }

    public boolean sumaCifEgalaC(int nr1, int nr2) {
        if (sumaCifreC(nr1) == sumaCifreC(nr2))
            return true;
        return false;
    }

    /**
     * Metoda valueOf() returnează constanta corespunzătoare string-ului specificat ca şi parametru de
     * intrare dacă aceasta există
     * Metoda foloseste .chars() pentru a transforma numerele in codul ascii, dupa care mapeaza fiecare caracter ascii cu valoarea numerica corespunzatoare
     * .sum() aduna valorile numerice
     * @param nr este numarul al caror cifre le facem suma
     * @return suma cifrelor unui numar
     */
    private int sumaCifre(int nr) {
        return String.valueOf(Math.abs(nr))
                .chars()
                .map(c -> c - '0')
                .sum();
    }

    /**
     * Metoda verifica daca cele doua numere au suma cifrelor egala
     * @return
     */
    public boolean sumaCifEgala() {
        return sumaCifre(nr1) == sumaCifre(nr2);
    }

    /**
     * Metoda valueOf() returnează constanta corespunzătoare string-ului specificat ca şi parametru de
     * intrare dacă aceasta există
     * Metoda foloseste .chars() pentru a transforma numerele in codul ascii, dupa care mapeaza fiecare caracter ascii cu valoarea numerica corespunzatoare
     * .filter() se foloseste pentru a filtra cifrelor pare dintr-un numar
     * @param nr este numarul intreg pentru care se executa metoda
     * @return numarul cifrelor pare dintr-un numar
     */
    private int cifrePare(int nr) {
        return (int) String.valueOf(Math.abs(nr))
                .chars()
                .map(c -> c - '0')
                .filter(d -> d % 2 == 0)
                .count();
    }

    /**
     * @return true daca numerele au acelasi numar de cifre pare
     * @return false in caz contrar
     */
    public boolean nrCifrePare() {
        return cifrePare(nr1) == cifrePare(nr2);
    }
}
