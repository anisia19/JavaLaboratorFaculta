package ex1;

public class SistemCalcul extends EchipamentElectronic {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare so;
    public SistemCalcul(String denumire, String nr_inv, double pret, String zona_mag, Situatie situatie,
                        String tip_mon, double vit_proc, int c_hdd, SistemOperare so) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.so = so;
    }
    public void setSo(SistemOperare so) {
        this.so = so;
    }

    @Override
    public String toString() {
        return "Sistem de Calcul [" + super.toString() +
                ", Monitor: " + tip_mon + ", Viteza Procesor: " + vit_proc +
                ", HDD: " + c_hdd + ", SO: " + so + "]";
    }

    @Override
    public String toFile() {
        return getDenumire() + ";" + getNr_inv() + ";" + getPret() + ";" + getZona_mag() + ";" +
                getSituatie() + ";" + "sistem_calcul" + ";" + tip_mon + ";" + vit_proc + ";" + c_hdd + ";" + so;
    }
}
