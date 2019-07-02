package com.company;

import java.time.LocalDate;


public class Book_Permits extends Book {

    private LocalDate datebowlow ;
    private LocalDate datereturn ;

    public static void main(String[] args) {

        permits();

    }
    public static  void permits(){
        Book book = new Book();
        var LocalDate = java.time.LocalDate.now();
        book.setBollow(LocalDate.now());
    }
}



