package ex2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        List<Produs> produse = new ArrayList<>();
        String linie;
        String date_in = "src/ex2/produse.csv";
        try {
            BufferedReader flux_in = new BufferedReader(new FileReader(date_in));
            while((linie = flux_in.readLine()) != null){
                linie = linie.trim();
                if (linie.isEmpty())
                    continue;
                String[] campuri = linie.split(",");

                String denumire = campuri[0].trim();
                float pret = Float.parseFloat(campuri[1].trim());
                int cantitate = Integer.parseInt(campuri[2].trim());
                LocalDate dataExpirarii = LocalDate.parse(campuri[3].trim());

                Produs produs = new Produs(denumire, pret, cantitate, dataExpirarii);
                produse.add(produs);
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Scanner scanner = new Scanner(System.in);
        int optiune;
        do{
            System.out.println("0. iesire");
            System.out.println("1. afisare produse");
            System.out.println("2. afisare produse expirate");
            System.out.println("3. vanzarea unui produs");
            System.out.println("4. afisare produse cu val minima");
            System.out.println("5. afisare produse cu o cantitate mai mica decat o cant data de la tast");
            System.out.println("Alege o optiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();
            PrintStream flux_out = new PrintStream("src/ex2/produse_cantitate.csv");
            switch(optiune){
                case 0:
                    System.out.println("cya!");
                    break;
                case 1:
                    Produs.afiseazaProduse(produse);
                    break;
                case 2:
                    System.out.println("Produsele expirate sunt: ");
                    Produs.afiseazaProduseExpirate(produse);
                    break;
                case 4:
                    System.out.println("Produsele cu val minima sunt:");
                    Produs.afiseazaPretMinim(produse);
                    break;
                case 5:
                    System.out.print("Citeste o cantitate: ");
                    int cantitate = scanner.nextInt();
                    scanner.nextLine();
                    if (cantitate < 0){
                        System.out.println("cantitatea tb sa fie un nr poz diferit de 0");
                        break;
                    }
                    for(Produs p: produse){
                        if (p.getCantitateProdus() < cantitate){
                            flux_out.println(p);
                        }
                    }

                default:
                    System.out.println("Optiune invalida!");
            }
        } while (optiune != 0);
        scanner.close();
    }

}