package com.company.Display;

import com.company.Human.UserList;

import java.util.Scanner;

public class librarian_display {

    //************ Main Function ****************//

    public  static  int librarian_main(){
        System.out.print("====================================================");
        System.out.println("\n\t\t\t[ What  do you want to do ]");
        System.out.println("1 - Add Book\t    2 - Delete Book\t\t3 - Search\n" +
                           "4 - Chang Date\t\t5 - Sort\t\t    6 - Permits\n" +
                           "7 - Return\t\t    8 - History\t\t    9 - Back"+
                            "\n10 - Exit");
        System.out.println("====================================================");
        Scanner want = new Scanner(System.in);
        int ans_2 = want.nextInt();
        return ans_2;
    }

    //************ SeachDisplay Function ****************//
    public  static  int librarian_SeachDisplay(){
        System.out.println("Please Select Search :");
        System.out.println("1 - Search by name\t2 - Search by Code\t" +
                "3 - Search by Cattegory \t4 - Search by Status   ");
        Scanner sh = new Scanner(System.in);
        int Searchf = sh.nextInt();
        return Searchf;
    }

    //************  Function ****************//
    public static  int librarian_sortDisplay(){
        Scanner sort = new Scanner(System.in);
        System.out.println("Please input choice for Sort book ");
        System.out.println("1 - Sort by name\t2 - Sort by Code\t" +
                "3 - Sort by Cattegory \t4 - Sort by Status   ");
        int SortFx = sort.nextInt();
        return SortFx;
    }

    //************ Login Function ****************//
    public static String[] library_login(){
        UserList librarians = new UserList() ;
        UserList.librarian2(librarians);

        System.out.print("ID : ");
        Scanner ID =new Scanner(System.in);
        String id = ID.nextLine();

        System.out.print("PS : ");
        Scanner PS =new Scanner(System.in);
        String ps = PS.nextLine();

        return new String[]{id,ps} ;
    }
}
