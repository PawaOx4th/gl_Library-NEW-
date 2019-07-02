package com.company;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Admin_Function {

    public static  void printOut(Book book){

        System.out.println("==========================");
        System.out.println("Book Name   : " + book.getBookname());
        System.out.println("Book Type   : " + book.getBookcategory());
        System.out.println("Book Code   : " + book.getBookcode());
        System.out.println("Book Bookstatus :" + book.getBookstatus());
        System.out.println("Book Date Bollow : " + book.getBollow());
        System.out.println("Book Date Return : " + book.getReturns());
        System.out.println("==========================");
    }

    //========================== ADD BOOK ==========================//
    public static void Addbook(Bookshelf books) {
        System.out.println("=====================");
        Book book_add = new Book();
        Scanner sb1 = new Scanner(System.in);
        System.out.print("Please enter book name : ");
        String bName = sb1.nextLine();
        System.out.println("Book name : " + bName);
        Scanner sb2 = new Scanner(System.in);
        System.out.print("Please enter book code : ");
        String bCode = sb1.nextLine();
        System.out.println("Book name : " + bCode);
        Scanner sb4 = new Scanner(System.in);
        System.out.print("Please enter book category : ");
        String bCat = sb1.nextLine();
        Bookcategory category = Bookcategory.valueOf(bCat);
        System.out.println("Book name : " + bCat);

        book_add.setBookname(bName);
        book_add.setBookcode(bCode);
        book_add.setBookcategory(Bookcategory.valueOf(bCat));
        book_add.setBookstatus(Bookstatus.BLANK);

        books.getBooks().add(book_add);

        for (int i = 0; i < books.getBooks().size(); i++) {
            System.out.println(books.getBooks().get(i));
        }
        System.out.println("=====================");
    }

    //========================== Remove BOOK ==========================//
    public static void removebook(List<Book> books) {

        Scanner dc = new Scanner(System.in);
        System.out.println("\nPlease insert Book code to delete : ");
        String id = dc.nextLine();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookcode().equals(id)) {
                iterator.remove();
                System.out.println("Book code : [" + book.getBookcode() + "] has been delete.");
            } else if (book.getBookcode().equalsIgnoreCase(id)) {
                System.out.println("Sorry your book code is not exist");
            }

        }
    }

    public static void show(List<Book> books) {
        System.out.println("=====================");
        System.out.println("this is book in list : ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        System.out.println("=====================");
    }

    //************************* Search Book *************************//
    public static void searchBookname(Bookshelf books) {
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

    public static void searchBookid(Bookshelf books) {
        Scanner n2 = new Scanner(System.in);
        System.out.println("Please enter book code : ");
        String codeS = n2.nextLine();
        boolean isState = false;
        for (Book book : books.getBooks()) {
            if (book.getBookcode().equalsIgnoreCase(codeS)) {
                isState = true;
                if (book.getBookname().equalsIgnoreCase(codeS)) {
                    printOut(book);
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

    public static void searchBookcatagory(Bookshelf books) {
        Scanner n3 = new Scanner(System.in);
        System.out.println("Please enter book Cattegory : ");
        String N3 = n3.nextLine();
        Bookcategory cattegoryS = Bookcategory.valueOf(N3);
        for (Book book : books.getBooks()) {
            if (book.getBookcategory().equals(cattegoryS)) {

                printOut(book);


            } else if (book.getBookcategory().equals(cattegoryS)) {
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }

    public static void searchBookstatus(Bookshelf books) {
        Scanner n4 = new Scanner(System.in);
        System.out.println("Please enter book Status : ");
        String N4 = n4.nextLine();
        Bookstatus bookstatus = Bookstatus.valueOf(N4);
        for (Book book : books.getBooks()) {
            if (book.getBookstatus().equals(bookstatus)) printOut(book);
            else if (book.getBookstatus().equals(bookstatus)) {
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }

    //=================================== SORT BOOK ============================================//
    //************************* Sort by name  *************************//
    public static Comparator<Book> comparatorname = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookname().toUpperCase();
            String BookN2 = o2.getBookname().toUpperCase();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************  Sort by Code *************************//
    public static Comparator<Book> comparatorcode = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookcode().toUpperCase();
            String BookN2 = o2.getBookcode().toUpperCase();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************   *************************//
    public static Comparator<Book> comparatorCattegory = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookcategory().toString();
            String BookN2 = o2.getBookcategory().toString();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************  Sort by Status *************************//
    public static Comparator<Book> comparatorstatus = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookstatus().toString();
            String BookN2 = o2.getBookstatus().toString();
            return BookN1.compareTo(BookN2);
        }
    };


    //=================================== CHANG STATE BOOK ============================================//
    public static void changStatus(Bookshelf books) {
        Scanner ch = new Scanner(System.in);
        System.out.println("Please input Book code to Chang Status");
        String id = ch.nextLine();
        for (Book book : books.getBooks()) {
            if (book.getBookcode().equals(id)) {
                Bookstatus chang = Bookstatus.valueOf("BUSY");
                book.setBookstatus(chang);
                System.out.println("BookStatus :" + book.getBookstatus());
            }
        }
    }



    //=================================== Permits STATE BOOK ============================================//
    public static void permits(List<Book> books) {
        Scanner n = new Scanner(System.in);
        System.out.println("========Bollow Book=========");
        System.out.println("Please enter code name : ");
        String nameS = n.nextLine();
        System.out.println("============================");
        Iterator<Book> iterator = books.iterator();
        boolean isFound = false;
        while (iterator.hasNext()) {
            Controller controller = new Controller();
            Book book = iterator.next();
            if (book.getBookcode().equalsIgnoreCase(nameS)) {
                isFound = true;
                if ((book.getBookstatus().equals(Bookstatus.BLANK))) {
                    book.setBollow(LocalDate.now());
                    book.setBookstatus(Bookstatus.BUSY);
                    printOut(book);
                } else {
                    System.out.println("Book is not" + book.getBookstatus());
                }
            } else {
            }
        }
        if (!isFound){
            System.out.println("Please Again Enter Book Code");
        }
    }


    //=================================== Return STATE BOOK ============================================//
    public static void returnbook(List<Book>books){
        Scanner n = new Scanner(System.in);
        System.out.println("========Return Book=========");
        System.out.println("Please enter code name : ");
        String nameS = n.nextLine();
        System.out.println("============================");
        Iterator<Book> iterator = books.iterator();
        boolean returnb = false;
        while (iterator.hasNext()) {
            Controller controller = new Controller();
            Book book = iterator.next();
            if (book.getBookcode().equalsIgnoreCase(nameS)) {
                returnb = true;
                if ((book.getBookstatus().equals(Bookstatus.BUSY))) {
                    book.setReturns(LocalDate.now());
                    book.setBookstatus(Bookstatus.BLANK);
                    printOut(book);
                } else {
                    System.out.println("Book is not" + book.getBookstatus());
                }
            } else {}
        }
        if (!returnb){ System.out.println("Please Again Enter Book Code");}
    }
}

