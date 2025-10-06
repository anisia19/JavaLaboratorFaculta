package exercitiul1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lungimea dreptunghiului este: ");
        int L = scanner.nextInt();
        if (L <= 0){
            System.out.println("Lungimea trebuie sa fie un numar pozitiv diferit de 0!");
            System.exit(-1);
        }
        System.out.print("Latimea dreptunghiului este: ");
        int l = scanner.nextInt();
        if (l <= 0){
            System.out.println("latimea trebuie sa fie un numar pozitiv diferit de 0!");
            System.exit(-1);
        }
        System.out.println("Perimetrul dreptunghiului este:" + 2*(l + L));
        System.out.println("Aria dreptungiului este: "+ (L * l));
        scanner.close();
    }
}
