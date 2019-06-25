package com.company;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Iterator;
import java.util.*;

public class Main {

    private static Object Book;

    public static void main(String[] args) {
	//************************* Login Section *************************//
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1 - Administrator");
        System.out.println("2 - Employee");
        int ans_1 = pos.nextInt();
        if (ans_1 == 1){
            //************************* Administrator Section *************************//
            boolean loop = true;
            Scanner  want = new Scanner(System.in);
            //************************* Add Component *************************//
            List<Book> books = new ArrayList<>();
            do {
                System.out.println("\nWhat  do you want to do");
                System.out.println("1 - Add Book\t2 - Delete Book\t3 - Search\n" +
                        "4 - Check\t\t5 - Sort\t\t6 - Approve\n7 - Accept\t\t8 - Exit");
                int ans_2 = want.nextInt();
                switch (ans_2) {
                    //************************* Add Section *************************//
                    case 1:
                        Book book_add = new Book();
                        Scanner sb1 = new Scanner(System.in);
                        System.out.print("Please enter book name : ");
                        String bName = sb1.nextLine();
                        System.out.println("Book name : " + bName);
                        Scanner sb2 = new Scanner(System.in);
                        System.out.print("Please enter book category : ");
                        String bCat = sb1.nextLine();
                        System.out.println("Book name : " + bCat);
                        Scanner sb3 = new Scanner(System.in);
                        System.out.print("Please enter book code : ");
                        String bCode = sb1.nextLine();
                        System.out.println("Book name : " + bCode);

                        book_add.bookname = bName;
                        book_add.bookcategory = bCat;
                        book_add.bookcode = bCode;
                        book_add.bookstatus = "Exist";
                        books.add(book_add);

                        for (int i = 0; i < books.size(); i++) {
                            System.out.println(books.get(i));
                        }
                        break;
                    case 2:
                        //************************* Remove Section *************************//
                        Scanner dc = new Scanner(System.in);
                        System.out.println("\nPlease insert Book code to delete : ");
                        String id = dc.nextLine();
                        deletebook(id,books);

                        System.out.println("this is book in list : ");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println(books.get(i));
                        }
//                        Scanner dc = new Scanner(System.in);
//                        System.out.println("\nPlease insert Book code to delete : ");
//                        int re = dc.nextInt();
//                        for (Book book_del : books) {
//                            if (book_del.bookcode.equals(re)) {
//                                books.remove(book_del);
//                            }
//                        }
//                        for (int j=0 ; j < books.size() ; j++){
//                            System.out.println(books.get(j));
//                        }
                        break;
                    case 3:
                        //************************* Search Section *************************//
                        Scanner sh = new Scanner(System.in);
                        System.out.println("Please enter book code : ");
                        String id2 = sh.nextLine();
                        searchBook(id2,books);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        //************************* Terminate Section *************************//
                        System.out.println("Thank you");
                        loop = false;
                }
            }
        while (loop);
        }
        else
            if (ans_1 == 2){
                //************************* Employee Section *************************//
            }
            else {
                System.out.println("Sorry please connect again later");
            }
    }
    //************************* Search Component *************************//
    public static void searchBook(String id,List<Book>books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookcode().equals(id)){
                System.out.println("==========================");
                System.out.println("Book Name : " +book.bookname);
                System.out.println("Book Type : " +book.bookcategory);
                System.out.println("Book Code : " +book.bookcode);
                System.out.println("==========================");
            }
            else
                System.out.println("'Sorry your book is not exist to my Grouplease Library");
        }
    }
    //************************* Remove Component *************************//
    public static void deletebook(String id,List<Book> books){
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getBookcode().equals(id)){
                iterator.remove();
                System.out.println("Book code : ["+book.bookcode+ "] has been delete.");
            }
            else
                System.out.println("Sorry your book code is not exist");
        }
    }
}


