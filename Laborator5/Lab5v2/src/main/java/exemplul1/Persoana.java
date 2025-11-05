package exemplul1;

/**
 * Clasa Persoana reprezinta o persoana cu nume si varsta
 * @author Anisia
 * @version 1
 * @since 2025
 */

public class Persoana {
    /**
     * @param nume e numele persoanei
     * @param varsta e varsta persoanei
     */
    private String nume;
    private int varsta;

    /**
     * @return Numele Persoanei
     */
    public String getNume() {
        return nume;
    }

    /**
     * @return Varsta persoanei
     */
    public int getVarsta() {
        return varsta;
    }

    /**
     * Constructorul default al clasei Persoana
     */
    public Persoana() {}

    /**
     * Constructorul clasei Persoana
     * @param nume numele persoanei
     * @param varsta varsta persoanei
     */
    public Persoana(String nume, int varsta) {
        super();
        this.nume = nume;
        this.varsta = varsta;
    }

    /**
     * Override metoda toString din clasa Object
     * @return
     */
    @Override
    public String toString() {
        return nume + ", " + varsta;
    }
}
