package com.company.Librarian;

import com.company.Book.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Admin_FunctionTest {

    @Test
    public void testComparatorName() {
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setBookname("b");
        book2.setBookname("a");

        List<Book> books = Arrays.asList(book1, book2);

        Collections.sort(books, Admin_Function.comparatorname);

        Assert.assertEquals(books.size(), 2);
        Assert.assertEquals(books.get(0).getBookname(), "a");
        Assert.assertEquals(books.get(1).getBookname(), "b");
    }
}