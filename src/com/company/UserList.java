package com.company;

import java.util.ArrayList;

public class UserList {
    ArrayList<librarian> librarians = new ArrayList();

    public ArrayList<librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(ArrayList<librarian> librarians) {
        this.librarians = librarians;
    }
    //================================================================
    public static void librarian2 (UserList libralist){
        libralist.getLibrarians().add(new librarian("pawanachai","seeruesang","L001","L001",Position.librarian));
        libralist.getLibrarians().add(new librarian("pawanachai","seeruesang","l002","l002",Position.librarian));
    }
}
