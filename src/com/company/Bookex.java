package com.company;
import java.time.LocalDate;
import java.util.*;

public class Bookex {


    public static void setbooxEx(List<Book>books){

        LocalDate date = LocalDate.now();
        books.add(new Book("Naruto","M001", Enum.Bookcategory.Manga, Enum.Bookstatus.BLANK));
        books.add(new Book("Boruto","M002", Enum.Bookcategory.Manga, Enum.Bookstatus.BLANK));
        books.add(new Book("Jojo","L001", Enum.Bookcategory.Love, Enum.Bookstatus.BLANK));
        books.add(new Book("MOON","H001", Enum.Bookcategory.Love, Enum.Bookstatus.BLANK));
        books.add(new Book("thairut","N001", Enum.Bookcategory.News, Enum.Bookstatus.BLANK));
        books.add(new Book("AAA","N01", Enum.Bookcategory.News, Enum.Bookstatus.BUSY,LocalDate.of(2019,01,01)));


    }
}
