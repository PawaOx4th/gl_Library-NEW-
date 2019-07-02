package com.company;
import java.util.Scanner;

public class Controller {
    void controller(Bookshelf books){

        UserList librarians = new UserList() ;
        UserList.librarian2(librarians);
        boolean loop = true;
        Scanner want = new Scanner(System.in);
        Scanner pos = new Scanner(System.in);
        System.out.println("Please enter your position");
        System.out.println("1 - Librarian");
        System.out.println("2 - User");
        int ans_1 = pos.nextInt();
        if (ans_1 == 1) {
            var Login_librarain = new Login_librarian();
            Login_librarian.login_librarian(books);
            }
             else {
            if (ans_1 == 2) {
                //************************* Employee Section *************************//
                // List<Book> books = new ArrayList<>();
//                boolean loop = true;
                Scanner want2 = new Scanner(System.in);
                //************************* Add Component *************************//

                do {
                    System.out.println("\nWhat  do you want to do");
                    System.out.println("1 - Search\n2 - Check\n3 - Rental\n4 - Return\n5-Exit");
                    int ans_2 = want.nextInt();
                    switch (ans_2) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            loop = false;
                    }
                } while (loop);
            } else {
                System.out.println("Sorry please connect again later");
            }
        }
    }
}
