package ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        List<Produs> produse = new ArrayList<Produs>();
        String linie;
        String date_in = "src/ex2/produse.csv";
        try {
            BufferedReader flux_in = new BufferedReader(new FileReader(date_in));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while((linie = flux_in.readLine()) != null){
                linie = linie.trim();
                if (linie.isEmpty())
                    continue;
                String[] campuri = linie.split(",");

                String denumire = campuri[0].trim();
                float pret = Float.parseFloat(campuri[1].trim());
                int cantitate = Integer.parseInt(campuri[2].trim());
                Date dataExpirarii = simpleDateFormat.parse(campuri[3].trim());

                Produs produs = new Produs(denumire, pret, cantitate, dataExpirarii);
                produse.add(produs);
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int optiune;
        do{
            System.out.println("0. iesire");
            System.out.println("1. afisare produse");
            System.out.println("2. afisare produse expirate");
            System.out.println("Alege o optiune: ");
            optiune = scanner.nextInt();
            switch(optiune){
                case 0:
                    System.out.println("cya!");
                    break;
                case 1:
                   Produs.afiseazaProduse(produse);
                    break;
                case 2:

                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        } while (optiune != 0);

        scanner.close();
    }
}
