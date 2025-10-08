package exercitiul4;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
    void display(){
        System.out.println("Nume = " + nume + ", CNP " + cnp + ", Varsta:" + getVarsta() + " ani");
    }

    public boolean checkCNP(){
        if(cnp.length() != 13)
            return false;
        if (!cnp.matches("\\d+"))
            return false;
        char prima_cifra = cnp.charAt(0);
        if (prima_cifra != '1' && prima_cifra != '2' && prima_cifra != '5' && prima_cifra != '6')
            return false;

        int[] control = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            int cifra = Character.getNumericValue(cnp.charAt(i));
            suma += cifra * control[i];
        }
        int rest = suma % 11;
        int cifra_control = (rest == 10) ? 1 : rest;

        int ultima_cifra = Character.getNumericValue(cnp.charAt(12));

        return cifra_control == ultima_cifra;
    }

    public long getVarsta() {

        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        char prima = cnp.charAt(0);
        int anul_complet;
        if (prima == '1' || prima == '2') {
            anul_complet = 1900 + an;
        } else if (prima == '5' || prima == '6') {
            anul_complet = 2000 + an;
        } else {
            anul_complet = 1800 + an;
        }

        LocalDate data_nasterii = LocalDate.of(anul_complet, luna, zi);
        LocalDate azi = LocalDate.now();
        long varsta = ChronoUnit.YEARS.between(data_nasterii, azi);
        return varsta;
    }
    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", cnp='" + cnp + '\'' +
                ", varsta= " + getVarsta() +" ani" +
                '}';
    }
}
