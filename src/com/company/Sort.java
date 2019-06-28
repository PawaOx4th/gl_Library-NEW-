package com.company;

import java.util.*;

public class Sort {
    //************************* Sort by name  *************************//
        public static    Comparator<Book> comparatorname = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookname().toUpperCase();
            String BookN2 = o2.getBookname().toUpperCase();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************  Sort by Code *************************//
        public static  Comparator<Book> comparatorcode = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookcode().toUpperCase();
            String BookN2 = o2.getBookcode().toUpperCase();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************   *************************//
        public static Comparator<Book> comparatorCattegory = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookcategory().toString();
            String BookN2 = o2.getBookcategory().toString();
            return BookN1.compareTo(BookN2);
        }
    };
    //*************************  Sort by Status *************************//
        public static  Comparator<Book> comparatorstatus = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            String BookN1 = o1.getBookstatus().toString();
            String BookN2 = o2.getBookstatus().toString();
            return BookN1.compareTo(BookN2);
        }
    };
}