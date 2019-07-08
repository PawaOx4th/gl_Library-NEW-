package com.company.Librarian;

import com.company.Bbook.Book;
import com.company.Controller;
import com.company.Enum;
import com.company.History.History;
import com.company.History.HistoryList;
import com.company.Human.UserList;
import com.company.Usergrouplease.User;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;


public class Admin_Function {

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
    public static  void printhistory(History history){
        System.out.println("===================================================================================================================================================");
        System.out.print(" Book Name: "+"[" + history.getBookname()+"]"+"|");
        System.out.print("Book Type: " +"["+ history.getBookcategory()+"]"+"|");
        System.out.print("Book Code: "+"[" + history.getBookcode()+"]"+"|");
        System.out.print("Book Bookstatus:" +"["+ history.getBookstatus()+"]"+"|");
        System.out.print("User ID:" +"["+  history.getUserid()+"]"+"|");
        System.out.print("User Name:"+"[" +  history.getUser()+"]"+"|");
        System.out.print("Book Date Bollow: "+"[" + history.getDateborrow()+"]"+"|");
        System.out.println("Book Date Return: "+"[" + history.getDatereturn()+"]"+"|");
        System.out.print("===================================================================================================================================================");

    }


    //========================== ADD BOOK ==========================//
    public static void Addbook(Controller.Bookshelf books) {
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
        String Genbook = Enum.Bookcategory.valueOf(bCat).getCode();
        DecimalFormat decimalFormat = new DecimalFormat("000");
        Random random = new Random();
        int d = random.nextInt(999);
        decimalFormat.format(d);
        String bCode = Genbook + decimalFormat.format(d) ;
        //------------------------------------------------------------//
        book_add.setBookname(bName);
        book_add.setBookcode(bCode);
        book_add.setBookcategory(Enum.Bookcategory.valueOf(bCat));
        book_add.setBookstatus(Enum.Bookstatus.BLANK);
        books.getBooks().add(book_add);

        //===========================================================//
        for (int i = 0; i < books.getBooks().size(); i++) {
            System.out.println(books.getBooks().get(i));
        }
        System.out.println("=====================");
    }

    //========================== Remove BOOK ==========================//
    public static void removebook(Controller.Bookshelf books) {

        Scanner dc = new Scanner(System.in);
        System.out.println("\nPlease insert Book code to delete : ");
        String id = dc.nextLine();
        Iterator<Book> iterator = books.getBooks().iterator();
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

    public static void show(Controller.Bookshelf books) {
        System.out.println("=====================");
        System.out.println("this is book in list : ");
        for (int i = 0; i < books.getBooks().size(); i++) {
            System.out.println(books.getBooks().get(i));
        }
        System.out.println("=====================");
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
                    System.out.println("'Sorry your book is not exist to my Grouplease Library");
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
    //=========================================================================================//

    //=================================== CHANG  BOOK DATE RETURN ============================================//
    public static void changDatereturn(HistoryList history) {
        Scanner ch = new Scanner(System.in);
        System.out.println("Please input Book code to Chang Date");
        String id = ch.nextLine();
        boolean found = false;
        for(History history1 : history.getHistories()){
            if(history1.getBookcode().equals(id)){
                found = true ;
                if(history1.getBookstatus().equals(Enum.Bookstatus.Confirm)){
                    System.out.println("กรูณาระบุวันที่คืน");
                    int x = ch.nextInt();
//                    LocalDate newDate =  book.getReturns().plusDays(x);
//                    int comparedate = (newDate.compareTo(book.getBollow()));
//                    DAYS.between(book.getBollow(),book.getReturns().plusDays(x));
                    if( DAYS.between(history1.getDatereturn(),history1.getDatereturn().plusDays(x)) > 15){
                        System.out.println("เกินกำหนดวันที่สามารถยืมได้");
                        changDatereturn(history);
                    }
                    history1.setDatereturn(history1.getDatereturn().plusDays(x));
                    printhistory(history1);
                }
                else {
                    found = false;
                }
            }
        }
        if(!found){
            System.out.println("ไม่เจอ");
        }
    }

    //=================================== Permits STATE BOOK ============================================//
    public static void permits(Controller.Bookshelf books, UserList userList, HistoryList historyList) {
        History history = new History();
        Scanner n = new Scanner(System.in);
        System.out.println("========Bollow Book=========");
        System.out.print("Please enter code name : ");
        String codeS = n.nextLine();
        System.out.println("========Name User Book=========");
        System.out.print("Please enter UserID name : ");
        String nameS = n.nextLine();
        Iterator<Book> bookIterator = books.getBooks().iterator();
        Iterator<User> userIterator = userList.getUsers().iterator();
//        Book book = bookIterator.next();
        User user = userIterator.next();
        boolean isFound = false;
        while (bookIterator.hasNext()) {
//            Controller controller = new Controller();
//            Book book = bookIterator.next();
//            User user = userIterator.next();
            Book book = bookIterator.next();
            if (book.getBookcode().equalsIgnoreCase(codeS) && user.getId().equalsIgnoreCase(nameS)) {
                isFound = true;
//                printOut(book);
                if ((book.getBookstatus().equals(Enum.Bookstatus.Not_Confirmed))) {
                    book.setBookstatus(Enum.Bookstatus.BUSY);
                    history.setBookname(book.getBookname());
                    history.setBookcode(book.getBookcode());
                    history.setUserid(user.getId());
                    history.setUser(user.getName());
                    history.setBookstatus(Enum.Bookstatus.Confirm);
                    history.setBookcategory(book.getBookcategory());
                    history.setDateborrow(LocalDate.now());
                    history.setDatereturn(LocalDate.now().plusDays(7));
                    historyList.getHistories().add(history);
                    printhistory(history);
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
    public static void returnbook(Controller.Bookshelf books,HistoryList historyList){
        Scanner n = new Scanner(System.in);
        System.out.println("========Return Book=========");
        System.out.println("Please enter book code : ");
        String nameS = n.nextLine();
        System.out.println("============================");
        Iterator<Book> iterator = books.getBooks().iterator();
        Iterator<History>historyIterator = (Iterator<History>) historyList.getHistories();
        boolean returnb = false;
        while (historyIterator.hasNext()) {
            Book book = iterator.next();
            History historybook = historyIterator.next();
            if (historybook.getBookcode().equalsIgnoreCase(nameS)) {
                returnb = true;
                if ((book.getBookstatus().equals(Enum.Bookstatus.BUSY))) {
                    book.setReturns(LocalDate.now());
                    book.setBookstatus(Enum.Bookstatus.BLANK);
                    historybook.setBookstatus(Enum.Bookstatus.Confirm);
                    historybook.setDatereturn(LocalDate.now());
                    printOut(book);
                } else {
                    System.out.println("Book is not" + book.getBookstatus());
                }
            } else {}
        }
        if (!returnb){ System.out.println("Please Again Enter Book Code");}
    }
}

