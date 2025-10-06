package exercitiul5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        int randomNum = (int)(Math.random() * 21);
        System.out.println(randomNum);

        if (randomNum == 0 || randomNum == 1){
            System.out.println("Numarul apartine sirului");
            System.exit(2);
        }
        int a, b, c;
        boolean gasit = false;
        a = 0;
        b = 1;
        c = a + b;
        while(c <= randomNum){
            if (c == randomNum){
               gasit = true;
               break;
            }
            a = b;
            b = c;
            c = a + b;
        }
        if (gasit){
            System.out.println("numarul apartine sirului lui Fibo");
        }
        else{
            System.out.println("Numarul nu apartine sirului lui Fibo");
        }


    }
}
