package com.company.History;

import com.company.Enum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class History {

    private String bookname,bookcode,user,userid;
    private Enum.Bookstatus bookstatus;
    private Enum.Bookcategory bookcategory;
    private LocalDate dateborrow;
    private LocalDate datereturn;



    //========================= Constructer ===============================//


    public History() {
    }

    public History(String bookname, String bookcode, String user, String userid, Enum.Bookstatus bookstatus, Enum.Bookcategory bookcategory, LocalDate dateborrow, LocalDate datereturn) {
        this.bookname = bookname;
        this.bookcode = bookcode;
        this.user = user;
        this.userid = userid;
        this.bookstatus = bookstatus;
        this.bookcategory = bookcategory;
        this.dateborrow = dateborrow;
        this.datereturn = datereturn;
    }

    //======================== Getter =====================================//

    public String getBookname() {
        return bookname;
    }

    public String getBookcode() {
        return bookcode;
    }

    public String getUser() {
        return user;
    }

    public String getUserid() {
        return userid;
    }

    public Enum.Bookstatus getBookstatus() {
        return bookstatus;
    }

    public Enum.Bookcategory getBookcategory() {
        return bookcategory;
    }

    public LocalDate getDateborrow() {
        return dateborrow;
    }

    public LocalDate getDatereturn() {
        return datereturn;
    }
//=======================================Setter =============================//

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setBookstatus(Enum.Bookstatus bookstatus) {
        this.bookstatus = bookstatus;
    }

    public void setBookcategory(Enum.Bookcategory bookcategory) {
        this.bookcategory = bookcategory;
    }

    public void setDateborrow(LocalDate dateborrow) {
        this.dateborrow = dateborrow;
    }

    public void setDatereturn(LocalDate datereturn) {
        this.datereturn = datereturn;
    }
//======================== History List ============================//

    private List<History> histories = new ArrayList<>();

    public List<History> getHistories() {   return histories; }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public static void HistoryList(History histories){
        histories.getHistories().add(new History("Threesome","L999","Pawanachai","",
                Enum.Bookstatus.BUSY,Enum.Bookcategory.Love,LocalDate.of(2019,7,1),LocalDate.now()));
    }


    //========================= to String ===========================//
    @Override
    public String toString() {
        return "History{" +
                "bookname='" + bookname + '\'' +
                ", bookcode='" + bookcode + '\'' +
                ", user='" + user + '\'' +
                ", userid='" + userid + '\'' +
                ", bookstatus=" + bookstatus +
                ", bookcategory=" + bookcategory +
                ", dateborrow=" + dateborrow +
                ", datereturn =" + datereturn +
                '}';
    }
}
