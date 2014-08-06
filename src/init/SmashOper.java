package init;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by XingKaiXin on 2014/8/6.
 */
public class SmashOper {

    public HashSet<Integer> castinttohashset(int num) {
        HashSet<Integer> hashnum = new HashSet<Integer>();
        String strnum = String.valueOf(num);
        System.out.println(strnum);
        for (int i = 0, j = 1; i < 4; i++, j++) {
            hashnum.add(Integer.valueOf(strnum.substring(i, j)));
        }
        return hashnum;
    }

    public int[] findnumber(int numbers, HashSet<Integer> target) {
        boolean flag_exist;
        int[] result = new int[6];
        int exist = 0;
        int correct = 0;


        HashSet<Integer> number = castinttohashset(numbers);
        Iterator<Integer> iter = number.iterator();
        int location = 0;
        while (iter.hasNext()) {
            int cur = iter.next();
            flag_exist = target.contains(cur);
            if (flag_exist) {
                exist++;
                Iterator<Integer> targetiter = target.iterator();
                int targetloc = 0;
                while (targetiter.hasNext()) {
                    int targetcur = targetiter.next();
                    if (targetloc == location) {
                        if (targetcur == cur) {
                            result[location] = 1;
                        } else {
                            result[location] = 0;
                        }
                    }
                    location++;
                    targetcur++;
                }

            }

        }

        result[4] = exist;
        result[5] = correct;
        for (int i = 0; i < 6; i++) {
            System.out.println("result" + i + ":" + result[i]);

        }
        return result;
    }

}
