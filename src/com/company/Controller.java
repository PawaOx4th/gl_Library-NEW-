package com.company;
import com.company.Book.Bookshelf;
import com.company.History.HistoryList;
import com.company.Human.UserList;
import com.company.Librarian.Login_librarian;
import com.company.Usergrouplease.User_main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    public static void controller(Bookshelf books, UserList userList, HistoryList history){

        boolean loop = true;
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1-Librarian\t\t"+"2-User");
        try {
            int ans_1 = pos.nextInt();
            if (ans_1 == 1) {
                Login_librarian.login_librarian(books,userList,history);
            }
            else {
                if (ans_1 == 2) {
                    User_main.login_user(books,userList,history);
                } else {
                    controller(books,userList,history);
                }
            }
        } catch (InputMismatchException e) {
                System.out.println("Sorry please connect again later");
                Controller.controller(books,userList,history);
        }
    }
}
