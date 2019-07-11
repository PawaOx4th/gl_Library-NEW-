package com.company.Usergrouplease;

import com.company.Book.Book;
import com.company.Book.Bookshelf;
import com.company.Controller;
import com.company.Display.librarian_display;
import com.company.Display.user_Display;
import com.company.History.HistoryList;
import com.company.Human.UserList;
import com.company.Service.Libraryservice;

import java.util.InputMismatchException;

public class User_main {
    public static void login_user(Bookshelf books, UserList userList, HistoryList history) {
        Libraryservice libraryservice = Libraryservice.getInstance();
        User loginUser = user_Display.CheckInput();
        if (loginUser != null) {
            libraryservice.setUser(loginUser);                              //importUser from Libreryservice
            login_user2();
            Controller.controller(books,userList,history);
        } else {
        }
    }
    public static void login_user2() {
        try {
            boolean ifCheck = true;
            while (ifCheck) {
                int ans_2 = user_Display.userManu();                        //Display Manu User [use_Display]
                switch (ans_2) {
                    case 1:
                        int Usearch = user_Display.u_seachfunction();       //Display Seach Function [use_Display]
                        switch (Usearch) {
                            case 1:
                                User_Function.seachBookcode();
                                break;
                            case 2:
                                User_Function.searchBookname();
                                break;
                            case 3:
                                User_Function.searchBookcatagory();
                                break;
                            case 4:
                                User_Function.searchBookstatus();
                                break;
                        }
                        break;
                    case 2:
                        User_Function.changDatereturn();
                        break;
                    case 3:
                        User_Function.rentalbook();
                        break;
                    case 4:
                        User_Function.returnbook();
                        break;
                    case 5:
                        User_Function.printHistory();
                        break;
                    case 6:
                        librarian_display.library_login();
                        break;
                    default:
                        System.out.println("Please Select Function");
                        login_user2();                                  // return Function login
                }
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("[ There are not exist in database. ]");
        }
    }
}



