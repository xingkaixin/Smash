package init;

import java.util.ArrayList;

/**
 * Created by XingKaiXin on 2014/8/5.
 */
public class smash {

    public ArrayList<Integer> smash = new ArrayList<Integer>();
    public smash(){
        int max = 9;
        int min = 1;
        int intrand;
        ArrayList<Integer>  basics = new InitRand().basics;

        for(int t = 0;t<4;t++) {

            intrand = (int) ((Math.random() * (max - min)) + min);

            smash.add(basics.get(intrand));
            basics.remove(intrand);
            max--;

        }

    }

    public String getmash() {
        String mash = "";
        for(int i=0, size = smash.size();i< size ;i++) {
            mash += smash.get(i)+"";
        }
        return mash;
    }

}
