package com.company.Librarian;

import com.company.Book.Book;
import com.company.Enum;
import com.company.History.History;
import com.company.Service.Libraryservice;
import com.company.Users.User;

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
        //===================== Generate bookcode ===================//
        Integer runningNo = null;
        String genbook = Enum.Bookcategory.valueOf(bCat).getCode();
        DecimalFormat decimalFormat = new DecimalFormat("000");
        for (Book b : libraryservice.getBooks().getBooks()) {
            if (genbook.equals(b.getBookcode().substring(0, 1))) {
                if (runningNo == null || runningNo < Integer.parseInt(b.getBookcode().substring(1))) {
                    runningNo = Integer.parseInt(b.getBookcode().substring(1));
                }
            }
        }
        int number = runningNo + 1;
        String bCode = genbook + decimalFormat.format(number);

        //------------------------------------------------------------//
        book_add.setBookname(bName);
        book_add.setBookcode(bCode);
        book_add.setBookcategory(Enum.Bookcategory.valueOf(bCat));
        book_add.setBookstatus(Enum.Bookstatus.BLANK);
        libraryservice.getBooks().getBooks().add(book_add);

        //============================ Show Book Add =============================//
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
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter book name: ");
        String nameS = n.nextLine();
        boolean isState = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookname().equalsIgnoreCase(nameS)) {
                isState = true;
                if (book.getBookname().equalsIgnoreCase(nameS)) {
                    printOut(book);
                } else {
                    System.out.println("'Sorry your book is not exist to my Grouplease Library");
                }
            }
        }
        if (!isState) {
            System.out.println("Please Again Enter Book Code");
        }
    }

    public static void searchBookid() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        Scanner n2 = new Scanner(System.in);
        System.out.println("Please enter book code: ");
        String codeS = n2.nextLine();
        boolean isState = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookcode().equalsIgnoreCase(codeS)) {
                isState = true;
                if (book.getBookcode().equalsIgnoreCase(codeS)) {
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

    public static void searchBookcatagory() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        Scanner n3 = new Scanner(System.in);
        System.out.println("Please enter book Cattegory: ");
        String N3 = n3.nextLine();
        Enum.Bookcategory cattegoryS = Enum.Bookcategory.valueOf(N3);
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookcategory().equals(cattegoryS)) {

                printOut(book);


            } else if (book.getBookcategory().equals(cattegoryS)) {
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }

    public static void searchBookstatus() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        Scanner n4 = new Scanner(System.in);
        System.out.println("Please enter book Status : ");
        String N4 = n4.nextLine();
        Enum.Bookstatus bookstatus = Enum.Bookstatus.valueOf(N4);
        boolean found = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookstatus().equals(bookstatus)) {
                found = true;
                if (book.getBookstatus().equals(bookstatus)) {
                    printOut(book);
                } else {
                    System.out.println("'Sorry your book is not exist to my Grouplease  Library");

                }
            } else {
                found = false;
            }
        }
        if (!found) {
            System.out.println("ไม่เจอ");
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


    //=================================== CHANG  BOOK DATE RETURN =======================================//
    public static void changDatereturn() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        Scanner ch = new Scanner(System.in);
        System.out.println("Please input Book code to Chang Date");
        String id = ch.nextLine();
        boolean found = false;
        for (History history1 : libraryservice.getHistoryList().getHistories()) {
            if (history1.getBookcode().equals(id)) {
                found = true;
                if (history1.getBookstatus().equals(Enum.Bookstatus.Not_Confirmed)) {
                    System.out.println("กรูณาระบุวันที่คืน");
                    int x = ch.nextInt();
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


    //=================================== Permits STATE BOOK ============================================//
    public static void permits() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        History history = new History();
        Scanner n = new Scanner(System.in);
        System.out.println("========Bollow Book=========");
        System.out.print("Please enter code name: ");
        String codeS = n.nextLine();
        Iterator<Book> bookIterator = libraryservice.getBooks().getBooks().iterator();
        Iterator<User> userIterator = libraryservice.getUserList().getUsers().iterator();
        Iterator<History> historyIterator = libraryservice.getHistoryList().getHistories().iterator();
        User user = userIterator.next();
        boolean isFound = false;
        while (bookIterator.hasNext()) {
            Book book = bookIterator.next();
            if (book.getBookcode().equalsIgnoreCase(codeS)) {
                isFound = true;
                if (book.getBookstatus().equals(Enum.Bookstatus.BLANK)) { //Seach by BookStatus
                    book.setBookstatus(Enum.Bookstatus.BUSY);
                    try {
                        for (History history1 : libraryservice.getHistoryList().getHistories()) {
                            if (history1.getBookcode().equalsIgnoreCase(codeS) && history1.getBookstatus().equals(Enum.Bookstatus.Not_Confirmed)) {
                                history1.setBookstatus(Enum.Bookstatus.Confirm);
                                book.setBookstatus(Enum.Bookstatus.BUSY);
                                showHistory();
                            }
                            System.out.println("\n");
                        }
                    } catch (ConcurrentModificationException ignored) {
                    }

                }
                else {
                    isFound = false;
                }
            }

        }
        if (!isFound) {
            System.out.println("--------------------------------------");
            System.out.println("|    Please Again Enter Book Code    |");
            System.out.println("|            Cannot Books             |");
            System.out.println("--------------------------------------");
//            permits();
        }

        Login_librarian.mainLibrarian();
    }

//    public static void addTohistory(Book book, User user) {
//        Libraryservice libraryservice = Libraryservice.getInstance();
//        History history = new History();
//        book.setBookstatus(Enum.Bookstatus.BUSY);
////        history.setBookname(book.getBookname());
////        history.setBookcode(book.getBookcode());
////        history.setUserid(user.getId());
////        history.setUser(user.getName());
//        history.setBookstatus(Enum.Bookstatus.Confirm);
////        history.setBookcategory(book.getBookcategory());
////        history.setDateborrow(LocalDate.now());
////        history.setDatereturn(LocalDate.now().plusDays(7));
////        libraryservice.getHistoryList().getHistories().add(history);
//    }

    //=================================== Return STATE BOOK ============================================//
    public static void returnbook() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        Scanner n = new Scanner(System.in);
        System.out.println("========Return Book=========");
        System.out.println("Please enter book code: ");
        String bookCode = n.nextLine();
        Iterator<History> historyIterator = libraryservice.getHistoryList().getHistories().iterator();
        boolean returnbook = false;
        while (historyIterator.hasNext()) {
            History historybook = historyIterator.next();
            if (historybook.getBookcode().equalsIgnoreCase(bookCode)) {
                returnbook = true;
                if (historybook.getBookcode().equals(bookCode)) {
                    if (historybook.getBookstatus().equals(Enum.Bookstatus.Confirm)) {
                        historybook.setBookstatus(Enum.Bookstatus.BLANK);
                        int x = (int) DAYS.between(historybook.getDatereturn(), LocalDate.now()); // Check DateReturn.  with DateNow.
                        if (x > 0) {
                            System.out.println(" You return book late " + x + " day(s)");
                        } else {
                            System.out.println("Return Book Success >_<' ");
                        }
                        //**********************************************************************************//
                        for (Book book : libraryservice.getBooks().getBooks()) {
                            if (book.getBookcode().equals(bookCode)) {
                                book.setBookstatus(Enum.Bookstatus.BLANK);
                                printOut(book);
                            }
                        }
                        showHistory();
                    }
                } else {
                    System.out.println("Book is not");
                }
            } else {

            }
        }
        if (!returnbook) {
            System.out.println("Please Again Enter Book Code");
        }
    }
}

