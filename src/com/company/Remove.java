package com.company;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Remove {
    public static void removebook(String id, List<Book> books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookcode().equals(id)){
                iterator.remove();
                System.out.println("Book code : [" +book.getBookcode()+ "] has been delete.");
            }
            else
            if (book.getBookcode().equalsIgnoreCase(id)){
                System.out.println("Sorry your book code is not exist");
            }

        }
    }
    public static  void  show (List<Book> books){
        System.out.println("=====================");
        System.out.println("this is book in list : ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        System.out.println("=====================");
    }

}
