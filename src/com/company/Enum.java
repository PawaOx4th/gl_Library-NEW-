package com.company;

public enum Enum {
    ;

    public enum Bookcategory {

        News,History,Manga,Love ;
    }

    public enum Bookstatus {
            BLANK,  //สามารถยืมได้
            BUSY;   //ไม่สามารถยืมได้
    }

    public enum Position {


        librarian,user ;
    }

    public enum Status {
        Lend;
    }
}
