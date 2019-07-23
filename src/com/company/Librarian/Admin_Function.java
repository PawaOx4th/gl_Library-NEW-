package com.company.Librarian;

import com.company.Book.Book;
import com.company.Enum;
import com.company.History.History;
import com.company.Service.Libraryservice;
import com.company.Users.User;
import com.company.Users.User_main;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;


public class Admin_Function {


    public static void printOut(Book book) {
        System.out.println("====================================================================================================================================================");
//        System.out.println(" UUID: "+"["+book.getU);
        System.out.print("  Book Name: " + "[" + book.getBookname() + "]" + "| ");
        System.out.print("Book Type: " + "[" + book.getBookcategory() + "]" + "| ");
        System.out.print("Book Code:" + "[" + book.getBookcode() + "]" + "| ");
        System.out.print("Book Bookstatus: " + "[" + book.getBookstatus() + "]" + "| ");
        System.out.print("Book Date Bollow: " + "[" + book.getBollow() + "]" + "| ");
        System.out.println("Book Date Return:" + "[" + book.getReturns() + "]" + "| ");
        System.out.println("====================================================================================================================================================");

    }
    public static void showHistory() {
        //*************************  Show History *************************//
        Libraryservice libraryservice = Libraryservice.getInstance();
        for (int i = 0; i < libraryservice.getHistoryList().getHistories().size(); i++) {
            System.out.println(libraryservice.getHistoryList().getHistories().get(i));
        }
    } //

    //========================== ADD BOOK ==========================//
    public static void Addbook() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        System.out.println("=====================");
        Book book_add = new Book();
        Scanner sb1 = new Scanner(System.in);
        System.out.print("Please enter book name : ");
        String bName = sb1.nextLine();
        System.out.println("Book name : " + bName);
        Scanner sb2 = new Scanner(System.in);
        Scanner sb4 = new Scanner(System.in);
        System.out.print("Please enter book category : ");
        String bCat = sb1.nextLine();
        Enum.Bookcategory category = Enum.Bookcategory.valueOf(bCat);
        System.out.println("Book name : " + bCat);
        //--------------------- Generate bookcode --------------------//
        Integer runningNo = null;
        String genbook = Enum.Bookcategory.valueOf(bCat).getCode();
        DecimalFormat decimalFormat = new DecimalFormat("000");

        //------------------- Check have book or not ----------------------//
        if (libraryservice.getBooks().getBooks().size() != 0 ){
            for (Book b : libraryservice.getBooks().getBooks())
            if (genbook.equals(b.getBookcode().substring(0, 1))) {
                if (runningNo == null || runningNo < Integer.parseInt(b.getBookcode().substring(1))) {
                    runningNo = Integer.parseInt(b.getBookcode().substring(1));
                }
            } else runningNo = 0;
        }
        else if (0 == libraryservice.getBooks().getBooks().size()){
            runningNo = 0 ;
        }
        runningNo++;
        String bCode = genbook + decimalFormat.format(runningNo);

        //-------------------- Add book to list -----------------------------//
        book_add.setBookname(bName);
        book_add.setBookcode(bCode);
        book_add.setBookcategory(Enum.Bookcategory.valueOf(bCat));
        book_add.setBookstatus(Enum.Bookstatus.BLANK);
        libraryservice.getBooks().getBooks().add(book_add);

