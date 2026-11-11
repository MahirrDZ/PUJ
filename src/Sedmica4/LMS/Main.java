package Sedmica4.LMS;

import Sedmica4.Employee;
import Sedmica4.Intern;
import Sedmica4.Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/Sedmica4/LMS/LibraryItems.txt"))) {
            String line;

            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                String title = parts[1];
                String id = parts[2];

                boolean isAvailable = parts[3].equals("AVAILABLE");


                switch (type) {
                    case "BOOK":
                        String author = parts[4];
                        libraryItems.add(new Book(title, id,isAvailable, author));
                        break;

                    case "MAGAZINE":
                        int issueNumber = Integer.parseInt(parts[4]);
                        libraryItems.add(new Magazine(title, id,isAvailable, issueNumber));
                        break;
                    case "DVD":
                        String director = parts[4];
                        int durationinMinutes = Integer.parseInt(parts[5]);
                        libraryItems.add(new DVD(title, id,isAvailable, director, durationinMinutes));
                        break;
                    default:
                            System.out.println("Nepoznati tip knjige");
                }
            }
        } catch (IOException e) {
            System.out.println("Greska u citanju file-a"+" "+e.getMessage());
        }

        for (LibraryItem item : libraryItems) {
            if(item.getClass().equals(Book.class)){
                item.borrow();
            }

        }
        for (LibraryItem item : libraryItems) {

            item.getInfo();
        }
        saveToFile(libraryItems);
        libraryCounter(libraryItems);
        pretrazi(libraryItems);

    }



    public static void libraryCounter(ArrayList<LibraryItem> libraryItems){
        int books = 0;
        int magazines = 0;
        int dvds = 0;

        for (LibraryItem item : libraryItems) {
            if (item instanceof Book) {
                books++;

            } else if (item instanceof Magazine) {
                magazines++;

            } else {
                dvds++;
            }
        }

        System.out.println("Broj knjiga: " + books +", broj magazina: " + magazines + ", broj DVD-ova: " + dvds + "");


    }



    public static void pretrazi(ArrayList<LibraryItem> libraryItems){
        System.out.println("Po čemu zelite pretraziti");
        System.out.println("1. Pretraga po imenu");
        System.out.println("2. Pretraga po id");
        System.out.println("Unesite opciju:");
        Scanner sc = new Scanner(System.in);
        int opcija = sc.nextInt();
        switch(opcija){
            case 1:
                System.out.println("Unesite ime knjige");
                sc.nextLine();
                String ime = sc.nextLine();
                for (LibraryItem item : libraryItems) {
                    if(item.getTitle().toLowerCase().contains(ime.toLowerCase())){
                        item.getInfo();
                    }
                }
                break;

            case 2:
                System.out.println("Unesite id knjige");
                sc.nextLine();
                String id = sc.nextLine();
                for (LibraryItem item : libraryItems) {
                    if(item.getId().equals(id)){
                        item.getInfo();
                    }
                }
                break;
            default:
                System.out.println("Neispravna opcija");
                break;

        }

    }

    public static void saveToFile(ArrayList<LibraryItem> libraryItems) {
        final String fileName = "src/Sedmica4/LMS/LibraryItems.txt";
        try (FileWriter fw = new FileWriter(fileName)) {
            for (LibraryItem i : libraryItems) {
                switch(i.getClass().getSimpleName()){
                    case "Book":
                        Book b = (Book) i;
                        fw.write("BOOK"+","+b.getTitle()+","+b.getId()+","+b.getIsAvailable()+","+b.getAuthor()+"\n");
                        break;
                    case "Magazine":
                        Magazine m = (Magazine) i;
                        fw.write("MAGAZINE"+","+m.getTitle()+","+m.getId()+","+m.getIsAvailable()+","+m.getIssueNumber()+"\n");
                        break;
                    case "DVD":
                        DVD d = (DVD) i;
                        fw.write("DVD"+","+d.getTitle()+","+d.getId()+","+d.getIsAvailable()+","+d.getDirector()+","+d.getDurationinMinutes()+"\n");
                        break;
                    default:
                        System.out.println("Nepoznata klasa: "+i.getClass().getSimpleName());
                }
            }
        } catch (IOException e) {
            System.out.println("Greska u pisanju file-a " + e.getMessage());
        }

    }


}




