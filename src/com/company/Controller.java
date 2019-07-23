package com.company;
import com.company.Display.controller_display;
import com.company.Librarian.Login_librarian;
import com.company.Users.User_main;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Controller {
    public static void controller() {
        try {
            int ans_1 = inputPosition().nextInt();
            if (ans_1 == 1) {
                Login_librarian.login_librarian();
            } else {
                if (ans_1 == 2) {
                    User_main.login_user();
                } else {
//                    System.out.println("Sorry please connect again later");
//                    **User parameter Int**
                    controller_display.controller_message();
                    controller();
                }
            }
        } catch (InputMismatchException e) {
            //**User parameter String **
            controller_display.controller_message();
            Controller.controller();
        }
    }

    public static Scanner inputPosition() {
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1-Librarian\t\t" + "2-User");
        return pos;
    }
}
