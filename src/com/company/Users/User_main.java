package com.company.Users;

import com.company.Controller;
import com.company.Display.user_Display;
import com.company.Service.Libraryservice;

import java.util.InputMismatchException;

//import static com.company.Librarian.Login_librarian.libraryservice;

public class User_main {
    public static void login_user() {
        Libraryservice libraryservice = Libraryservice.getInstance();
        User loginUser = user_Display.CheckInput();
        if (loginUser != null) {
            libraryservice.setUser(loginUser);                              //importUser from Libreryservice
            login_user2();
//            Controller.controller();
        } else {
            System.out.println("[ There are not exist in database. ]\n");
            Controller.controller();
        }
    }

    public static void login_user2() {
        try {
            boolean ifCheck = true;
            while (ifCheck) {
                //Display Manu User [use_Display]
                int ans_2 = user_Display.userManu();
                switch (ans_2) {
                    case 1:
                        //Display Search Function [use_Display]
                        int Usearch = user_Display.u_seachfunction();
                        switch (Usearch) {
                            case 1:
                                User_Function.searchBookcode();
                                break;
                            case 2:
                                User_Function.searchBookname();
                                break;
                            case 3:
                                User_Function.searchBookcatagory();
                                break;
//                            case 4:
//                                User_Function.searchBookstatus();
//                                break;
                        }
                        break;
                    case 2:
                        User_Function.changDatereturn();
                        break;
                    case 3:
                        User_Function.rentalBook();
                        break;
                    case 4:
                        User_Function.returnbook();
                        break;
                    case 5:
                        User_Function.printHistory();
                        break;
                    case 6:
                        Controller.controller();
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



