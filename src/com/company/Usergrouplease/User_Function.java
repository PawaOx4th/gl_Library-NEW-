package com.company.Usergrouplease;

import com.company.Bbook.Book;
import com.company.Controller;
import com.company.Enum;
import com.company.Usergrouplease.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

public class User_Function {

    public static  void printOut(Book book){
        System.out.println("===================================================================================================================================================");
        System.out.print("  Book Name:" +"["+ book.getBookname()+"]"+"| ");
        System.out.print("Book Type:" +"["+ book.getBookcategory()+"]"+"| ");
        System.out.print("Book Code:" +"["+ book.getBookcode()+"]"+"| ");
        System.out.print("Book Bookstatus:" +"["+ book.getBookstatus()+"]"+"| ");
        System.out.print("Book Date Bollow:"+"[" + book.getBollow()+"]"+"| ");
        System.out.println("Book Date Return:"+"[" + book.getReturns()+"]"+"| ");
        System.out.print("===================================================================================================================================================");
    }
    //************************* Search Book *************************//
    public static void searchBookname(Controller.Bookshelf books) {
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter book name : ");
        String nameS = n.nextLine();
        boolean isState = false;
        for (Book book : books.getBooks()) {
            if (book.getBookname().equalsIgnoreCase(nameS)) {
                isState = true;
                if (book.getBookname().equalsIgnoreCase(nameS)) {
                    printOut(book);
                } else {
                    System.out.println("'Sorry your book is not exist to my Grouplease Library");
                }
            }
        }
        if(!isState){System.out.println("Please Again Enter Book Code");}
    }

    public static void searchBookid(Controller.Bookshelf books) {
        Scanner n2 = new Scanner(System.in);
        System.out.println("Please enter book code : ");
        String codeS = n2.nextLine();
        boolean isState = false;
        for (Book book : books.getBooks()) {
            if (book.getBookcode().equalsIgnoreCase(codeS)) {
                isState = true;
                if (book.getBookcode().equalsIgnoreCase(codeS)) {
                    printOut(book);
                } else {
                    System.out.println("Sorry your book is not exist to my Grouplease Library");
                }
            } else {
            }
        }
        if (!isState) {
            System.out.println("Please Again Enter Book Code");
        }
    }

    public static void searchBookcatagory(Controller.Bookshelf books) {
        Scanner n3 = new Scanner(System.in);
        System.out.println("Please enter book Cattegory : ");
        String N3 = n3.nextLine();
        Enum.Bookcategory cattegoryS = Enum.Bookcategory.valueOf(N3);
        for (Book book : books.getBooks()) {
            if (book.getBookcategory().equals(cattegoryS)) {

                printOut(book);


            } else if (book.getBookcategory().equals(cattegoryS)) {
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }

    public static void searchBookstatus(Controller.Bookshelf books) {
        Scanner n4 = new Scanner(System.in);
        System.out.println("Please enter book Status : ");
        String N4 = n4.nextLine();
        Enum.Bookstatus bookstatus = Enum.Bookstatus.valueOf(N4);
        for (Book book : books.getBooks()) {
            if (book.getBookstatus().equals(bookstatus)) printOut(book);
            else if (book.getBookstatus().equals(bookstatus)) {
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }

    /*/
    ============================================== Rental ==============================================
     */
    public static void rentalbook(Controller.Bookshelf book, User user){
        LocalDate date = LocalDate.now();
        Scanner inputrentalCode = new Scanner(System.in);
        System.out.print("Book Code: ");
        String code = inputrentalCode.nextLine();
        boolean isState = false;
        for (Book book1 : book.getBooks()) {
            if (book1.getBookcode().equalsIgnoreCase(code)) {
                isState = true;
                if (book1.getBookcode().equalsIgnoreCase(code)) {
                    book1.setBookstatus(Enum.Bookstatus.Not_Confirmed);
                    printOut(book1);

                } else {
                    System.out.println("'Sorry your book is not exist to my Grouplease Library");
                }
            } else {
            }
        }
        if (!isState) {
            System.out.println("Please Again Enter Book Code");
        }
    }
    //=================================== Return STATE BOOK ============================================//
    public static void returnbook(Controller.Bookshelf books){
        Scanner n = new Scanner(System.in);
        System.out.println("========Return Book=========");
        System.out.println("Please enter code name : ");
        String nameS = n.nextLine();
        System.out.println("============================");
        Iterator<Book> iterator = books.getBooks().iterator();
        boolean returnb = false;
        while (iterator.hasNext()) {
            Controller controller = new Controller();
            Book book = iterator.next();
            if (book.getBookcode().equalsIgnoreCase(nameS)) {
                returnb = true;
                if ((book.getBookstatus().equals(Enum.Bookstatus.BLANK))) {
                    book.setBookstatus(Enum.Bookstatus.Not_Confirmed);
                    book.setBollow(LocalDate.now().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
//                    book.setReturns(LocalDate.now().plusDays(7));
                    printOut(book);
                } else {
                    System.out.println("Book is not" + book.getBookstatus());
                }
            } else {}
        }
        if (!returnb){ System.out.println("Please Again Enter Book Code");}
    }
}

