package Ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());
            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper
                    .readValue(file, new TypeReference<List<Angajat>>(){});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optiune;
        List <Angajat> angajati = citire();
        scriere(angajati);
        do{
            System.out.println("0. iesire");
            System.out.println("1.afis lista angajati");
            System.out.println("2.afis angajati salariu > 2500");
            System.out.println("3.afis crearea unei liste angajati luna aprilie, functie de conducere");
            System.out.println("4.afis angajati care nu s sefi in ordine descrescatoare a salariilor");
            System.out.println("5.afis angajati cu majuscule");
            System.out.println("6.afis salarii < 3000");
            System.out.println("7.primul angajat al firmei");
            System.out.println("8.salariu mediu, minim, maxim");
            System.out.println("9.angajat Ion");
            System.out.println("10.afisare persoane angajate in vara anului precedent");
            System.out.print("Alege o optiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune){
                case 0:
                    System.out.println("Iesire din meniu realizata cu succes!");
                    break;
                case 1:
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    angajati.stream()
                            .filter(angajat -> angajat.getSalariul() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getPost().equalsIgnoreCase("sef") || angajat.getPost().equalsIgnoreCase("director"))
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
                    angajati
                            .stream()
                            .map(angajat ->angajat.getNume().toUpperCase())
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                      break;
                case 6:
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getSalariul() <3000)
                            .map(Angajat::getSalariul)
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Angajat> primul = angajati.stream()
                            .min((a1, a2) -> a1.getData_angajarii().compareTo(a2.getData_angajarii()));
                    if (primul.isPresent()) {
                        System.out.println(primul.get());
                    } else {
                        System.out.println("Nu exista angajati in lista.");
                    }
                    break;
                case 8:
                    OptionalDouble salariuMinim = angajati.stream()
                            .mapToDouble(Angajat::getSalariul)
                            .min();
                    OptionalDouble salariuMaxim = angajati.stream()
                            .mapToDouble(Angajat::getSalariul)
                            .max();
                    OptionalDouble salariuMediu = angajati.stream()
                            .mapToDouble(Angajat::getSalariul)
                            .average();
                    System.out.println("Salariul minim este: " + salariuMinim.getAsDouble() + "\nSalariul maxim este: " + salariuMaxim.getAsDouble() +"\nSalariu mediu este: " + salariuMediu.getAsDouble());
                    break;
                case 9:
                    angajati
                            .stream()
                            .filter(angajat -> angajat.getNume().equalsIgnoreCase("Ion"))
                            .findAny()
                            .ifPresentOrElse(
                                    a -> System.out.println("Firma are cel putin un Ion angajat."),
                                    () -> System.out.println("Firma nu are nici un Ion angajat.")
                            );
                    break;
                case 10:
                    long ct = angajati
                            .stream()
                            .filter(angajat -> angajat.getData_angajarii().getYear() == 2024)
                            .filter(a -> {
                                int month = a.getData_angajarii().getMonthValue();
                                return month >= 6 && month <= 8;
                            })
                            .count();
                    System.out.println("Sunt " + ct + " angajati in timpul verii anul trecut");

                    break;
                  default:
                      System.out.println("Optiune invalida!");
            }
        }while(optiune != 0);
        scanner.close();
    }
}
