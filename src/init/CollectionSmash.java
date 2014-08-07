package init;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


/**
 * Created by XingKaiXin on 2014/8/6.
 */
public class CollectionSmash {


    public Collection<Integer> createSmashone() {
        int max = 8;
        int min = 1;
        int intrand;

        Collection<Integer> smashinit = new HashSet<Integer>();

        Collection<Integer> smashone = new HashSet<Integer>();

        for (int i = 1; i < 9; i++) {
            smashinit.add(i);
        }


        for (int i = 0; i < 4; i++) {

            intrand = (int) ((Math.random() * (max - min)) + min);
            int flag = 0;
            Iterator<Integer> iter = smashinit.iterator();
            while (iter.hasNext()) {
                if (flag == intrand) {
                    smashone.add(iter.next());
                    break;
                } else {
                    iter.next();
                }
                flag++;
            }
            max--;


        }
        return smashone;
    }

    public static void main(String[] args) {
        Collection<Collection<Integer>> smashall = new HashSet<Collection<Integer>>();
        int i = 0;
        long start = System.currentTimeMillis();
        //8个数字91种 9个155种
        while (i < 10000000) {
            CollectionSmash aa = new CollectionSmash();
            smashall.add(aa.createSmashone());
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) / 1000f + "秒，有" + smashall.size() + "种");


    }
}
