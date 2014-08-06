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

    public int getmash() {
        int mash = 0 ;
        for(int i=0,j=1000, size = smash.size();i< size ;i++) {
            mash += smash.get(i)*j;
            j = j/10;
        }
        return mash;
    }

    public int[] findnumber(int numbers) {
        boolean flag_exist;
        boolean flag_location;
        int[] result = new int[2];
        int exist = 0;
        int correct = 0;
        String strnumbers = numbers + "";
        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 0, j = 1; i < 4; i++, j++) {
            number.add(Integer.valueOf(strnumbers.substring(i, j)));
        }
        for (int i = 0; i < 4; i++) {
            int k = number.get(i);
            flag_exist = smash.contains(k);
            if (flag_exist) {
                exist++;
                if (k == smash.get(i)) {
                    correct++;
                }
            }


        }
        result[0] = exist;
        result[1] = correct;
        return result;
    }

}
