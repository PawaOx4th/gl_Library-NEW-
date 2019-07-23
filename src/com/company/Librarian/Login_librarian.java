package com.company.Librarian;

import com.company.Book.Book;
import com.company.Controller;
import com.company.Display.librarian_display;
import com.company.Service.Libraryservice;

import java.util.InputMismatchException;

public class Login_librarian {
    private static Libraryservice libraryservice = Libraryservice.getInstance();

    public static void login_librarian() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        String[] account = librarian_display.library_login();
        for (Librarian librarian : libraryservice.getLibrarianList().getLibrarians()) {
            if (account[0].equalsIgnoreCase(librarian.getId()) && account[1].equalsIgnoreCase(librarian.getPassword())) {
                mainLibrarian();
            } else {
                System.out.println("[ There are not exist in database. ]\n");
                Controller.controller();
            }
        }
    }

    static void mainLibrarian() {
        try {
            while (true) {
                Libraryservice.getInstance();
                int ans_2 = librarian_display.librarian_main();
                switch (ans_2) {
                    case 1:
                        //************************* Add Section *************************//
                        Admin_Function.Addbook();
                        break;
                    case 2:
                        //************************* Remove Section *************************//
                        Admin_Function.removebook();
                        break;
                    case 3:
                        //************************* Search Section *************************//
                        int Searchf = librarian_display.librarian_SearchDisplay();
                        switch (Searchf) {
                            case 1:
                                Admin_Function.searchBookname();
                                break;
                            case 2:
                                Admin_Function.searchBookcode();
                                break;
                            case 3:
                                Admin_Function.searchBookcatagory();
                                break;
                        }
                        break;
                    case 4:
                        //*************************  Chang Date Return *************************//
                        Admin_Function.changDatereturn();
                        break;
                    case 5:
                        //*************************  Sort Book *************************//
                        int SortFx = librarian_display.librarian_sortDisplay();
                        switch (SortFx) {
                            case 1:
                                libraryservice.getBooks().getBooks().sort(Admin_Function.comparatorname);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : libraryservice.getBooks().getBooks()) {
                                    System.out.println(book);
                                }
                                break;
                            case 2:
                                libraryservice.getBooks().getBooks().sort(Admin_Function.comparatorcode);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : libraryservice.getBooks().getBooks()) {
                                    System.out.println(book);
                                }
                                break;
                            case 3:
                                libraryservice.getBooks().getBooks().sort(Admin_Function.comparatorCategory);  //coloections.sort('List Book),'Class'.'Comparator object'
                                for (Book book : libraryservice.getBooks().getBooks()) {
                                    System.out.println(book);
                                }
                                break;
                        }
                        break;
                    case 6:
                        //*************************  Permit  *************************//
                        Admin_Function.perMits();
                    case 7:
                        //*************************  Return  *************************//
                        Admin_Function.returnbook();
                        break;
                    case 8:
                        //*************************  Show History *************************//
                        for (int i = 0; i < libraryservice.getHistoryList().getHistories().size(); i++) {
                            System.out.println(libraryservice.getHistoryList().getHistories().get(i));
                        }
                        break;
                    case 9:
                        //************************* Terminate Section *************************//
                        Controller.controller();
                        break;
                    case 10:
                        System.out.println("Thank you");
                        System.exit(0);
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("[ There are not exist in database.\n ]");
        }
    }
}

