package com.company.Display;

import com.company.Human.UserList;
import com.company.Service.Libraryservice;
import com.company.Usergrouplease.User;

import java.util.Scanner;

public class user_Display {

    public static String[] user_login(){
        UserList userList = new UserList();
        UserList.users2(userList);

        System.out.print("ID : ");
        Scanner ID =new Scanner(System.in);
        String id = ID.nextLine();

        System.out.print("PS : ");
        Scanner PS =new Scanner(System.in);
        String ps = PS.nextLine();

        return  new String[]{id,ps};
    }

    public static User CheckInput(){
        Libraryservice libraryservice = Libraryservice.getInstance();
        String[] account = librarian_display.library_login();
        User userlogin = null;
        for (User user  : libraryservice.getUserList().getUsers()){
            if (account[0].equalsIgnoreCase(user.getId()) &&
                    account[1].equalsIgnoreCase(user.getPassword())){
                userlogin = user;
            }
        }
        return  userlogin;
    }

    public static int userManu(){
        Libraryservice libraryservice = Libraryservice.getInstance();  //setUser
        Scanner scanner = new Scanner(System.in);
//        System.out.println(""+libraryservice.getUser().getName()+" "+libraryservice.getUser().getSername());
        System.out.println("\nWhat  do you want to do");
        System.out.println("[1-Search]\t[2-Check]\t[3-Rental]\t" +
                "[4-Return]\t[5-History]\t[6-Exit]");
        int ans_2 = scanner.nextInt();
        return ans_2;
    }

    public static int u_seachfunction(){
        System.out.println("[1-Search by Code]\t[2-Search by Name]\t[3-Search by Category]\t" +
                "[4-Search by Status]");
        System.out.print("Please select function.");
        Scanner usearch = new Scanner(System.in);
        int Usearch = usearch.nextInt();
        return Usearch;
    }
}
