package com.company;

import com.company.History.History;

import java.util.Scanner;

public class Login_librarian {

    public static void login_librarian(Controller.Bookshelf books, UserList userList, History history){
//        Bookshelf books = new Bookshelf() ;
        UserList librarians = new UserList() ;
        UserList.librarian2(librarians);
        System.out.print("ID : ");
        Scanner ID =new Scanner(System.in);
        String id = ID.nextLine();
        System.out.print("PS : ");
        Scanner PS =new Scanner(System.in);
        String ps = PS.nextLine();
        for (librarian librarian : librarians.getLibrarians()) {
            if (id.equals(librarian.getId())&& ps.equals(librarian.getPassword())) {
                while (true) {
                    System.out.println("\nWhat  do you want to do");
                    System.out.println("1 - Add Book\t2 - Delete Book\t3 - Search\n" +
                            "4 - Check\t\t5 - Sort\t\t6 - Permits\n7 - Return\t\t8 - History\t\t9 - History");
                    Scanner want = new Scanner(System.in);
                    int ans_2 = want.nextInt();
                    switch (ans_2) {
                        case 1:
                            //************************* Add Section *************************//
                            Admin_Function.Addbook(books);
                            break;
                        case 2:
                            //************************* Remove Section *************************//
                            Admin_Function.removebook(books);
                            Admin_Function.show(books);
                            break;
                        case 3:
                            //************************* Search Section *************************//
                            System.out.println("Please Select Search :");
                            System.out.println("1 - Search by name\t2 - Search by Code\t" +
                                    "3 - Search by Cattegory \t4 - Search by Status   ");
                            Scanner sh = new Scanner(System.in);
                            int Searchf = sh.nextInt();
                            switch (Searchf) {
                                case 1:
//                                    Admin_Function.searchBookname(books.getBooks());
                                    Admin_Function.searchBookname(books);
                                    break;
                                case 2:
                                    Admin_Function Scode = new Admin_Function();
                                    Admin_Function.searchBookid(books);
                                    break;
                                case 3:
                                    Admin_Function.searchBookcatagory(books);
                                    break;
                                case 4:
                                    Admin_Function Sstatus = new Admin_Function();
                                    Admin_Function.searchBookstatus(books);
                                    break;
                            }
                            break;
                        case 4:
                            //*************************  ChangStatus *************************//

                            Admin_Function.changDatereturn(books,userList,history);
                            break;
                        case 5:
                            //*************************  Sort Book *************************//
                            Scanner sort = new Scanner(System.in);
                            System.out.println("Please input choice for Sort book ");
                            System.out.println("1 - Sort by name\t2 - Sort by Code\t" +
                                    "3 - Sort by Cattegory \t4 - Sort by Status   ");
                            int SortFx = sort.nextInt();
                            switch (SortFx) {
                                case 1:
                                    books.getBooks().sort(Admin_Function.comparatorname);  //coloections.sort('List Book),'Class'.'Comparator object'
                                    for (Book book : books.getBooks()) {
                                        System.out.println(book);
                                    }
                                    break;
                                case 2:
                                    books.getBooks().sort(Admin_Function.comparatorcode);  //coloections.sort('List Book),'Class'.'Comparator object'
                                    for (Book book : books.getBooks()) {
                                        System.out.println(book);
                                    }
                                    break;
                                case 3:
                                    books.getBooks().sort(Admin_Function.comparatorCattegory);  //coloections.sort('List Book),'Class'.'Comparator object'
                                    for (Book book : books.getBooks()) {
                                        System.out.println(book);
                                    }
                                    break;
                                case 4:
                                    books.getBooks().sort(Admin_Function.comparatorstatus);  //coloections.sort('List Book),'Class'.'Comparator object'
                                    for (Book book : books.getBooks()) {
                                        System.out.println(book);
                                    }
                                    break;
                            }
                            break;
                        case 6:
                            //*************************  Permit  *************************//
                            Admin_Function.permits(books);
                        case 7:
                            Admin_Function.returnbook(books);
                            break;
                        case 8:
                            for (int i = 0; i < history.getHistories().size(); i++) {
                                System.out.println(history.getHistories().get(i));
                            }
                            break;
                        case 9 :
                            //************************* Terminate Section *************************//
                            Controller.controller(books,userList,history);
                            System.out.println("Thank you");
                            System.exit(0);
                            break;

                    }
                }
            }
            else {
                System.out.println("h");
            }
        }
    }
}
