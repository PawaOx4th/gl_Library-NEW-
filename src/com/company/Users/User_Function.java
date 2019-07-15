package com.company.Users;

import com.company.Book.Book;
import com.company.Display.user_Display;
import com.company.Enum;
import com.company.History.History;
import com.company.Service.Libraryservice;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

class User_Function {

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

    public static  void printHistory(){
        //*************************  Show History *************************//
        Libraryservice libraryservice = Libraryservice.getInstance();
        for (int i = 0; i < libraryservice.getHistoryList().getHistories().size(); i++) {
            System.out.println(libraryservice.getHistoryList().getHistories().get(i));
        }
    }
    /*============================================== Search Book ==============================================*/
    public static void searchBookname() {
        Libraryservice libraryservice = Libraryservice.getInstance();
//        Userservice userservice = Userservice.getInstance();
        Scanner n = new Scanner(System.in);
        System.out.println("Please enter book name : ");
        String nameS = n.nextLine();
        boolean isState = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookname().equalsIgnoreCase(nameS)) {
                isState = true;
                if (book.getBookname().equalsIgnoreCase(nameS)) {
                    printOut(book);
                    user_Display.userManu();
                } else {
                    System.out.println("'Sorry your book is not exist to my Grouplease Library");
                }
            }
        }
        if(!isState){System.out.println("Please Again Enter Book Code");}
    }
    public static void seachBookcode() {
        Libraryservice libraryservice = Libraryservice.getInstance();
//        Userservice userservice = Userservice.getInstance();
        Scanner n2 = new Scanner(System.in);
        System.out.println("Please enter book code : ");
        String codeS = n2.nextLine();
        boolean isState = false;
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookcode().equalsIgnoreCase(codeS)) {
                isState = true;
                if (book.getBookcode().equalsIgnoreCase(codeS)) {
                    printOut(book);
                    user_Display.userManu();
                } else {
                    System.out.println("'Sorry your  book is not exist to my Grouplease Library");
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
//        Userservice userservice = Userservice.getInstance();
        Scanner n3 = new Scanner(System.in);
        System.out.println("Please enter book Cattegory : ");
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
//        Userservice userservice = Userservice.getInstance();
        Scanner n4 = new Scanner(System.in);
        System.out.println("Please enter book Status : ");
        String N4 = n4.nextLine();
        Enum.Bookstatus bookstatus = Enum.Bookstatus.valueOf(N4);
        for (Book book : libraryservice.getBooks().getBooks()) {
            if (book.getBookstatus().equals(bookstatus)) printOut(book);
            else if (book.getBookstatus().equals(bookstatus)) {
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }

    //=================================== CHANG  BOOK DATE RETURN ============================================//
    public static void changDatereturn() {
        Libraryservice libraryservice = Libraryservice.getInstance();
//        Userservice userservice = Userservice.getInstance();
        Scanner ch = new Scanner(System.in);
        System.out.println("Please input Book code to Chang Date");
        String id = ch.nextLine();
        boolean found = false;
        for(History history1 : libraryservice.getHistoryList().getHistories()){
            if(history1.getBookcode().equals(id)){
                found = true ;
                if(history1.getBookstatus().equals(Enum.Bookstatus.Confirm)){
                    System.out.println("กรูณาระบุวันที่คืน");
                    int x = ch.nextInt();
                    if( DAYS.between(history1.getDatereturn(),history1.getDatereturn().plusDays(x)) > 15){
                        System.out.println(" เกินกำหนดวันที่สามารถยืมได้");
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
            System.out.println("ไม่เจอ");
            user_Display.userManu();
        }
    }

    /*================================================= Rental ===================================================*/
    public static void rentalbook(){
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
            } else {
            }
        }
        if (!isState) { System.out.println("Please Again Enter Book Code");}
    }

    /*=========================================== Return STATE BOOK ==============================================*/
    public static void returnbook(){
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
            } else {
            }
        }
        if (!returnbook){ System.out.println("Please Again Enter Book Code");}
    }
}

