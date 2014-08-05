package init;

import java.util.ArrayList;

/**
 * Created by XingKaiXin on 2014/8/5.
 */
public class smash {

    public ArrayList<Integer> smash = new ArrayList<Integer>();
    public smash(){
        int max=9;
        int intrand;
        ArrayList<Integer> basicint = new InitRand(max).createBasic();
        for(int t = 0;t<4;t++) {
            InitRand rand = new InitRand(max);
            intrand = rand.randint;
            smash.add(basicint.get(intrand));
            basicint.remove(basicint);
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
