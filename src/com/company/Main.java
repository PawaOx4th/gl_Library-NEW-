package com.company;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.*;
import java.time.LocalDate;

public class Main {

    public static Object Book;

    public static void main(String[] args) {

        //************************* Variable *************************//
        System.out.println("===========================");
        System.out.println("||                       ||");
        System.out.println("||   WelCome to Liberry  ||");
        System.out.println("||                       ||");
        System.out.println("===========================");
        Controller controller = new Controller() ;
        LocalDate date = LocalDate.now();
        Bookshelf books = new Bookshelf();
        Bookex bex = new Bookex();
        bex.setbooxEx(books.getBooks());
        controller.controller(books);

        //************************* Login Section *************************//




        //************************* Administrator Section *************************//
    }
}



