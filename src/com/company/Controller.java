package com.company;

import java.util.Collections;
import java.util.Scanner;

public class Controller {
    public void controller (int ans_1 ,Bookshelf books){
        if (ans_1 == 1) {
            boolean loop = true;
            Scanner want = new Scanner(System.in);
//            List<Book> books = new ArrayList<>();

            /************************* Add Component *************************/
            do {
                System.out.println("\nWhat  do you want to do");
                System.out.println("1 - Add Book\t2 - Delete Book\t3 - Search\n" +
                        "4 - ChangStatus\t\t5 - Sort\t\t6 - Permits\n7 - Accept\t\t8 - Exit");
                int ans_2 = want.nextInt();
                switch (ans_2) {

                    case 1:
                        //************************* Add Section *************************//
                        Admin_Function a = new Admin_Function();
                        a.Addbook(books.getBooks());
                        break;
                    case 2:
                        //************************* Remove Section *************************//
                        Admin_Function remove = new Admin_Function();
                        remove.removebook( books.getBooks());
                        remove.show(books.getBooks());
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
                                Admin_Function Sname = new Admin_Function();
                                Sname.searchBookname(books.getBooks());
                                break;
                            case 2 :
                                Admin_Function Scode = new Admin_Function();
                                Scode.searchBookid(books.getBooks());
                                break;
                            case 3 :
                                Admin_Function Scat = new Admin_Function();
                                Scat.searchBookcatagory( books.getBooks());
                                break;
                            case 4:
                                Admin_Function Sstatus = new Admin_Function();
                                Sstatus.searchBookstatus(books.getBooks());
                                break;
                        }

                        break;
                    case 4:
                        //*************************  Section *************************//
                        Admin_Function Chang = new Admin_Function();
                        Chang.changStatus(books.getBooks());
                        break;
                    case 5:
                        Scanner sort = new Scanner(System.in);
                        System.out.println("Please input choice for Sort book ");
                        System.out.println("1 - Sort by name\t2 - Sort by Code\t" +
                                "3 - Sort by Cattegory \t4 - Sort by Status   ");
                        int  SortFx = sort.nextInt();
                        switch (SortFx){
                            case 1 :
                                Collections.sort(books.getBooks(), Admin_Function.comparatorname);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : books.getBooks()){
                                    System.out.println(book);
                                }
                                break;
                            case 2 :
                                Collections.sort(books.getBooks(), Admin_Function.comparatorcode);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : books.getBooks()){
                                    System.out.println(book);
                                }
                                break;
                            case 3 :
                                Collections.sort(books.getBooks(), Admin_Function.comparatorCattegory);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : books.getBooks()){
                                    System.out.println(book);
                                }
                                break;
                            case 4 :
                                Collections.sort(books.getBooks(), Admin_Function.comparatorstatus);  //coloections.sort('List Book),'Class'.'Comparator object'
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
                        System.exit(0);
//                        loop = false;
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
