package com.company;
import com.company.History.History;

import java.time.LocalDate;

public class Main {

    public static Object Book;

    public static void main(String[] args) {

        //************************* Variable *************************//
        System.out.println("===========================");
        System.out.println("||                       ||");
        System.out.println("||   WellCome to Liberry ||");
        System.out.println("||                       ||");
        System.out.println("===========================");
        Controller controller = new Controller() ;
        LocalDate date = LocalDate.now();
        Controller.Bookshelf books = new Controller.Bookshelf();
        UserList userlist =new UserList();
        History history = new History();
        history.HistoryList(history);
        Bookex bex = new Bookex();
        bex.setbooxEx(books.getBooks());
        controller.controller(books,userlist,history);
        //************************* Login Section *************************//

        //************************* Administrator Section *************************//
    }
}



