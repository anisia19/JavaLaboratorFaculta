package ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String[] judete = new String[0];
        String dateIn = "src/ex1/judete_in.txt";
        try{
            BufferedReader fluxIn = new BufferedReader(new FileReader(dateIn));
            StringBuilder continut = new StringBuilder();
            String linie;
            while ((linie=fluxIn.readLine()) != null){
                continut.append(linie);
            }
            judete = continut.toString().split(",");
        }catch(IOException e){
            System.exit(-1);
            e.printStackTrace();
        }
        for(int i = 0; i < judete.length; i++){
            judete[i] = judete[i].trim();
        }
        Arrays.sort(judete);
        System.out.println("judetele sortate sunt:");
        for(int i = 0; i < judete.length; i++){
            System.out.println(judete[i]);
        }

        System.out.print("Introdu un judet de la atstatura pentru a afla pozitia lui:");
        Scanner scanner = new Scanner(System.in);
        String judetInput = scanner.nextLine();
        if (judetInput.length() <= 0 || judetInput.isEmpty()){
            System.out.println("Nu ai introdus un judet valid!");
            System.exit(-1);
        }
        int poz = Arrays.binarySearch(judete, judetInput );
        System.out.println(poz >= 0?"Gasit pe pozitia " + poz: "Nu se gaseste!");
        scanner.close();
    }
}
