package ex1;

public class Copiator extends EchipamentElectronic{
    private int p_ton;
    private FormatCopiere formatCopiere;
    public Copiator(String denumire, String nr_inv, double pret, String zona_mag, Situatie situatie,
                    int p_ton, FormatCopiere formatCopiere) {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.p_ton = p_ton;
        this.formatCopiere = formatCopiere;
    }
    public FormatCopiere getFormatCopiere() {
        return formatCopiere;
    }
    @Override
    public String toString() {
        return "Copiator [" + super.toString() +
                ", Pagini/Toner: " + p_ton +
                ", Format: " + formatCopiere + "]";
    }
}
