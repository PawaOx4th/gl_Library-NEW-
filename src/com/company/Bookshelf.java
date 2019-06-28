package com.company;
import java.util.*;
import java.util.ArrayList;

public class Bookshelf {

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
