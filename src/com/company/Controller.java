package com.company;
import com.company.Bbook.Book;
import com.company.History.History;
import com.company.History.HistoryList;
import com.company.Human.UserList;
import com.company.Librarian.Login_librarian;
import com.company.Usergrouplease.User_main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void controller(Bookshelf books, UserList userList, HistoryList history){

        UserList librarians = new UserList() ;
        UserList.librarian2(librarians);
        boolean loop = true;
        Scanner want = new Scanner(System.in);
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1-Librarian\t\t"+"2-User");
        int ans_1 = pos.nextInt();
        if (ans_1 == 1) {
            var Login_librarain = new Login_librarian();
            Login_librarian.login_librarian(books,userList,history);
            }
             else {
            if (ans_1 == 2) {
             var Login_user = new User_main() ;
             Login_user.login_user(books,userList,history);
            } else {
                System.out.println("Sorry please connect again later");
            }
        }
    }

    public static class Bookshelf {

        private List<Book> books = new ArrayList<>();
        public List<Book> getBooks() { return books; }
        public void setBooks(List<Book> books) {
            this.books = books;
        }
    }
}
