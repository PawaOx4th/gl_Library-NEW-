package com.company;

import java.util.Iterator;
import java.util.List;

public class Search {
    //************************* Search by Code *************************//
    public static void searchBookname(String nameS, List<Book> books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookname().equals(nameS)){
                System.out.println("==========================");
                System.out.println("Book Name   : " +book.getBookname());
                System.out.println("Book Type   : " +book.getBookcategory());
                System.out.println("Book Code   : " +book.getBookcode());
                System.out.println("Book Bookstatus :"+book.getBookstatus());
                System.out.println("Date : "+book.getBollow());
                System.out.println("==========================");
            }
            else
            if (book.getBookname().equalsIgnoreCase(nameS)){
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }
    public static void searchBookid(String id, List<Book> books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookcode().equals(id)){
                System.out.println("==========================");
                System.out.println("Book Name   : " +book.getBookname());
                System.out.println("Book Type   : " +book.getBookcategory());
                System.out.println("Book Code   : " +book.getBookcode());
                System.out.println("Book Bookstatus :"+book.getBookstatus());

//                    System.out.println("Book Status : Exist");
                System.out.println("==========================");
            }
            else
            if (book.getBookcode().equalsIgnoreCase(id)){
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }
    public static void searchBookcatagory(Bookcategory id, List<Book> books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookcategory().equals(id)){
                System.out.println("==========================");
                System.out.println("Book Name   : " +book.getBookname());
                System.out.println("Book Type   : " +book.getBookcategory());
                System.out.println("Book Code   : " +book.getBookcode());
                System.out.println("Book Bookstatus :"+book.getBookstatus());
                System.out.println("==========================");
            }
            else
            if (book.getBookcategory().equals(id)){
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }
    public static void searchBookstatus(Bookstatus statusS, List<Book> books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookstatus().equals(statusS)){
                System.out.println("==========================");
                System.out.println("Book Name   : " +book.getBookname());
                System.out.println("Book Type   : " +book.getBookcategory());
                System.out.println("Book Code   : " +book.getBookcode());
                System.out.println("Book Bookstatus :"+book.getBookstatus());
                System.out.println("==========================");
            }
            else
            if (book.getBookstatus().equals(statusS)){
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
            }
        }
    }


}
