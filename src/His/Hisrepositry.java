package His;
import com.company.Enum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hisrepositry {

    private List<History>histories = new ArrayList<>();

    public List<History> getHistories() {
        return histories;
    }
    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public static void setHis(Hisrepositry histories){

        histories.getHistories().add((new History("A","01","kkk", Enum.Bookcategory.News,Enum.Bookstatus.BLANK, LocalDate.now(),LocalDate.now())));

    }

}
