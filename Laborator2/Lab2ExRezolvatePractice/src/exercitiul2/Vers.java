package exercitiul2;

import java.util.Arrays;

public class Vers {
    private String vers;
    public Vers(String vers) {
        this.vers = vers;
    }
    public Vers() {
    }
    public String getVers() {
        return vers;
    }
    public void setVers(String vers){
        this.vers = vers;
    }

    public int nrCuvinte() {
        if (vers == null || vers.trim().isEmpty()) {
            return 0;
        }
        String[] cuvinte = vers.trim().split("\\s+");
        return cuvinte.length;
    }

    public int cautaVocale(){
        String vocale = "aeiouAEIOU";
        int nr_vocale = 0;
        for (char c : vers.toCharArray()){
            if(vocale.indexOf(c) != -1){
                nr_vocale++;
            }
        }
        return nr_vocale;
    }
    public boolean addStelutza(String grup){
       if(vers.endsWith(grup))
                return true;
        return false;
    }
    public void randomNumber(){
        double randomNum = Math.random();
        if (randomNum < 0.5) {
            vers = vers.toUpperCase();
        }
    }
}

