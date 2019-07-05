package com.company;

public enum Enum {
    ;

    public enum Bookcategory {
        News("N"),History("H"),Manga("M"),Love("L");
        private String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        Bookcategory(String code) {
            this.code = code;
        }
    }

    public enum Bookstatus {
            BLANK,  //สามารถยืมได้
            BUSY,  //ไม่สามารถยืมได้
            Not_Confirmed, // ไม่ได้รับการยืนยัน
            Confirm; //ทำการยืนยัน

    }

    public enum Position {


        librarian,user ;
    }




}
