package com.company.Human;

import com.company.Enum;
import com.company.Librarian.Librarian;
import com.company.Usergrouplease.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
            private ArrayList librarians = new ArrayList();
            public ArrayList<Librarian> getLibrarians() {
                return librarians;
            }
            public void setLibrarians(ArrayList<Librarian> librarians) {
                this.librarians = librarians;
            }


    //================================================================================================================//

    private ArrayList users = new ArrayList();
            public ArrayList<User> getUsers() {
                return users;
            }
            public void setUsers(ArrayList users) {
                this.users = users;
            }


    //==================================================================================================================//
    public static void librarian2 (UserList libralist){
        libralist.getLibrarians().add(new Librarian("pawanachai1","seeruesang","L001","L001", Enum.Position.librarian));
        libralist.getLibrarians().add(new Librarian("pawanachai2","seeruesang","L002","L002", Enum.Position.librarian));
    }

    //==================================================================================================================//
    public static void users2 (UserList users){
        users.getUsers().add(new User("mart","Bubparn","U001","U001", Enum.Position.user));
    }
}
