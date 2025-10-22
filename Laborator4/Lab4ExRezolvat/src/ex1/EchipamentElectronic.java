package ex1;

public abstract class EchipamentElectronic {
    private String denumire;
    private String nr_inv;
    private double pret;
    private String zona_mag;
    private Situatie situatie;
    public EchipamentElectronic(String denumire, String nr_inv, double pret, String zona_mag, Situatie situatie) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.situatie = situatie;
    }
    public Situatie getSituatie() {
        return situatie;
    }
    public void setSituatie(Situatie situatie) {
        this.situatie = situatie;
    }
    public String getDenumire() {
        return denumire;
    }

    public String getNr_inv() {
        return nr_inv;
    }

    public double getPret() {
        return pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }
    @Override
    public String toString() {
        return "Denumire: " + denumire + ", Inventar: " + nr_inv +
                ", Pret: " + pret + " RON, Zona: " + zona_mag +
                ", Situatie: " + situatie;
    }

    public abstract String toFile();
}