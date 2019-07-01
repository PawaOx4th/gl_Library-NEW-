package com.company;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Iterator;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;
import java.time.LocalDate;

public class Main {

    public static Object Book;

    public static void main(String[] args) {

        //************************* Time Test *************************//



        //************************* Login Section *************************//
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1 - Administrator");
        System.out.println("2 - Employee");
        int ans_1 = pos.nextInt();
        LocalDate date = LocalDate.now();
        Bookshelf books = new Bookshelf();
        Bookex bex = new Bookex();
        bex.setbooxEx(books.getBooks());

        //************************* Administrator Section *************************//

        if (ans_1 == 1) {
            boolean loop = true;
            Scanner want = new Scanner(System.in);
//            List<Book> books = new ArrayList<>();

            /************************* Add Component *************************/
            do {
                System.out.println("\nWhat  do you want to do");
                System.out.println("1 - Add Book\t2 - Delete Book\t3 - Search\n" +
                        "4 - ChangStatus\t\t5 - Sort\t\t6 - Approve\n7 - Accept\t\t8 - Exit");
                int ans_2 = want.nextInt();
                switch (ans_2) {
                    //************************* Add Section *************************//
                    case 1:
                        Add a = new Add();
                        a.Addbook(books.getBooks());
                        break;
                    case 2:
                        //************************* Remove Section *************************//
                        Remove d = new Remove();
                        Scanner dc = new Scanner(System.in);
                        System.out.println("\nPlease insert Book code to delete : ");
                        String id = dc.nextLine();
                        d.removebook(id, books.getBooks());
                        d.show(books.getBooks());
                        break;
                    case 3:
                        //************************* Search Section *************************//
                        System.out.println("Please Select Search :");
                        System.out.println("1 - Search by name\t2 - Search by Code\t" +
                                "3 - Search by Cattegory \t4 - Search by Status   ");
                        Scanner sh = new Scanner(System.in);
                        int Searchf = sh.nextInt();
                        switch (Searchf){
                            case 1 :
                                Scanner n = new Scanner(System.in);
                                System.out.println("Please enter book name : ");
                                String nameS = n.nextLine();
                                Search Sname = new Search();
                                Sname.searchBookname(nameS, books.getBooks());
                                break;
                            case 2 :
                                Scanner n2 = new Scanner(System.in);
                                System.out.println("Please enter book code : ");
                                String codeS = n2.nextLine();
                                Search Scode = new Search();
                                Scode.searchBookid(codeS, books.getBooks());
                                break;
                            case 3 :
                                Scanner n3 = new Scanner(System.in);
                                System.out.println("Please enter book Cattegory : ");
                                String N3 = n3.nextLine();
                                Bookcategory cattegoryS = Bookcategory.valueOf(N3);
                                Search Scat = new Search();
                                Scat.searchBookcatagory(cattegoryS, books.getBooks());
                                break;
                            case 4:
                                Scanner n4 = new Scanner(System.in);
                                System.out.println("Please enter book Status : ");
                                String N4 = n4.nextLine();
                                Bookstatus bookstatus = Bookstatus.valueOf(N4);
                                Search Sstatus = new Search();
                                Sstatus.searchBookstatus(bookstatus, books.getBooks());
                                break;
                        }

                        break;
                    case 4:
                        //************************* Status Section *************************//
                        Scanner ch = new Scanner(System.in);
                        System.out.println("Please input Book code to Chang Status");
                        String id3 = ch.nextLine();
                        ChangStatus Chang = new ChangStatus();
                        Chang.changStatus(id3,books.getBooks());
                        break;
                    case 5:
                        Scanner sort = new Scanner(System.in);
                        System.out.println("Please input choice for Sort book ");
                        System.out.println("1 - Sort by name\t2 - Sort by Code\t" +
                                "3 - Sort by Cattegory \t4 - Sort by Status   ");
                        int  SortFx = sort.nextInt();
                        switch (SortFx){
                            case 1 :
                                Collections.sort(books.getBooks(), Sort.comparatorname);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : books.getBooks()){
                                    System.out.println(book);
                                }
                                break;
                            case 2 :
                                Collections.sort(books.getBooks(), Sort.comparatorcode);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : books.getBooks()){
                                    System.out.println(book);
                                }
                                break;
                            case 3 :
                                Collections.sort(books.getBooks(), Sort.comparatorCattegory);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : books.getBooks()){
                                    System.out.println(book);
                                }
                                break;
                            case 4 :
                                Collections.sort(books.getBooks(), Sort.comparatorstatus);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : books.getBooks()){
                                    System.out.println(book);
                                }
                                break;
                        }
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        //************************* Terminate Section *************************//
                        System.out.println("Thank you");
                        loop = false;
                }
            }
            while (loop);
        } else {
            if (ans_1 == 2) {
                //************************* Employee Section *************************//
                // List<Book> books = new ArrayList<>();
                boolean loop = true;
                Scanner want = new Scanner(System.in);
                //************************* Add Component *************************//

                do {
                    System.out.println("\nWhat  do you want to do");
                    System.out.println("1 - Search\n2 - Check\n3 - Rental\n4 - Return\n5-Exit");
                    int ans_2 = want.nextInt();
                    switch (ans_2) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;

                        default:
                            loop = false;
                    }
                } while (loop);
            } else {
                System.out.println("Sorry please connect again later");
            }
        }
    }
}



