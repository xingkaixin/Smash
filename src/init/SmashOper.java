package init;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by XingKaiXin on 2014/8/6.
 */
public class SmashOper {

    public Collection<Integer> castinttohashset(int num) {
        Collection<Integer> hashnum = new HashSet<Integer>();
        String strnum = String.valueOf(num);
        for (int i = 0, j = 1; i < 4; i++, j++) {
            System.out.println(strnum.substring(i, j));
            hashnum.add(Integer.valueOf(strnum.substring(i, j)));
        }
        return hashnum;
    }

    public int casthashtoint(Collection<Integer> num) {
       int nums = 0;

        Iterator<Integer> iter = num.iterator();
        int i =1000;
        while(iter.hasNext()){
            nums += iter.next()*i;
            i=i/10;
        }

        return nums;
    }

    public int[] findnumber(int numbers, Collection<Integer> target) {
        System.out.println(casthashtoint(target));
        boolean flag_exist;
        int[] result = new int[6];
        int exist = 0;
        int correct = 0;


        Collection<Integer> number = castinttohashset(numbers);
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
                    System.out.println("targetloc:" +cur+"   "+targetcur+"  "+ targetloc);
                    if (targetloc == location) {
                        if (targetcur == cur) {
                            result[location] = 1;
                            System.out.println("match result:" + result[location]);
                            System.out.println("match:" + location);
                            break;
                        }
                    }
                    targetloc++;


                }

            }
            location++;

        }

        result[4] = exist;
        result[5] = correct;
        for (int i = 0; i < 6; i++) {
            System.out.println("result" + i + ":" + result[i]);

        }
        return result;
    }

}
