package com.company;
import java.time.LocalDate;
import java.util.*;

public class Bookex {


    public static void setbooxEx(List<Book>books){

        LocalDate date = LocalDate.now();
//        books.add(new Book("Naruto","M001",Bookcategory.Manga,Bookstatus.BLANK));
//        books.add(new Book("Boruto","M002",Bookcategory.Manga,Bookstatus.BLANK));
//        books.add(new Book("K<3M","L001",Bookcategory.Love,Bookstatus.BLANK));
//        books.add(new Book("THAPA","H001",Bookcategory.Love,Bookstatus.BLANK));
        books.add(new Book("thairut","N001",Bookcategory.News,Bookstatus.BLANK,date));

//        books.add(new Book("","N001",Bookcategory.News,Bookstatus.BLANK,LocalDate.of(2562,06,28)));


    }
}
