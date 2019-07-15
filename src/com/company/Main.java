package com.company;

import com.company.Book.Bookex;
import com.company.Book.Bookshelf;
import com.company.History.HistoryList;
import com.company.Human.UserList;
import com.company.Service.Libraryservice;

public class Main {

    public static Object Book;


    public static void main(String[] args) {
//
//        //************************* Variable *************************//

        System.out.println("===========================");
        System.out.println("||                       ||");
        System.out.println("||  WellCome to Library  ||");
        System.out.println("||                       ||");
        System.out.println("===========================");

        //*** Set Services ***//
        Libraryservice service = Libraryservice.getInstance();
//        Userservice userservice = Userservice.getInstance();

        //** Crate Object LibrarianList Services ***//
        UserList librarianList = new UserList();
        UserList.librarian2(librarianList);
        service.setLibrarianList(librarianList);

        //** Crate Object UserList Services ***//
        UserList userList = new UserList();
        UserList.users2(userList);
        service.setUserList(userList);

        //** Crate Book Object ***//
        Bookshelf books = new Bookshelf();
        Bookex.setbooxEx(books);
        service.setBooks(books);

        //** Crate History Object ***//
        HistoryList historyList = new HistoryList();
        HistoryList.HistoryList(historyList);
        service.setHistoryList(historyList);

        //** Test ***//
        Controller.controller(books, userList, historyList);
    }
}



