package com.company.Bbook;
import com.company.Enum;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    //====================== Variable Section ========================//
    protected String bookname,bookcode ;
    protected Enum.Bookcategory bookcategory ;
    protected Enum.Bookstatus bookstatus;
    protected LocalDate bollow,returns ;
    //==============================================================//

    //=======================Constructor============================//

    public Book() {
    }

    public Book(String bookname, String bookcode, Enum.Bookcategory bookcategory, Enum.Bookstatus bookstatus) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.bookcategory = bookcategory;
        this.bookstatus = bookstatus;
    }

    public Book(String bookname, String bookcode, Enum.Bookcategory bookcategory, Enum.Bookstatus bookstatus, LocalDate bollow) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.bookcategory = bookcategory;
        this.bookstatus = bookstatus;
        this.bollow = bollow;
    }

    public Book(String bookname, String bookcode, Enum.Bookcategory bookcategory, Enum.Bookstatus bookstatus, LocalDate bollow, LocalDate returns) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.bookcategory = bookcategory;
        this.bookstatus = bookstatus;
        this.bollow = bollow;
        this.returns = returns;
    }

    //=======================SetBookStatus============================//
    public void setBookstatus(Enum.Bookstatus bookstatus) {
        this.bookstatus = bookstatus;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public void setBookcategory(Enum.Bookcategory bookcategory) {
        this.bookcategory = bookcategory;
    }

    public void setBollow(LocalDate bollow) {
        this.bollow = LocalDate.now();
    }

    public void setReturns(LocalDate returns) {
        this.returns = returns;
    }

//====================== Getter Section ========================//

    public String getBookname() {
        return bookname;
    }

    public String getBookcode() {
        return bookcode;
    }

    public Enum.Bookcategory getBookcategory() {
        return bookcategory;
    }

    public Enum.Bookstatus getBookstatus() {
        return bookstatus;
    }

    public LocalDate getBollow() {
//        LocalDate bollow = LocalDate.now() ;
        return bollow;
    }

    public LocalDate getReturns() {
        return returns;
    }

    //====================== To String Section ========================//
    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", bookcode='" + bookcode + '\'' +
                ", bookcategory=" + bookcategory +
                ", bookstatus=" + bookstatus +
                ", bollow=" + bollow +
                ", returns=" + returns +
                '}';
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

    public void setBollow(String dd_llll_yyyy) {
    }
}