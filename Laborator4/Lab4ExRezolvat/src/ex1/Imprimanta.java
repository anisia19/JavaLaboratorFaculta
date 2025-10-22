package ex1;

public class Imprimanta extends EchipamentElectronic {
    private int ppm;
    private int dpi;
    private int p_car;
    private ModTiparire modTiparire;
    public Imprimanta(String denumire, String nr_inv, double pret, String zona_mag, Situatie situatie,
                      int ppm, int dpi, int p_car, ModTiparire modTiparire) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }
    public int getDpi() {
        return dpi;
    }
    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public int pCar() {
        return p_car;
    }
    @Override
    public String toString() {
        return "Imprimantă [" + super.toString() +
                ", PPM: " + ppm + ", DPI: " + dpi +
                ", Pagini/Cartuș: " + p_car +
                ", Tipărire: " + modTiparire + "]";
    }

    @Override
    public String toFile() {
        return "imprimanta," + getDenumire() + "," + getNr_inv() + "," + getPret() + "," + getZona_mag() + "," +
                getSituatie() + "," + ppm + "," + dpi + "," + p_car + "," + modTiparire;
    }

}
