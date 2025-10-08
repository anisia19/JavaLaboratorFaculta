package ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {
        String date_in = "src/ex2/cantec_in.txt";
        String date_out = "src/ex2/cantec_out.txt";
        try (BufferedReader flux_in = new BufferedReader(new FileReader(date_in));
             BufferedWriter flux_out = new BufferedWriter(new FileWriter(date_out))) {

            String linie;
            while ((linie = flux_in.readLine()) != null) {
                Vers vers = new Vers(linie);
                int nr_cuvinte = vers.nrCuvinte();
                int nr_vocale = vers.cautaVocale();
                vers.randomNumber();
                String text_de_scris = vers.getVers() + " (" + nr_cuvinte + " cuvinte)" + " (" + nr_vocale + " vocale)";
                if (vers.addStelutza()){
                    text_de_scris += " *";
                }

                flux_out.write(text_de_scris);
                flux_out.newLine();
            }

            System.out.println("Fisierul cantec_out.txt a fost generat cu succes!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}