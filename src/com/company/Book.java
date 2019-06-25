package com.company;

import java.util.Date;
import java.util.Objects;

class Book {
    //====================== Variable Section ========================//
    public String bookname,bookcategory,bookcode,bookstatus;
    public Date rent,back;


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
    public Book(String bookname, String bookcategory, String bookcode, String bookstatus) {
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookcode = bookcode;
        this.bookstatus = bookstatus;
    }

    //====================== To String Section ========================//
    @Override
    public String toString() {
        return "Book {" +
                "Book Name = " + bookname +
                " | Book Category = " + bookcategory +
                " | Book Code = " + bookcode + '}';
    }
    //====================== Equal Section ========================//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookcode, book.bookcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookcode);
    }
}
