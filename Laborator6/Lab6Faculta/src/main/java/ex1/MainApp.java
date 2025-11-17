package ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper
                    .readValue(file, new TypeReference<List<Angajat>>() {
                    });
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optiune;

        List<Angajat> angajati = new ArrayList<Angajat>();

        angajati.add(new Angajat("Ion", "sef", LocalDate.parse("2024-04-01"), 10000));
        angajati.add(new Angajat("Marcel", "director", LocalDate.parse("2024-08-08"), 30600));
        angajati.add(new Angajat("Ionela", "femeie de servici", LocalDate.parse("2012-08-03"), 2400));
        angajati.add(new Angajat("Vladimir", "contabil", LocalDate.parse("2022-04-01"), 7000));
        angajati.add(new Angajat("Dutzu", "programator", LocalDate.parse("2022-07-11"), 56000));

        scriere(angajati);
        citire();
        do {
            System.out.println("0.iesire");
            System.out.println("1. afisare lista persoane");
            System.out.println("2. afisare salariu peste 2500");
            System.out.println("3. afisare directori si sefi, luna aprilie");
            System.out.println("4. afisarea angatilor ce nu au functie de conducere, in ordinea descrescatoare a salarilor");
            System.out.println("5. numele angaj scris cu majuscule");
            System.out.println("6. afisare salarii mai mici de 3000 lei");
            System.out.println("7. afisarea datelor primului angajat la firma");
            System.out.println("8. salariu minim, mediu, maxim");
            System.out.println("9. exista Ion in firma?");
            System.out.println("10. afisare numar persoane angajate in vara anului precedent");

            System.out.println("Alege o varianta din meniu: ");
            optiune = scanner.nextInt();
            scanner.nextLine();
            switch (optiune) {
                case 0:
                    System.out.println("S-a iesit cu succes!!!");
                    break;
                case 1:
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getSalariul() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getPost().equalsIgnoreCase("sef") || angajat.getPost().equalsIgnoreCase("director"))
                            .filter(angajat -> angajat.getData_angajarii().getYear() == LocalDate.now().getYear() - 1) // alta viata
                            .filter(angajat -> angajat.getData_angajarii().getMonthValue() == 4)
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;
                case 4:
                    angajati
                            .stream()
                            .filter(angajat -> !angajat.getPost().equalsIgnoreCase("sef") && !angajat.getPost().equalsIgnoreCase("director"))
                            .sorted((a1, a2) -> Float.compare(a2.getSalariul(), a1.getSalariul()))
                            .forEach(System.out::println);
                    break;
                case 5:
                    List<String> angaticollect= angajati
                            .stream()
                            .map(angajat -> angajat.getNumele().toUpperCase())
                            .collect(Collectors.toList());
                    break;
                case 6: //mapez intai, dupa filtrez
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getSalariul() < 3000)
                            .map(Angajat::getSalariul)
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Angajat> primulAngajat = angajati
                            .stream()
                            .min((a1, a2) -> a1.getData_angajarii().compareTo(a2.getData_angajarii()));
                    if (primulAngajat.isPresent())
                        System.out.println("primu din firma este: " + primulAngajat.get());
                    else
                        System.out.println("nu sunt angajati in firma");
                    break;
                case 8:
                    OptionalDouble salariuMinim = angajati
                            .stream()
                            .mapToDouble(Angajat::getSalariul)
                            .min();
                    OptionalDouble salariuMediu = angajati
                            .stream()
                            .mapToDouble(Angajat::getSalariul)
                            .average();
                    OptionalDouble salariuMaxim = angajati
                            .stream()
                            .mapToDouble(Angajat::getSalariul)
                            .max();
                    System.out.println("Salariul minim e: " + salariuMinim.getAsDouble());

                    System.out.println("Salariul avg e: " + salariuMediu.getAsDouble());

                    System.out.println("Salariul maxim e: " + salariuMaxim.getAsDouble());
                    break;
                case 9:
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getNumele().equalsIgnoreCase("Ion"))
                            .findAny()
                            .ifPresentOrElse(
                                    angajat -> System.out.println("Firma are cel putin un Ion angajat."),
                                    () -> System.out.println("Firma nu are angajati cu numele Ion")
                            );
                    break;
                case 10:
                    long ct = angajati
                            .stream()
                            .filter(angajat -> angajat.getData_angajarii().getYear() == 2024)
                            .filter(angajat -> {
                                int luna = angajat.getData_angajarii().getMonthValue();
                                return luna >= 6 && luna <= 8;
                            })
                            .count();
                    System.out.println("Sunt " + ct + " angajati care respecta criteriile.");


                default:
                    System.out.println("Valoare invalida pentru optiune");
            }

        } while (optiune != 0);
    }
}
