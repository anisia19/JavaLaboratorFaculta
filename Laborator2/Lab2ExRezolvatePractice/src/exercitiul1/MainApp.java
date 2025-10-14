package exercitiul1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String[] judete = null;
        String date_in = "C:\\Users\\gheor\\Desktop\\JavaLaboratorFaculta\\Laborator2\\Lab2ExRezolvatePractice\\src\\exercitiul1\\judete_in.txt";
        try {
            BufferedReader flux_in = new BufferedReader(new FileReader(date_in));
            StringBuilder continut = new StringBuilder();
            String linie;
            while((linie = flux_in.readLine()) != null){
                continut.append(linie);
            }
            judete = continut.toString().split(",");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        for (int i = 0; i < judete.length; i++) {
            judete[i] = judete[i].trim();
        }
        Arrays.sort(judete);
        System.out.println("Ordonarea alfabetica a judetelor este: ");
        for(int i = 0; i < judete.length; i++){
            System.out.println(" " + judete[i]);
        }
        System.out.print("Introdu un judet pentru a afla pozitia lui: ");
        Scanner scanner = new Scanner(System.in);
        String judet_citit = scanner.nextLine();
        scanner.nextLine();
        scanner.close();
        int poz = Arrays.binarySearch(judete, judet_citit);
        System.out.println(poz >= 0?"Gasit pe pozitia " + poz:"Nu se gaseste!");
    }
}

