package ex2;

import java.time.LocalDate;
import java.util.List;

public class Produs {
    private String denumireProdus;
    private float pretProdus;
    private int cantitateProdus;
    private LocalDate dataExpirarii;
    public static int incasari;


    public Produs(String denumireProdus, float pretProdus, int cantitateProdus, LocalDate dataExpirarii) {
        this.denumireProdus = denumireProdus;
        this.pretProdus = pretProdus;
        this.cantitateProdus = cantitateProdus;
        this.dataExpirarii = dataExpirarii;
    }

    public Produs() {
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public float getPretProdus() {
        return pretProdus;
    }

    public int getCantitateProdus() {
        return cantitateProdus;
    }

    public LocalDate getDataExpirarii() {
        return dataExpirarii;
    }

    public void setDenumireProdus(String denumireProdus) {
        this.denumireProdus = denumireProdus;
    }

    public void setPretProdus(float pretProdus) {
        this.pretProdus = pretProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }

    public void setDataExpirarii(LocalDate dataExpirarii) {
        this.dataExpirarii = dataExpirarii;
    }

    @Override
    public String toString() {
        return "Detalii produs:" +
                "denumire : " + denumireProdus +
                ", pret = " + pretProdus +
                ", cantitate = " + cantitateProdus +
                ", data expirarii :" + dataExpirarii;
    }

    public static void afiseazaProduse(List<Produs> listaProduse) {
        if (listaProduse == null || listaProduse.isEmpty()) {
            System.out.println("Nu sunt produse!");
            return;
        }
        for (Produs p : listaProduse) {
            System.out.println(p);
        }
    }
    public static void afiseazaProduseExpirate(List<Produs> produse){
        for(Produs p : produse){
            LocalDate dataExpirarii =  p.getDataExpirarii();
            if (dataExpirarii.isBefore(LocalDate.now())){
                System.out.println(p);
            }
        }
    }
    public static void afiseazaPretMinim(List<Produs> produse) {
        float valMinima = Integer.MAX_VALUE;
        for (Produs p : produse) {
            if (p.pretProdus < valMinima) {
                valMinima = p.pretProdus;
            }
        }

        System.out.println("Val minima e :" +valMinima);
        for (Produs p1 : produse) {
            if (p1.pretProdus == valMinima) {
                System.out.println(p1);
            }
        }
    }
}

