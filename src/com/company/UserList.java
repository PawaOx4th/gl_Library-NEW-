package com.company;

import java.util.ArrayList;

public class UserList {
    private ArrayList librarians = new ArrayList();
    public ArrayList<librarian> getLibrarians() {
        return librarians;
    }
    private ArrayList users = new ArrayList();
    public ArrayList<User>getuser(){return  users;}

    //==================================================================================================================//
    public void setLibrarians(ArrayList<librarian> librarians) {
        this.librarians = librarians;
    }
    public static void librarian2 (UserList libralist){
        libralist.getLibrarians().add(new librarian("pawanachai","seeruesang","L001","L001", Enum.Position.librarian));
        libralist.getLibrarians().add(new librarian("pawanachai","seeruesang","L002","L002", Enum.Position.librarian));
    }

    //==================================================================================================================//
    public void setUsers(ArrayList<User>users) { this.users=users;}
    public static void users2 (UserList users){
        users.getuser().add(new User("mart","Bubparn","U001","U001", Enum.Position.user));
    }
}
