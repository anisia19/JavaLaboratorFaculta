package ex2;

import java.util.Date;

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
                "denumire='" + denumireProdus + '\'' +
                ", pret=" + pretProdus +
                ", cantitate=" + cantitateProdus +
                ", dataExpirarii=" + dataExpirarii;
    }
}
