package init;

import java.util.ArrayList;

/**
 * Created by XingKaiXin on 2014/8/5.
 */
public class InitRand {

    public ArrayList<Integer> basics = new ArrayList<Integer>();


    public InitRand() {
        int i = 0;
        while (i < 9) {

            basics.add(i + 1);
            i++;

        }

    }


}

