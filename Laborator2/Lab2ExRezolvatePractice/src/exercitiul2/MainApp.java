package exercitiul2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String date_in = "C:\\Users\\gheor\\Desktop\\JavaLaboratorFaculta\\Laborator2\\Lab2ExRezolvatePractice\\src\\exercitiul2\\cantec_in.txt";
        String date_out = "C:\\Users\\gheor\\Desktop\\JavaLaboratorFaculta\\Laborator2\\Lab2ExRezolvatePractice\\src\\exercitiul2\\cantec_out.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu grupul de litere: ");
        String grupLitere = scanner.nextLine();
        try (BufferedReader flux_in = new BufferedReader(new FileReader(date_in));
             BufferedWriter flux_out = new BufferedWriter(new FileWriter(date_out))) {

            String linie;
            while ((linie = flux_in.readLine()) != null) {
                Vers vers = new Vers(linie);
                int nr_cuvinte = vers.nrCuvinte();
                int nr_vocale = vers.cautaVocale();
                vers.randomNumber();
                String text_de_scris = vers.getVers() + " (" + nr_cuvinte + " cuvinte)" + " (" + nr_vocale + " vocale)";

                if (vers.addStelutza(grupLitere)){
                    text_de_scris += " *";
                }

                flux_out.write(text_de_scris);
                flux_out.newLine();
            }
            scanner.close();
            System.out.println("Fisierul cantec_out.txt a fost generat cu succes!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