        //--------------------- Show Book Add ------------------------//
        for (int i = 0; i < libraryservice.getBooks().getBooks().size(); i++) {
            System.out.println(libraryservice.getBooks().getBooks().get(i));
        }
    }


    //========================== Remove BOOK ==========================//
    public static void removebook() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        Scanner dc = new Scanner(System.in);
        System.out.println("\nPlease insert Book code to delete : ");
        String id = dc.nextLine();
        Iterator<Book> iterator = libraryservice.getBooks().getBooks().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookcode().equals(id)) {
                iterator.remove();
                System.out.println("Book code : [" + book.getBookcode() + "] has been delete.");
            } else if (book.getBookcode().equalsIgnoreCase(id)) {
                System.out.println("Sorry your book code is not exist");
            }
        }
        showHistory();
    }
    public static void show() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        System.out.println("=====================");
        System.out.println("this is book in list : ");
        for (int i = 0; i < libraryservice.getBooks().getBooks().size(); i++) {
            System.out.println(libraryservice.getBooks().getBooks().get(i));
        }
        System.out.println("=====================");
    }


    //************************* Search Book *************************//
    public static void searchBookname() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        String nameS = inputBookname().nextLine();
        boolean isState = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookname().equalsIgnoreCase(nameS)) {
                isState = true;
                if (book.getBookname().equalsIgnoreCase(nameS)) {
                    printOut(book);
                    User_main.login_user2();
                } else {
                    System.out.println("Sorry your book is not exist to my Grouplease Library");
                }
            }
        }
        if (!isState) {
            System.out.println("Please Again Enter Book Code");
            User_main.login_user2();
        }
    }
    private static Scanner inputBookname(){
        Scanner n = new Scanner(System.in);
        System.out.print("Please enter book name : ");
        return n;
    }

    public static void searchBookcode() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        String codeS = inputBookcode().nextLine();
        boolean isState = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookcode().equalsIgnoreCase(codeS)) {
                isState = true;
                if (book.getBookcode().equalsIgnoreCase(codeS)) {
                    printOut(book);
                    User_main.login_user2();
                } else {
                    System.out.println("'Sorry your  book is  not exist to my Grouplease Library");
                }
            }
        }
        if (!isState) {
            System.out.println("Please Again Enter Book Code");
            User_main.login_user2();
        }
    }
    private static Scanner inputBookcode(){
        Scanner n2 = new Scanner(System.in);
        System.out.print("Please enter book code : ");
        return n2;
    }

    public static void searchBookcatagory() {
        try {
            Libraryservice libraryservice = Libraryservice.getInstance();
            String N3 = inputBookcatagory().nextLine();
            boolean isState = false;
            for (Book book : libraryservice.getBooks().getBooks()) {
                if (book.getBookcategory().equals(Enum.Bookcategory.valueOf(N3))) {
                    printOut(book);
                }
            }
            if (!false) {
                System.out.println("Please Again Enter Book Code");
                User_main.login_user2();
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Please Again Enter Book Code");
            User_main.login_user2();
        }
    }
    private static Scanner inputBookcatagory() {
        Scanner n3 = new Scanner(System.in);
        System.out.print("Please enter book Category's : ");
        return  n3;
    }

//    public static void searchBookstatus() {
//        Libraryservice libraryservice = Libraryservice.getInstance();
//        Scanner n4 = new Scanner(System.in);
//        System.out.println("Please enter book Status : ");
//        String N4 = n4.nextLine();
//        Enum.Bookstatus bookstatus = Enum.Bookstatus.valueOf(N4);
//        boolean found = false;
//        for (Book book : libraryservice.getBooks().getBooks()) {
//            if (book.getBookstatus().equals(bookstatus)) {
//                found = true;
//                if (book.getBookstatus().equals(bookstatus)) {
//                    printOut(book);
//                } else {
//                    System.out.println("'Sorry your book is not exist to my Grouplease  Library");
//
//                }
//            } else {
//                found = false;
//            }
//        }
//        if (!found) {
//            System.out.println("ไม่เจอ");
//        }
//    }

    //=================================== SORT BOOK ============================================//

    //************************* Sort by name  *************************//
    static Comparator<Book> comparatorname = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookname().toUpperCase();
            String BookN2 = o2.getBookname().toUpperCase();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************  Sort by Code *************************//
    static Comparator<Book> comparatorcode = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookcode().toUpperCase();
            String BookN2 = o2.getBookcode().toUpperCase();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************   *************************//
    static Comparator<Book> comparatorCategory = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookcategory().toString();
            String BookN2 = o2.getBookcategory().toString();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************  Sort by Status *************************//
//    public static Comparator<Book> comparatorstatus = new Comparator<Book>() {
//        @Override
//        public int compare(Book o1, Book o2) {
//            String BookN1 = o1.getBookstatus().toString();
//            String BookN2 = o2.getBookstatus().toString();
//            return BookN1.compareTo(BookN2);
//        }
//    };


    //=================================== CHANG  BOOK DATE RETURN =======================================//
    public static void changDatereturn() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        System.out.println("Please input Book code to Chang Date");
        String id = inputDatereturn().nextLine();
        boolean found = false;
        for (History history1 : libraryservice.getHistoryList().getHistories()) {
            if (history1.getBookcode().equals(id)) {
                found = true;
                if (history1.getBookstatus().equals(Enum.Bookstatus.Not_Confirmed)) {
                    System.out.println("กรูณาระบุวันที่คืน");
                    int x = inputDatereturn().nextInt();
                    if (DAYS.between(history1.getDatereturn(), history1.getDatereturn().plusDays(x)) > 15) {
                        System.out.println("เกินกำหนดวันที่สามารถยืมได้");
                        changDatereturn();
                    }
                    history1.setDatereturn(history1.getDatereturn().plusDays(x));
                    showHistory();
                } else {
                    found = false;
                }
            }
        }
        if (!found) {
            System.out.println("ไม่เจอ");
        }
    }

    private static Scanner inputDatereturn(){
        Scanner ch = new Scanner(System.in);
        return ch;
    }
    //=================================== Permits STATE BOOK ============================================//
    static void perMits() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        History history = new History();
        String codeS = inputPermits().nextLine();
        Iterator<Book> bookIterator = libraryservice.getBooks().getBooks().iterator();
        Iterator<User> userIterator = libraryservice.getUserList().getUsers().iterator();
        /* Iterator<History> historyIterator = libraryservice.getHistoryList().getHistories().iterator(); */
        /* User user = userIterator.next(); */
        boolean isFound = false;
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            if (book.getBookcode().equalsIgnoreCase(codeS)) {
                isFound = true;
                if (book.getBookstatus().equals(Enum.Bookstatus.BLANK)) { //Seach by BookStatus
//                    book.setBookstatus(Enum.Bookstatus.BUSY);
                    try {
                        for (History history1 : libraryservice.getHistoryList().getHistories()) {
                            if (history1.getBookcode().equalsIgnoreCase(codeS) && history1.getBookstatus().equals(Enum.Bookstatus.Not_Confirmed)) {
                                history1.setBookstatus(Enum.Bookstatus.Confirm);
                                book.setBookstatus(Enum.Bookstatus.BUSY);
                                showHistory();
                            }
                            // System.out.println(">>...The specified book could not be found...<<\n");

                        }
                    } catch (ConcurrentModificationException ignored) {
                    }

                }
                else {
                    isFound = false;
                    System.out.println(">>...The specified book could not be found...<<\n");
                }
            }

        }
        if (!isFound) {
            System.out.println("---------------------------------------");
            System.out.println("|    Please Again Enter Book Code     |");
            System.out.println("|            Cannot Books             |");
            System.out.println("---------------------------------------");
//            perMits();
        }

        Login_librarian.mainLibrarian();
    }
    private static Scanner inputPermits(){
        Scanner n = new Scanner(System.in);
        System.out.println("========Bollow Book=========");
        System.out.print("Please enter code name: ");
        return n;
    }

    //=================================== Return STATE BOOK ============================================//
    static void returnbook() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        String bookCode = inputRetrunbook().nextLine();
        Iterator<History> historyIterator = libraryservice.getHistoryList().getHistories().iterator();
        boolean returnbook = false;
        while (historyIterator.hasNext()) {
            History historybook = historyIterator.next();
            if (historybook.getBookcode().equalsIgnoreCase(bookCode)) {
                returnbook = true;
                if (historybook.getBookcode().equals(bookCode)) {
                    if (historybook.getBookstatus().equals(Enum.Bookstatus.Confirm)) {
                        historybook.setBookstatus(Enum.Bookstatus.BLANK);

                        //              Check DateReturn.  with DateNow..............
                        int x = (int) DAYS.between(historybook.getDatereturn(), LocalDate.now());
                        if (x > 0) {
                            System.out.println(" You return book late " + x + " day(s)");
                        } else {
                            System.out.println("Return Book Success >_<' ");
                        }
                        //**********************************************************************************//
                        for (Book book : libraryservice.getBooks().getBooks()) {
                            if (book.getBookcode().equals(bookCode)) {
                                book.setBookstatus(Enum.Bookstatus.BLANK);
//                                printOut(book);
                                showHistory();
                            }
                        }
//                        showHistory();
                    }
                } else {
                    System.out.println("Book is not");
                }
            }
        }
        if (!returnbook) {
            System.out.println("Please Again Enter Book Code");
        }
    }
    private static Scanner inputRetrunbook(){
        Scanner n = new Scanner(System.in);
        System.out.println("========Return Book=========");
        System.out.println("Please enter book code: ");
        return  n ;
    }
}

