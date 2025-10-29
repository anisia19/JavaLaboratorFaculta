package exercitiul3;

import java.util.List;

public class Mobilier {
    public static final double SUPRAFATA_COALA_MM2 = 2800.0 * 2070.0;
    private String nume;
    private List<Placa> placi;

    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }
    public Mobilier() {}

    public String getNume() {
        return nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
    public double calculeazaSuprafataTotalaMM2() {
        return this.placi.stream()
                .mapToDouble(placa -> placa.getLungime() * placa.getLatime() * placa.getNr_bucati())
                .sum();
    }
    public double calculeazaColiNecesare() {
        double suprafataTotalaMM2 = calculeazaSuprafataTotalaMM2();
        if (suprafataTotalaMM2 == 0) {
            System.out.println("0 placi necesare");
            return 0;
        }
        return suprafataTotalaMM2 / SUPRAFATA_COALA_MM2;
    }
}
