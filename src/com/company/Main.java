package com.company;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;
import java.time.LocalDate;

public class Main {

    public static Object Book;

    public static void main(String[] args) {

        //************************* Variable *************************//
        Controller controller = new Controller() ;
        LocalDate date = LocalDate.now();
        Bookshelf books = new Bookshelf();
        Bookex bex = new Bookex();
        bex.setbooxEx(books.getBooks());

        //************************* Login Section *************************//
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1 - Administrator");
        System.out.println("2 - Employee");
        int ans_1 = pos.nextInt();
        controller.controller(ans_1,books);

        //************************* Administrator Section *************************//
    }
}



