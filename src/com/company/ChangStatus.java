package com.company;

import java.util.Iterator;
import java.util.List;

public class ChangStatus {

    public static  void changStatus(String id, List<Book> books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookcode().equals(id)){
               Bookstatus chang = Bookstatus.valueOf("BUSY");
               book.setBookstatus(chang);
               System.out.println("BookStatus :"+book.getBookstatus());
            }
        }
    }
}
