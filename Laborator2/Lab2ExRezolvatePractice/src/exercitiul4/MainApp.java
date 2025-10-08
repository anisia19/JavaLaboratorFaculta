package exercitiul4;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cate persoane citesti de la tastatura?");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n <= 0){
            System.out.println("valoarea citita trebuie sa fie mai mare ca 0");
            System.exit(-1);
        }
        Persoana[] persoane = new Persoana[n];
        for(int i = 0; i < n; i++){
            System.out.println("\nPersoana " + (i + 1) + ":");
            System.out.print("Introduceti numele: ");
            String nume = scanner.nextLine();
            while (nume.isEmpty()) {
                System.out.print("Nume invalid. Reintroduceti numele: ");
                nume = scanner.nextLine();
            }
            String cnp;
            Persoana p;
            while(true){
                System.out.print("Introduceti CNP-ul: ");
                cnp = scanner.nextLine();
                p = new Persoana(nume, cnp);
                if (p.checkCNP()){
                    break;
                }
                else{
                    System.out.println("CNP invalid, reintroduceti: ");
                }
            }
            persoane[i] = p;
        }
        for (Persoana persoana1: persoane){
            persoana1.display();
        }
        scanner.close();

    }
}
