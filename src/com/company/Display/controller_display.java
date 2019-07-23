package com.company.Display;

import java.util.Scanner;

public class controller_display {



    public static void controller_message(){
        System.out.println("Sorry please connect again later"); //**User parameter Int**
    }

    public static Scanner inputPosition(){
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1-Librarian\t\t" + "2-User");
        return pos ;
    }
}
