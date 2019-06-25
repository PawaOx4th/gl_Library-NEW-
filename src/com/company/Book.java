package com.company;

import java.util.Objects;

class Book {
    public String bookname;
    public String bookcategory;
    public String bookcode;

    //====================== Getter Section ========================//
    public String getBookname() {
        return bookname;
    }

    public String getBookcategory() {
        return bookcategory;
    }

    public String getBookcode() {
        return bookcode;
    }

    public Book(){

    }
    //====================== Constructor Section ========================//
    public Book(String bookname){
        this.bookname = bookname;
    }

    public Book(String bookname,String bookcategory){
        this.bookname = bookname;
        this.bookcategory = bookcategory;
    }

    public Book(String bookname,String bookcategory,String bookcode){
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookcode = bookcode;
    }


    //====================== To String Section ========================//
    @Override
    public String toString() {
        return "Book {" +
                "Book Name = " + bookname +
                " | Book Category = " + bookcategory +
                " | Book Code = " + bookcode + '}';
    }
}
