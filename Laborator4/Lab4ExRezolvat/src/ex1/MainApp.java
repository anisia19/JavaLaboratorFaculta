package ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void afisareEchipamente(List<EchipamentElectronic> electronics){
        if (electronics.isEmpty()){
            System.out.println("Lista de echipamente este vida");
        } else {
            for (EchipamentElectronic e : electronics){
                System.out.println(e);
            }
        }
    }
    public static void afisareTipEchipament(List <EchipamentElectronic> electronics, Class <?> tip){
        boolean existaEchipament = false;
        for(EchipamentElectronic e : electronics){
            if (tip.isInstance(e))
            {
                System.out.println(e);
                existaEchipament = true;
            }
        }
        if (!existaEchipament){
            System.out.println("Nu exista echipamentu de tipu: " + tip);
        }
    }

    /*
    public static void afisareImprimante(List<EchipamentElectronic> electronics){
        for (EchipamentElectronic e : electronics){
            if (e instanceof Imprimanta){
                System.out.println(e);
            }
        }
    }

    public static void afisareCopiatoare(List<EchipamentElectronic> electronics){
        for (EchipamentElectronic e : electronics){
            if (e instanceof Copiator){
                System.out.println(e);
            }
        }
    }
    public static void afisareSistemeCalcul(List<EchipamentElectronic> electronics){
        for (EchipamentElectronic e : electronics){
            if (e instanceof SistemCalcul){
                System.out.println(e);
            }
        }
    }
*/
    public static void modificareStareEchipament(List<EchipamentElectronic> electronics, String nrInventar, Situatie stareNoua) {
        boolean gasit = false;
        for (EchipamentElectronic e : electronics) {
            if (e.getNr_inv().equals(nrInventar)) {
                e.setSituatie(stareNoua);
                System.out.println("Starea echipamentului " + nrInventar + " a fost modificata: " + stareNoua);
                gasit = true;
            }
        }
        if (!gasit) {
            System.out.println("Echipamentul nu a fost gasit, nr. inventar = " + nrInventar);
        }
    }

    public static void salvareEchipamente(List<EchipamentElectronic> electronice, String fisier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fisier))) {
            for (EchipamentElectronic e : electronice) {
                String linie = e.toFile();
                writer.write(linie);
                writer.newLine();
            }
            System.out.println("Fisierul a fost actualizat cu succes.");
        } catch (IOException ex) {
            System.out.println("Eroare la scrierea fisierului: " + ex.getMessage());
        }
    }

    public static void setareScriereImprimanta(List<EchipamentElectronic> electronics, String nrInventar, ModTiparire modTiparire) {
        boolean gasit = false;

        for (EchipamentElectronic e : electronics) {
            if (e.getNr_inv().equals(nrInventar) && e instanceof Imprimanta ip) {
                gasit = true;
                ip.setModTiparire(modTiparire);
            }
        }
        if(!gasit){
            System.out.println("Nu exista");
        }
    }

    public static void printareItemsVandute(List<EchipamentElectronic> electronics){
        for (EchipamentElectronic e : electronics){
            if (e.getSituatie() == Situatie.VANDUT)
                System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<EchipamentElectronic> electronice = new ArrayList<>();
        String linie;
        String date_in = "src/ex1/electronice2.txt";
        try{
            BufferedReader flux_in = new BufferedReader(new FileReader(date_in));
            while ((linie = flux_in.readLine()) != null)
            {
                linie = linie.trim();
                if (linie.isEmpty())
                    continue;
                String[] date = linie.split(";");
                if (date.length < 6) {
                    System.err.println("linia este incompleta: " + linie);
                    continue;
                }
                String tipEchipament = date[5].trim();
                String denumire = date[0].trim();
                String nr_inv = date[1].trim();
                double pret = Double.parseDouble(date[2].trim());
                String zona_mag = date[3].trim();
                Situatie situatie = Situatie.valueOf(date[4].trim().toUpperCase());

                EchipamentElectronic echipament = null;
                switch(tipEchipament.toLowerCase()){
                    case "copiator":
                         //Format: Copiator,Denumire,NrInv,Pret,Zona,Situatie,PToner,FormatCopiere
                         if (date.length == 8){
                             int pTon = Integer.parseInt(date[6].trim());
                             FormatCopiere formatCopiere = FormatCopiere.valueOf(date[7].trim());
                             echipament = new Copiator(denumire, nr_inv, pret, zona_mag, situatie, pTon, formatCopiere);
                         }
                        break;
                    case "imprimanta":
                          //Format: Imprimanta,Denumire,NrInv,Pret,Zona,Situatie,PPM,DPI,PCar,ModTiparire
                        if (date.length == 10){
                            int ppm = Integer.parseInt(date[6].trim());
                            String dpi = date[7].trim();
                            int pCar = Integer.parseInt(date[8].trim());
                            ModTiparire modTiparire = ModTiparire.valueOf(date[9].trim().toUpperCase());
                            echipament = new Imprimanta(denumire, nr_inv, pret, zona_mag, situatie, ppm,dpi, pCar, modTiparire);
                        }
                        break;
                    case "sistem de calcul":
                         // Format: SistemCalcul,Denumire,NrInv,Pret,Zona,Situatie,TipMon,VitProc,CHDD,SistemOperare
                        if (date.length == 10){
                            String tipMon = date[6].trim();
                            double vitProc = Double.parseDouble(date[7].trim());
                            int CHDD =  Integer.parseInt(date[8].trim());
                            SistemOperare sistemOperare = SistemOperare.valueOf(date[9].trim());
                            echipament = new SistemCalcul(denumire, nr_inv, pret, zona_mag, situatie, tipMon,vitProc,CHDD, sistemOperare);
                        }
                        break;
                    default:
                        System.out.println("Tipul de echipament este necunoscut: " + tipEchipament);break;
                }
                if (echipament != null){
                    electronice.add(echipament);
                }
            }
            flux_in.close();
        }catch(IOException e){
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }
        catch(IllegalArgumentException e){
            System.out.println("Eroare la val enum" + e.getMessage());
        }

        int optiune;
        do{
            System.out.println("0. iesire");
            System.out.println("1. afisarea tuturor echipamentelor");
            System.out.println("2. afisarea imprimantelor");
            System.out.println("3. afisarea copiatoarelor");
            System.out.println("4. afisarea sistemelor de calcul");
            System.out.println("5. modificare stare in care se afla un echipament");
            System.out.println("6. setare mod de scriere imprimanta");
            System.out.println("7. setare format de copiere pt copiatoare");
            System.out.println("8. instalare sistem de operare");
            System.out.println("9. afisare echipamente vandute");
            System.out.println("10. serializare");
            System.out.println("11. deserializare");

            System.out.print("Alege o optiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune){
                case 0:
                    System.out.println("Iesire din meniu realizata cu succes!");
                    break;
                case 1:
                    afisareEchipamente(electronice);
                    break;
                case 2:
                    // afisareImprimante(electronice);
                    afisareTipEchipament(electronice, Imprimanta.class);
                    break;
                case 3:
                    // afisareCopiatoare(electronice);
                    afisareTipEchipament(electronice, Copiator.class);
                    break;
                case 4:
                    // afisareSistemeCalcul(electronice);
                    afisareTipEchipament(electronice, SistemCalcul.class);
                    break;
                case 5:
                    System.out.print("Introduceii numarul de inventar al echipamentului: ");
                    String nrInv = scanner.nextLine();

                    System.out.print("Introduceti noua stare (ACHIZITIONAT / EXPUS / VANDUT): ");
                    String stare = scanner.nextLine().trim().toUpperCase();

                    try {
                        Situatie stareNoua = Situatie.valueOf(stare);
                        modificareStareEchipament(electronice, nrInv, stareNoua);
                        //salvareEchipamente(electronice, date_in);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Stare invalida");
                    }
                    break;
                case 6:
                    System.out.print("Introduceii numarul de inventar al echipamentului: ");
                    String nrInv2 = scanner.nextLine();

                    System.out.print("Introduceti noul mod de tiparire (COLOR / ALB_NEGRU): ");
                    String modPrintare = scanner.nextLine().trim().toUpperCase();
                    try {
                        ModTiparire modTiparire = ModTiparire.valueOf(modPrintare);
                        setareScriereImprimanta(electronice, nrInv2, modTiparire);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Stare invalida");
                    }
                    break;
                case 7:
                    //idem case 6 dar pt copiatoare
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Afiseaza item vandute");
                    printareItemsVandute(electronice);
                default:
                    System.out.println("Optiune invalida!");
            }
        }while(optiune != 0);
        scanner.close();
    }
}