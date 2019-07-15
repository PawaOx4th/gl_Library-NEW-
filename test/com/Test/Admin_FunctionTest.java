package com.Test;

import com.company.Book.Book;
import com.company.Enum;
import com.company.Service.Libraryservice;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Scanner;

public class Admin_FunctionTest {

    @Test
    public void testSearchBookname() {
        Comparator<Book> comparatorname = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                String BookN1 = o1.getBookname().toUpperCase();
                String BookN2 = o2.getBookname().toUpperCase();
                return BookN1.compareTo(BookN2);
            }

        };
    }

    @Test
    public void testPrintOut() {
    }

    @Test
    public void testShowHistory() {
    }

    @Test
    public void testAddbook() {
            Libraryservice libraryservice = Libraryservice.getInstance();
            System.out.println("======================");
            Book book_add = new Book();
            Scanner sb1 = new Scanner(System.in);
            System.out.print("Please enter book name : ");
            String bName = sb1.nextLine();
            System.out.println("Book name : " + bName);
            Scanner sb2 = new Scanner(System.in);
            Scanner sb4 = new Scanner(System.in);
            System.out.print("Please enter book category : ");
            String bCat = sb1.nextLine();
            Enum.Bookcategory category = Enum.Bookcategory.valueOf(bCat);
            System.out.println("Book name : " + bCat);
            //===================== Generate bookcode ===================//
            Integer runningNo = null;
            String genbook = Enum.Bookcategory.valueOf(bCat).getCode();
            DecimalFormat decimalFormat = new DecimalFormat("000");
            for (Book b : libraryservice.getBooks().getBooks()) {
                if (genbook.equals(b.getBookcode().substring(0, 1))) {
                    if (runningNo == null || runningNo < Integer.parseInt(b.getBookcode().substring(1))) {
                        runningNo = Integer.parseInt(b.getBookcode().substring(1));
                    }
                }
            }
            int number = runningNo + 1;
            String bCode = genbook + decimalFormat.format(number);

            //------------------------------------------------------------//
            book_add.setBookname(bName);
            book_add.setBookcode(bCode);
            book_add.setBookcategory(Enum.Bookcategory.valueOf(bCat));
            book_add.setBookstatus(Enum.Bookstatus.BLANK);
            libraryservice.getBooks().getBooks().add(book_add);

            //============================ Show Book Add =============================//
            for (int i = 0; i < libraryservice.getBooks().getBooks().size(); i++) {
                System.out.println(libraryservice.getBooks().getBooks().get(i));
            }

    }

    @Test
    public void testRemovebook() {
    }

    @Test
    public void testShow() {

        Libraryservice libraryservice = Libraryservice.getInstance();
        System.out.println("=====================");
        System.out.println("this is book in list : ");
        for (int i = 0; i < libraryservice.getBooks().getBooks().size(); i++) {
            System.out.println(libraryservice.getBooks().getBooks().get(i));
        }
        System.out.println("=====================");
    }

    @Test
    public void testSearchBookname1() {
    }

    @Test
    public void testSearchBookid() {
    }

    @Test
    public void testSearchBookcatagory() {
    }

    @Test
    public void testSearchBookstatus() {
    }

    @Test
    public void testChangDatereturn() {
    }

    @Test
    public void testPermits() {
    }

    @Test
    public void testReturnbook() {
    }
}