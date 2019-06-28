package com.company;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

class Book {
    //====================== Variable Section ========================//
    private String bookname,bookcode ;

    private Bookcategory bookcategory ;
    private Bookstatus bookstatus;
    private LocalDate rent,back;
    //=======================Constructor============================//
    public Book(String bookname, String bookcode, Bookcategory bookcategory, Bookstatus bookstatus) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.bookcategory = bookcategory;
        this.bookstatus = bookstatus;
    }
    //=======================SetBookStatus============================//
    public void setBookstatus(Bookstatus bookstatus) {
        this.bookstatus = bookstatus;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public void setBookcategory(Bookcategory bookcategory) {
        this.bookcategory = bookcategory;
    }

    public void setRent(LocalDate rent) {
        this.rent = rent;
    }

    public void setBack(LocalDate back) {
        this.back = back;
    }



    //====================== Getter Section ========================//
    public String getBookname() {
        return bookname;
    }

    public Bookcategory getBookcategory() {
        return bookcategory;
    }

    public String getBookcode() {
        return bookcode;
    }

    public Book(){
    }

    public Bookstatus getBookstatus() {
        return bookstatus;
    }

    //====================== Constructor Section ========================//
    public Book(String bookname){
        this.bookname = bookname;
    }

    public Book(String bookname,Bookcategory bookcategory){
        this.bookname = bookname;
        this.bookcategory = bookcategory;
    }

    public Book(String bookname,Bookcategory bookcategory,String bookcode){
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookcode = bookcode;
    }
    public Book(String bookname, Bookcategory bookcategory, String bookcode, String bookstatus) {
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookcode = bookcode;
//        this.bookstatus = bookstatus;
    }

    //====================== To String Section ========================//
    @Override
    public String toString() {
        return "Book {" +
                "Book Name = " + bookname +
                " | Book Category = " + bookcategory +
                " | Book Code = " + bookcode +
                " | Book Status = "+bookstatus +'}';
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