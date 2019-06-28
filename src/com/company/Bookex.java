package com.company;
import java.util.*;

public class Bookex {


    public static void setbooxEx(List<Book>books){

        books.add(new Book("Naruto","M001",Bookcategory.Manga,Bookstatus.BLANK));
        books.add(new Book("Boruto","M002",Bookcategory.Manga,Bookstatus.BLANK));
        books.add(new Book("K<3M","L001",Bookcategory.Love,Bookstatus.BLANK));
        books.add(new Book("THAPA","H001",Bookcategory.Love,Bookstatus.BLANK));
        books.add(new Book("thairut","N001",Bookcategory.News,Bookstatus.BLANK));


    }
}
