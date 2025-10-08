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
        return true;
    }

    public long getVarsta() {

        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        char prima = cnp.charAt(0);
        int anulComplet;
        if (prima == '1' || prima == '2') {
            anulComplet = 1900 + an;
        } else if (prima == '5' || prima == '6') {
            anulComplet = 2000 + an;
        } else {
            anulComplet = 1800 + an;
        }

        LocalDate dataNasterii = LocalDate.of(anulComplet, luna, zi);
        LocalDate azi = LocalDate.now();
        long varsta = ChronoUnit.YEARS.between(dataNasterii, azi);
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
