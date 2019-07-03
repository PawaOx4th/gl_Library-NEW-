package His;

import com.company.Enum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

    public class History {

        private String hisbookname,hisbookcode,hisusername;
        private Enum.Bookcategory hisbookcategory;
        private Enum.Bookstatus hisbookstat;
        private LocalDate hisdateborrow , hisdatereturn;

        public History() {

        }

        public History(String hisbookname, String hisbookcode, String hisusername, Enum.Bookcategory hisbookcategory,
                       Enum.Bookstatus hisbookstat, LocalDate hisdateborrow, LocalDate hisdatereturn) {
            this.hisbookname = hisbookname;
            this.hisbookcode = hisbookcode;
            this.hisusername = hisusername;
            this.hisbookcategory = hisbookcategory;
            this.hisbookstat = hisbookstat;
            this.hisdateborrow = hisdateborrow;
            this.hisdatereturn = hisdatereturn;
        }

        //==========================Getter===========================//

        public String getHisbookname() {
            return hisbookname;
        }

        public String getHisbookcode() {
            return hisbookcode;
        }

        public String getHisusername() {
            return hisusername;
        }

        public Enum.Bookcategory getHisbookcategory() {
            return hisbookcategory;
        }

        public Enum.Bookstatus getHisbookstat() {
            return hisbookstat;
        }

        public LocalDate getHisdateborrow() {
            return hisdateborrow;
        }

        public LocalDate getHisdatereturn() {
            return hisdatereturn;
        }
        //============================Setter====================/

        public void setHisbookname(String hisbookname) {
            this.hisbookname = hisbookname;
        }

        public void setHisbookcode(String hisbookcode) {
            this.hisbookcode = hisbookcode;
        }

        public void setHisusername(String hisusername) {
            this.hisusername = hisusername;
        }

        public void setHisbookcategory(Enum.Bookcategory hisbookcategory) {
            this.hisbookcategory = hisbookcategory;
        }

        public void setHisbookstat(Enum.Bookstatus hisbookstat) {
            this.hisbookstat = hisbookstat;
        }

        public void setHisdateborrow(LocalDate hisdateborrow) {
            this.hisdateborrow = hisdateborrow;
        }

        public void setHisdatereturn(LocalDate hisdatereturn) {
            this.hisdatereturn = hisdatereturn;
        }

        @Override
        public String toString() {
            return "History{" +
                    "hisbookname='" + hisbookname + '\'' +
                    ", hisbookcode='" + hisbookcode + '\'' +
                    ", hisusername='" + hisusername + '\'' +
                    ", hisbookcategory=" + hisbookcategory +
                    ", hisbookstat=" + hisbookstat +
                    ", hisdateborrow=" + hisdateborrow +
                    ", hisdatereturn=" + hisdatereturn +
                    '}';
        }
    }




