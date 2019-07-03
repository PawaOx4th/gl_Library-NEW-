package His;

import java.util.List;

public class Hmain {
    public static void main(String[] args) {
        hisEx hisEx = new hisEx();
        History histories= new History();
        Hisrepositry hisrepositry = new Hisrepositry();
        Hisrepositry.setHis(hisrepositry);
        for(int i = 0; i<hisrepositry.getHistories().size() ;i++){
            System.out.println(hisrepositry.getHistories().get(i));
        }
    }
}
