package com.company;
import com.company.Bbook.Bookex;
import com.company.History.History;
import com.company.History.HistoryList;
import com.company.Human.UserList;
import com.company.Librarian.Admin_Function;
import com.company.Usergrouplease.User;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
public class Main {

    public static Object Book;

    public static void main(String[] args) {

        //************************* Variable *************************//
//        System.out.println(DAYS.between(LocalDate.of(2019,7,5),LocalDate.of(2019,7,20)));
        System.out.println("===========================");
        System.out.println("||                       ||");
        System.out.println("||  WellCome to Liberry  ||");
        System.out.println("||                       ||");
        System.out.println("===========================");

        Controller controller = new Controller() ;
        LocalDate date = LocalDate.now();
        Controller.Bookshelf books = new Controller.Bookshelf();
//        User user =new User();
        UserList userlist = new UserList();
        userlist.users2(userlist);
        History history = new History();
//        history.HistoryList();
        HistoryList historyList = new HistoryList();
        historyList.HistoryList(historyList);
        Bookex bex = new Bookex();
        bex.setbooxEx(books.getBooks());
        System.out.println(userlist.getUsers().size());
        controller.controller(books,userlist,historyList);

        //============================================================//


        //============================================================//
    }
}



