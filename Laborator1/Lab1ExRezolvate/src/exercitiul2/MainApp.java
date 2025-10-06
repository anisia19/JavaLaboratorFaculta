package exercitiul2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {
        String nume_fis = "C:\\Users\\gheor\\Desktop\\JavaLaboratorFaculta\\Laborator1\\Lab1ExRezolvate\\src\\exercitiul2\\in.txt";
        int suma = 0, ma = 0, ct = 0, nr;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        try {
            BufferedReader flux_in = new BufferedReader(new FileReader(nume_fis));
            String linie;
            while ((linie=flux_in.readLine()) != null){
                System.out.println(linie);
                nr = Integer.parseInt(linie);
                suma = suma + nr;
                ct ++;
                if (nr < min){
                    min = nr;
                }
                if (nr > max){
                    max = nr;
                }
            }
            flux_in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ma = suma / ct;
        System.out.println("Suma este: " + suma);
        System.out.println("Ma este: " + ma);
        System.out.println("Min este: " + min);
        System.out.println("Max este: " + max);
    }
}
