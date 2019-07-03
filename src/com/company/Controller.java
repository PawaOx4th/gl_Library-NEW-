package com.company;
import java.util.Scanner;

public class Controller {
    public static void controller(Bookshelf books,UserList userList){

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
            Login_librarian.login_librarian(books,userList);
            }
             else {
            if (ans_1 == 2) {
             var Login_user = new Login_user() ;
             Login_user.login_user(books,userList);
            } else {
                System.out.println("Sorry please connect again later");
            }
        }
    }
}
