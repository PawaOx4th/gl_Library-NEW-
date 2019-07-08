package com.company.Human;

import com.company.Enum;
import com.company.Librarian.librarian;
import com.company.Usergrouplease.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private ArrayList librarians = new ArrayList();
    public ArrayList<librarian> getLibrarians() {
        return librarians;
    }
    private List users = new ArrayList();

    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    //==================================================================================================================//
    public void setLibrarians(ArrayList<librarian> librarians) {
        this.librarians = librarians;
    }
    public static void librarian2 (UserList libralist){
        libralist.getLibrarians().add(new librarian("pawanachai","seeruesang","L001","L001", Enum.Position.librarian));
        libralist.getLibrarians().add(new librarian("pawanachai","seeruesang","L002","L002", Enum.Position.librarian));
    }

    //==================================================================================================================//
    public static void users2 (UserList users){
        users.getUsers().add(new User("mart","Bubparn","U001","U001", Enum.Position.user));
    }
}
