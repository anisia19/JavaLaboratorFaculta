
package ex3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu un sir de la tastatura:");
        String str1 = scanner.nextLine();

        StringBuilder sir1 = new StringBuilder(str1);
        System.out.print("Citeste pozitia de start a sub sirului ce vrei sa l stergi: ");
        int pozStart = scanner.nextInt();

        System.out.println("Citeste lungimea subsirului pe care vrei sa il stergi: ");
        int lungime = scanner.nextInt();
        int end = pozStart + lungime;
        if(pozStart <= 0 || end >= sir1.length()){
            System.exit(-1);
        }
        sir1.delete(pozStart, end);
        System.out.println("Rezultat: " + sir1);

        System.out.print("Citeste pozitia la care vrei sa introduci un sir: ");
        int poz = scanner.nextInt();
        if (poz <= 0 || poz >= sir1.length()){
            System.out.println("Pozitia nu este valida!");
            System.exit(-1);
        }
        scanner.nextLine();
        System.out.print("Citeste un alt sir: ");
        String sir2 = scanner.nextLine();
        sir1.insert(poz, sir2);
        System.out.println("Rezultatul dupa inserare " + sir2);


    scanner.close();
    }
}
