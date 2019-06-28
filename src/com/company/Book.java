package com.company;
import java.time.LocalDate;
import java.util.Objects;

class Book {
    //====================== Variable Section ========================//
    private String bookname,bookcode ;
    private Bookcategory bookcategory ;
    private Bookstatus bookstatus;
    private LocalDate bollow,back ;
    //==============================================================//

    //=======================Constructor============================//

    public Book() {
    }

    public Book(String bookname){
        this.bookname = bookname;
    }

    public Book(String bookname,String bookcode,Bookcategory bookcategory){
        this.bookname = bookname;
        this.bookcode = bookcode;
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
    public Book(String bookname, String bookcode, Bookcategory bookcategory, Bookstatus bookstatus) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.bookcategory = bookcategory;
        this.bookstatus = bookstatus;
    }

    public Book(String bookname, String bookcode, Bookcategory bookcategory, Bookstatus bookstatus, LocalDate bollow) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.bookcategory = bookcategory;
        this.bookstatus = bookstatus;
        this.bollow = bollow;
    }

    public Book(String bookname, String bookcode, Bookcategory bookcategory, Bookstatus bookstatus, LocalDate bollow, LocalDate back) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.bookcategory = bookcategory;
        this.bookstatus = bookstatus;
        this.bollow = bollow;
        this.back = back;
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

    public void setBollow(LocalDate bollow) {
        this.bollow = bollow;
    }

    public void setBack(LocalDate back) {
        this.back = back;
    }

    //====================== Getter Section ========================//

    public String getBookname() {
        return bookname;
    }

    public String getBookcode() {
        return bookcode;
    }

    public Bookcategory getBookcategory() {
        return bookcategory;
    }

    public Bookstatus getBookstatus() {
        return bookstatus;
    }

    public LocalDate getBollow() {
        return bollow;
    }

    public LocalDate getBack() {
        return back;
    }



    //====================== To String Section ========================//
    @Override
    public String toString() {
        return "Book {" +
                "Book Name = " + bookname +
                " | Book Category = " + bookcategory +
                " | Book Code = " + bookcode +
                " | Book Status = "+bookstatus +
                " | Date = " +bollow +'}';
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