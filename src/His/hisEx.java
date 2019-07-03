package His;

import com.company.Enum;

import java.time.LocalDate;
import java.util.List;

public class hisEx {

    public static void sethis(List<History>histories){

        histories.add(new History("A","01","kkk", Enum.Bookcategory.News,Enum.Bookstatus.BLANK, LocalDate.now(),LocalDate.now()));

    }


}
