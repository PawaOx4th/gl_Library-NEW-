package com.company.History;

import com.company.Enum;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    public String HistoriesString;
    private List<History> histories = new ArrayList<>();

    public void HistoryList(){

    }
    public static void HistoryList(String bookname, String bookcode, String name, String id, Enum.Bookstatus bookstatus, Enum.Bookcategory bookcategory, LocalDate now, LocalDate plusDays) {
    }

    public static void HistoryList(String bookname, String bookcode, String name, String id, Enum.Bookstatus bookstatus, Enum.Bookcategory bookcategory, LocalDate now) {
    }


    public HistoryList() {
        this.histories = histories;
    }

    public List<History> getHistories() {   return histories; }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public static void HistoryList(HistoryList histories){

        histories.getHistories().add(new History("testHisbook","M004","kan","U002",Enum.Bookstatus.Confirm,
                Enum.Bookcategory.Manga,LocalDate.now().minusDays(11),LocalDate.now().minusDays(1)));
}
}
