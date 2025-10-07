package exercitiul3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Citeste un string de la tastatura:");
        String s = scanner.nextLine();

        StringBuffer sb = new StringBuffer(s);

        System.out.println("Citeste pozitia de inceput: ");
        int start_index = scanner.nextInt();

        System.out.println("Citeste lungimea sirului pe care vrei sa l stergi:");
        int lungime = scanner.nextInt();

        int end = start_index + lungime;

        if (start_index >= 0 && end <= sb.length()) {
            sb.delete(start_index, end);
            System.out.println("Rezultatul dupa stergere: " + sb);
        } else {
            System.out.println("Pozitii invalide!");
        }

        scanner.nextLine();

        System.out.println("Introdu sirul pe care vrei sa il inserezi:");
        String sir_insert = scanner.nextLine();

        System.out.println("Introdu pozitia de la care vrei sa il inserezi:");
        int poz_insert = scanner.nextInt();

        if (poz_insert < 0 || poz_insert > sb.length()) {
            System.out.println("Pozitie invalida!");
            System.exit(-1);
        }

        sb.insert(poz_insert, sir_insert);
        System.out.println("Rezultatul dupa inserare: " + sb);

        scanner.close();
    }
}
