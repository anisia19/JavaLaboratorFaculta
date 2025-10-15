package ex2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Produs {
    private String denumireProdus;
    private float pretProdus;
    private int cantitateProdus;
    private Date dataExpirarii;

    public Produs(String denumireProdus, float pretProdus, int cantitateProdus, Date dataExpirarii){
        this.denumireProdus = denumireProdus;
        this.pretProdus = pretProdus;
        this.cantitateProdus = cantitateProdus;
        this.dataExpirarii = dataExpirarii;
    }
    public Produs(){}
    public String getDenumireProdus(){
        return denumireProdus;
    }

    public float getPretProdus(){
        return pretProdus;
    }

    public int getCantitateProdus(){
        return cantitateProdus;
    }

    public Date getDataExpirarii() {
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

    public void setDataExpirarii(Date dataExpirarii) {
        this.dataExpirarii = dataExpirarii;
    }

    @Override
    public String toString(){
        return "Detalii produs:" +
                "denumire : " + denumireProdus  +
                ", pret = " + pretProdus +
                ", cantitate = " + cantitateProdus +
                ", data expirarii :" + dataExpirarii;
    }
    public static void afiseazaProduse(List<Produs> listaProduse){
        if (listaProduse == null || listaProduse.isEmpty()){
            System.out.println("Nu sunt produse!");
            return;
        }
        for (Produs p: listaProduse){
            System.out.println(p);
        }
    }

  /*  public static void afisProduseExpirate(List<Produs> listaProduse){
        LocalDate dt1 =  LocalDate.now();
        LocalDate dataExpirarii;
        for (Produs p: listaProduse){
            dataExpirarii = p.getDataExpirarii().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            if(dataExpirarii.isBefore(dt1)){
                listaProduse.remove();
            }
        }
    }*/

}
