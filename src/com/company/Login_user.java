package com.company;

import java.util.Scanner;

public class Login_user {

    public static void login_user(Bookshelf Book, UserList userList){
        UserList librarians = new UserList() ;
        UserList.librarian2(librarians);
        UserList user = new UserList();
        UserList.users2(user);
//        History history1 = new History();
//        history.getHistorylist(history1);
        System.out.print("ID : ");
        Scanner ID =new Scanner(System.in);
        String id = ID.nextLine();
        System.out.print("PS : ");
        Scanner PS =new Scanner(System.in);
        String ps = PS.nextLine();

        //************************* Add Component *************************//
        while(true) {
            System.out.println("\nWhat  do you want to do");
            System.out.println("1 - Search\n2 - Check\n3 - Rental\n4 - Return\n5-Exit");
            Scanner want = new Scanner(System.in);
            int ans_2 = want.nextInt();
            switch (ans_2) {
                case 1:
                    System.out.println("Please select function.");
                    System.out.println("[1-Search by Code]\t[2-Search by Name]\t[3-Search by Category]\t[4-Search by Status]");
                    Scanner usearch = new Scanner(System.in);
                    int Usearch = usearch.nextInt();
                    switch (Usearch){
                        case 1 :    User_Function.searchBookid(Book);           break;
                        case 2 :    User_Function.searchBookname(Book);        break;
                        case 3 :    User_Function.searchBookcatagory(Book);    break;
                        case 4 :    User_Function.searchBookstatus(Book);       break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
            }
        }
    }
}