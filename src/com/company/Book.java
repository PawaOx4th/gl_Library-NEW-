package com.company;
import java.time.LocalDate;
import java.util.Objects;

class Book {
    //====================== Variable Section ========================//
    private String bookname,bookcode ;
    private Bookcategory bookcategory ;
    private Bookstatus bookstatus;
    private LocalDate bollow,returns ;
    //==============================================================//

    //=======================Constructor============================//

    public Book() {
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

    public Bookcategory getBookcategory() {
        return bookcategory;
    }

    public Bookstatus getBookstatus() {
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
}