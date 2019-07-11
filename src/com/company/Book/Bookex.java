package com.company.Book;
import com.company.Enum;

import java.time.LocalDate;
import java.util.*;

public class Bookex {


    public static void setbooxEx(Bookshelf books){

        LocalDate date = LocalDate.now();
        books.getBooks().add(new Book("Naruto","M001", Enum.Bookcategory.Manga, Enum.Bookstatus.BLANK,LocalDate.now()));
        books.getBooks().add(new Book("Boruto","M002", Enum.Bookcategory.Manga, Enum.Bookstatus.BLANK));
        books.getBooks().add(new Book("Jojo","L001", Enum.Bookcategory.Love, Enum.Bookstatus.BLANK));
        books.getBooks().add(new Book("MOON","H001", Enum.Bookcategory.Love, Enum.Bookstatus.BLANK));
        books.getBooks().add(new Book("thairut","N001", Enum.Bookcategory.News, Enum.Bookstatus.BLANK));
        books.getBooks().add(new Book("AAA","N01", Enum.Bookcategory.News, Enum.Bookstatus.BUSY,LocalDate.now(),LocalDate.now().plusDays(7)));


    }
}
