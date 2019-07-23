package com.company.Librarian;

import com.company.Book.Book;
import com.company.Enum;
import com.company.History.History;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.*;
import static java.time.temporal.ChronoUnit.DAYS;

public class Admin_FunctionTest {

    @Test
    public void testComparatorName() {
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setBookname("b");
        book2.setBookname("a");
        List<Book> books = Arrays.asList(book1, book2);
        Collections.sort(books, Admin_Function.comparatorname);
        //=================================================================//
        Assert.assertEquals(books.size(), 2);
        Assert.assertEquals(books.get(0).getBookname(), "a");
        Assert.assertEquals(books.get(1).getBookname(), "b");
    }

    @Test
    public void testComparatorCatarory() {
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setBookcategory(Enum.Bookcategory.Manga);
        book2.setBookcategory(Enum.Bookcategory.Love);
        List<Book> books = Arrays.asList(book1, book2);
        Collections.sort(books, Admin_Function.comparatorCategory);
        //=================================================================//
        Assert.assertEquals(books.size(), 2);
        Assert.assertEquals(books.get(0).getBookcategory(), Enum.Bookcategory.Love);
        Assert.assertEquals(books.get(1).getBookcategory(), Enum.Bookcategory.Manga);
    }
    @Test
    public void addbook() {
        List<Book>books = new ArrayList<>();
        Book book_add = new Book();
        book_add.setBookname("true");
        book_add.setBookcode("M001");
        book_add.setBookcategory(Enum.Bookcategory.valueOf("Manga"));
        book_add.setBookstatus(Enum.Bookstatus.BLANK);
        books.add(book_add);
        //=================================================================//
        Assert.assertEquals(books.get(0).getBookname(),"true");
        Assert.assertEquals(books.get(0).getBookcode(),"M001");

    }

    @Test
    public void removebook() {
        List<Book>books = new ArrayList<>();
        Book book_add = new Book();
        book_add.setBookname("true");
        book_add.setBookcode("M001");
        book_add.setBookcategory(Enum.Bookcategory.valueOf("Manga"));
        book_add.setBookstatus(Enum.Bookstatus.BLANK);
        books.add(book_add);
        Iterator<Book> iterator = books.iterator();
        book_add = iterator.next();
        if(book_add.getBookcode().equals("M001")){
            iterator.remove();
        }
        Assert.assertEquals(books.size(), 0);

        //=================================================//

//        Assert.assertEquals(null, book_add);
//        Assert.assertNotNull(books);
    }

    @Test
    public void changDatereturn() {
        History history = new History();
        history.setBookname("test");
        history.setBookcode("M001");
        history.setBookcategory(Enum.Bookcategory.Manga);
        history.setDateborrow(LocalDate.now());
        history.setDatereturn(LocalDate.now().plusDays(7));
        history.setUserid("U001");
        history.setUser("kan");
        history.setBookstatus(Enum.Bookstatus.Not_Confirmed);
        List<History> historyList = Arrays.asList(history);
        for (History history1 : historyList) {
            if (history1.getBookcode().equals("M001")) {
                if (history1.getBookstatus().equals(Enum.Bookstatus.Not_Confirmed)) {
                    if (DAYS.between(history1.getDatereturn(), history1.getDatereturn().plusDays(3)) > 15) {
                        changDatereturn();
                    }
                    history1.setDatereturn(history1.getDatereturn().plusDays(3));
                }
            }
        }
        Assert.assertEquals(historyList.get(0).getDatereturn(),LocalDate.now().plusDays(10));
    }

    @Test
    public void perMits() {
        History history = new History();
        history.setBookname("teest");
        history.setBookcode("M001");
        history.setBookcategory(Enum.Bookcategory.Manga);
        history.setDateborrow(LocalDate.now());
        history.setDatereturn(LocalDate.now().plusDays(7));
        history.setUserid("U001");
        history.setUser("kan");
        history.setBookstatus(Enum.Bookstatus.Not_Confirmed);
        List<History> historyList = Arrays.asList(history);
            try {
                for (History history1 : historyList) {
                    if (history1.getBookcode().equalsIgnoreCase("M001") && history1.getBookstatus().equals(Enum.Bookstatus.Not_Confirmed))
                        history1.setBookstatus(Enum.Bookstatus.Confirm);
                }
            } catch (ConcurrentModificationException ignored) {
            }
            Assert.assertEquals(history.getBookstatus(), Enum.Bookstatus.Confirm);
            Assert.assertNotNull(history);

        }

    @Test
    public void returnbook() {



    }
}