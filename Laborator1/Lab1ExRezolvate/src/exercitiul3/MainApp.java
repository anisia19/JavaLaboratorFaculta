package exercitiul3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.print("Citeste un nr de la tastatura: ");
        Scanner scanner = new Scanner(System.in);
        int nr = scanner.nextInt();
        if (nr <= 1) {
            System.out.println("Introdu un numar pozitiv, mai mare ca 1!");
            System.exit(-1);
        }
        int ct = 0;
        for (int i = 2; i <= nr; i ++){
            if (nr % i == 0){
                System.out.print(" " + i);
                ct ++;
            }
        }
        System.out.println("\n");
        if (ct == 1){
            System.out.println("Numarul este prim!");
        }
        scanner.close();
    }
}
