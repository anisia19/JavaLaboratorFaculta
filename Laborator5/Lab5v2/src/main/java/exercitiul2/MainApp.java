package exercitiul2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/perechi.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            File file = new File("src/main/resources/perechi.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(5, 8));
        lista.add(new PerecheNumere(10, 20));
        lista.add(new PerecheNumere(246, 864));

        scriere(lista);

        List<PerecheNumere> listaCitita = citire();

        if (listaCitita != null) {
            System.out.println("Lista citita din fisier:");
            for (PerecheNumere p : listaCitita) {
                System.out.println(p);
                System.out.println("Suma cifrelor egale: " + p.sumaCifEgala());
                System.out.println("Numar cifre pare egale: " + p.nrCifrePare());
                System.out.println("Apartin Fibo: " + p.suntConsecutiveFibonnaci());
                System.out.println("CMMMC: "+p.celMaiMicMultipluComun());
                System.out.println();
            }
        }
    }
}
