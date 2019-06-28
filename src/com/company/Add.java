package com.company;

import java.util.List;
import java.util.Scanner;

public class Add {
    public static void Addbook(List<Book>books){

        System.out.println("=====================");
        Book book_add = new Book();

        Scanner sb1 = new Scanner(System.in);
        System.out.print("Please enter book name : ");
        String bName = sb1.nextLine();
        System.out.println("Book name : " + bName);

        Scanner sb2 = new Scanner(System.in);
        System.out.print("Please enter book code : ");
        String bCode = sb1.nextLine();
        System.out.println("Book name : " + bCode);

        Scanner sb4 = new Scanner(System.in);
        System.out.print("Please enter book category : ");
        String bCat = sb1.nextLine();
        Bookcategory category = Bookcategory.valueOf(bCat);
        System.out.println("Book name : " + bCat);



        book_add.setBookname(bName);
        book_add.setBookcode(bCode);
        book_add.setBookcategory(Bookcategory.valueOf(bCat));
        book_add.setBookstatus(Bookstatus.BLANK);

        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        System.out.println("=====================");
    }
}
