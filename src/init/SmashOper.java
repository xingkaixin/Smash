package init;

import java.util.HashSet;

/**
 * Created by XingKaiXin on 2014/8/6.
 */
public class SmashOper {

    public HashSet<Integer> castinttohashset(int num) {
        HashSet<Integer> hashnum = new HashSet<Integer>();
        String strnum = String.valueOf(num);
        System.out.println(strnum);
        for(int i=0,j=1;i<4;i++,j++) {
            hashnum.add(Integer.valueOf(strnum.substring(i, j)));
        }
        System.out.println(hashnum.size());
        return hashnum;
    }
}
