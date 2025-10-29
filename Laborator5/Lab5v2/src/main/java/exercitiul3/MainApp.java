package exercitiul3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainApp {
    public static void scriere(List<Mobilier> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/mobilier.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Mobilier> citire() {
        try {
            File file = new File("src/main/resources/mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<Mobilier>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void afisarePlaca(Mobilier mob){
        mob.getPlaci().stream().forEach(placa -> {
            System.out.println("Descriere: " + placa.getDescriere());
            System.out.println("Size: " + placa.getLungime() + " lungime " + placa.getLatime() + " latime ");
            System.out.println("Orientare fibra: " + placa.getOrientare());
            System.out.println("nr. bucati: " + placa.getNr_bucati());
            System.out.println("Canturi: " + Arrays.toString(placa.getCanturi()));
            System.out.println();
        });
    }

    public static void afisareMobilier(List<Mobilier> mb){
        System.out.println("Rezolvare cerinta b)\nLista mobiliere:");
        mb.stream().forEach(mob -> {
            System.out.println("\nNume mobilier:" + mob.getNume());
            System.out.println("Componente mobilier: ");
            afisarePlaca(mob);
        });
    }

    public static void afisarePlacaMobilier(List<Mobilier> mb){
        System.out.println("Nume piesa mobilier caruia sa ii se afiseze placile: ");
        Scanner scanner = new Scanner(System.in);
        String numeMob = scanner.nextLine();

        Optional<Mobilier> mobilierOptional = mb.stream()
                .filter(mob -> mob.getNume().equalsIgnoreCase(numeMob))
                .findFirst();
        mobilierOptional.ifPresentOrElse(
                mob -> afisarePlaca(mob),
                () -> System.out.println("Nu exista piesa mobilier cu acest nume")
        );
    }
    public static void afisareEstimativaColi(List<Mobilier> mb) {
        System.out.println("Nume piesa mobilier caruia sa i se afiseze Nr. estimativ coli pal: ");
        Scanner scanner = new Scanner(System.in);
        String numeMob = scanner.nextLine();

        mb.stream()
                .filter(mob -> mob.getNume().equalsIgnoreCase(numeMob))
                .findFirst()
                .ifPresentOrElse(mobilier -> {
                    double suprafataTotala = mobilier.calculeazaSuprafataTotalaMM2();
                    if (suprafataTotala == 0) {
                        System.out.println("Nu sunt necesare placi");
                    } else {
                        double placiNecesareFractional = mobilier.calculeazaColiNecesare();

                        System.out.printf("Suprafara totala %.0f mm^2 %n", suprafataTotala);
                        System.out.println("nr estimativ de coli necesare: "
                                + Math.round(placiNecesareFractional)
                                + " (" + String.format("%.4f", placiNecesareFractional) + ")");
                    }
                },
                () -> System.out.println("Nu exista mobilier cu acest nume"));
    }
    public static void main(String[] args) {
        List<Mobilier> mobiliere =citire();
        //cerinta lab a)
        mobiliere.forEach(System.out::println);
        System.out.println();
        //cerinta lab b)
        afisareMobilier(mobiliere);
        //cerinta lab c)
        afisarePlacaMobilier(mobiliere);
        //cerinta lab d)
        afisareEstimativaColi(mobiliere);
    }
}
