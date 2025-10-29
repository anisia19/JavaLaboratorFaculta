package exercitiul3;

import java.util.Arrays;

public class Placa {

    private String descriere;
    private int lungime;
    private int latime;
    private OrientareFibra orientare;
    private boolean[] canturi;
    private int nr_bucati;

    public Placa(String descriere, int lungime, int latime, OrientareFibra orientare, boolean[] canturi, int nr_bucati) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = canturi;
        this.nr_bucati = nr_bucati;
    }

    public Placa() {}
    public String getDescriere() {
        return descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public int getLatime() {
        return latime;
    }

    public OrientareFibra getOrientare() {
        return orientare;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public void setOrientare(OrientareFibra orientare) {
        this.orientare = orientare;
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public void setNr_bucati(int nr_bucati) {
        this.nr_bucati = nr_bucati;
    }
    @Override
    public String toString() {
        return "Placa{" +
                "descriere='" + descriere + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", orientare=" + orientare +
                ", canturi=" + Arrays.toString(canturi) +
                ", nr_bucati=" + nr_bucati +
                '}';
    }
}