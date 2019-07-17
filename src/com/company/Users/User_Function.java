package com.company.Users;

import com.company.Book.Book;
import com.company.Enum;
import com.company.History.History;
import com.company.Service.Libraryservice;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

class User_Function {

    public static boolean isState;

    private static  void printOut(Book book){
        System.out.println("===================================================================================================================================================");
        System.out.print("  Book Name:" +"["+ book.getBookname()+"]"+"| ");
        System.out.print("Book Type:" +"["+ book.getBookcategory()+"]"+"| ");
        System.out.print("Book Code:" +"["+ book.getBookcode()+"]"+"| ");
        System.out.print("Book Bookstatus:" +"["+ book.getBookstatus()+"]"+"| ");
        System.out.print("Book Date Bollow:"+"[" + book.getBollow()+"]"+"| ");
        System.out.println("Book Date Return:"+"[" + book.getReturns()+"]"+"| ");
        System.out.print("===================================================================================================================================================");
    }

    static  void printHistory(){
        //*************************  Show History *************************//
        Libraryservice libraryservice = Libraryservice.getInstance();
        for (int i = 0; i < libraryservice.getHistoryList().getHistories().size(); i++) {
            System.out.println(libraryservice.getHistoryList().getHistories().get(i));
        }
    }

    /*============================================== Search Book ==============================================*/
    static void searchBookname() {
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
    //InputBookname
    private static Scanner inputBookname(){
        Scanner n = new Scanner(System.in);
        System.out.print("Please enter book name : ");
        return n;
    }

    static void searchBookcode() {
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
                    System.out.println("'Sorry your  book is not exist to my Grouplease Library");
                }
            }
        }
        if (!isState) {
            System.out.println("Please Again Enter Book Code");
            User_main.login_user2();
        }
    }
    //InputBookcode
    private static Scanner inputBookcode(){
        Scanner n2 = new Scanner(System.in);
        System.out.print("Please enter book code : ");
        return n2;
    }

    static void searchBookcatagory() {
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
            System.out.println(" Please Again Enter Book Code");
            User_main.login_user2();
        }

    }
    //InputBookcatagory
    private static Scanner inputBookcatagory() {
        Scanner n3 = new Scanner(System.in);
        System.out.print("Please enter book Category's : ");
        return  n3;
    }


    //=================================== CHANG  BOOK DATE RETURN ================================================//
    static void changDatereturn() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        String id = idInput().nextLine();
        boolean found = false;
        for(History history1 : libraryservice.getHistoryList().getHistories()){
            if(history1.getBookcode().equals(id)){
                found = true ;
                if(history1.getBookstatus().equals(Enum.Bookstatus.Confirm)){
                    System.out.println("Please specify the date of return");
                    int x = idInput().nextInt();
                    if( DAYS.between(history1.getDatereturn(),history1.getDatereturn().plusDays(x)) > 15){
                        System.out.println(" Until the due date ");
                        changDatereturn();
                    }
                    history1.setDatereturn(history1.getDatereturn().plusDays(x));

                    //*************************  Show History *************************//
                    for (int i = 0; i < libraryservice.getHistoryList().getHistories().size(); i++) {
                        System.out.println(libraryservice.getHistoryList().getHistories().get(i));
                    }
                }
                else {
                    found = false;
                }
            }
        }
        if(!found){
            System.out.println("Not found ");
            User_main.login_user2();
        }
    }
    private static Scanner idInput(){
        Scanner ch = new Scanner(System.in);
        System.out.println("Please input Book code to Chang Date");
        return ch;
    }


    //================================================= Rental ===================================================//
    static void rentalBook(){
        Libraryservice libraryservice = Libraryservice.getInstance();                   //success
        History history = new History();
        Scanner inputrentalCode = new Scanner(System.in);
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        System.out.print("Book Code: ");
        String code = inputrentalCode.nextLine();
        boolean isState = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookcode().equalsIgnoreCase(code)) {
                isState = true;
                if (book.getBookstatus().equals(Enum.Bookstatus.BLANK)) {
                    history.setUUID(randomUUIDString);
                    history.setBookstatus(Enum.Bookstatus.Not_Confirmed);
                    history.setBookname(book.getBookname());                            //Bookname
                    history.setBookcode(book.getBookcode());                            //Bookcode
                    history.setBookcategory(book.getBookcategory());                    //Bookcategory
                    history.setDateborrow(LocalDate.now());                             //BookDate Bollow
                    history.setDatereturn(LocalDate.now().plusDays(7));                 //BookDate Return
                    history.setUser(libraryservice.getUser().getName());                //Username
                    history.setUserid(libraryservice.getUser().getId());                //UserID
                    libraryservice.getHistoryList().getHistories().add(history);
                    printHistory();
                } else {
                    System.out.println("'Sorry your book is not exist to my Grouplease Library");
                }
            }
        }
        if (!isState) { System.out.println("Please Again Enter Book Code");}
    }

    /*=========================================== Return STATE BOOK ==============================================*/
    static void returnbook(){
        Libraryservice libraryservice = Libraryservice.getInstance();
        Scanner n = new Scanner(System.in);
        System.out.println("========Return Book=========");
        System.out.println("Please enter book code: ");
        String bookCode = n.nextLine();
        Iterator<History>historyIterator = libraryservice.getHistoryList().getHistories().iterator();
        boolean returnbook = false;
        while (historyIterator.hasNext()) {
            History historybook = historyIterator.next();
            if (historybook.getBookcode().equalsIgnoreCase(bookCode)) {
                returnbook = true;
                if (historybook.getBookcode().equals(bookCode)) {
                    if (historybook.getBookstatus().equals(Enum.Bookstatus.Confirm)){
                        historybook.setBookstatus(Enum.Bookstatus.BLANK);
                        historybook.setDatereturn(LocalDate.now());
                        for (Book book:libraryservice.getBooks().getBooks() ) {
                            if (book.getBookcode().equals(bookCode)) {
                                book.setBookstatus(Enum.Bookstatus.BLANK);
                                printOut(book);
                            }
                        }
                        printHistory();
                    }
                } else {
                    System.out.println("Book is not");
                }
            }
        }
        if (!returnbook){ System.out.println("Please Again Enter Book Code");}
    }

}

