package com.company.Service;

import com.company.Book.Bookshelf;
import com.company.History.HistoryList;
import com.company.Human.UserList;
import com.company.Librarian.Librarian;
import com.company.Usergrouplease.User;

public class Libraryservice {
    private static Libraryservice instance;

    private UserList librarianList;
    private UserList userList;
    private Bookshelf books;
    private HistoryList historyList;
    private User user;
    private Librarian librarian;
    private Libraryservice() {
    }

    public static Libraryservice getInstance() {
        if (instance == null){
            instance = new Libraryservice();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public UserList getUserList() {
        return userList;
    }

    public  void setUserList(UserList userList){
        this.userList =userList;
    }
    public UserList getLibrarianList() {
        return librarianList;
    }

    public void setLibrarianList(UserList librarianList) {
        this.librarianList = librarianList;
    }

    public Bookshelf getBooks() {
        return books;
    }

    public void setBooks(Bookshelf books) {
        this.books = books;
    }

    public HistoryList getHistoryList() {
        return historyList;
    }

    public void setHistoryList(HistoryList historyList) {
        this.historyList = historyList;
    }

    //*********************************************************************************************************//


}
