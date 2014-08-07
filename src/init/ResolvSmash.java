package init;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Kevin on 2014/8/7.
 */
public class ResolvSmash {

    static int GuessSmash = 2156;

    static int firstround = 1234;
    static int secondround = 5678;

    int[] result;


    Collection<Integer> int1 = new HashSet<Integer>();
    Collection<Integer> int2 = new HashSet<Integer>();

    Collection<Integer> int3 = new HashSet<Integer>();
    Collection<Integer> int4 = new HashSet<Integer>();

    Collection<Integer> int5 = new HashSet<Integer>();
    Collection<Integer> int6 = new HashSet<Integer>();
    Collection<Integer> int7 = new HashSet<Integer>();
    Collection<Integer> int8 = new HashSet<Integer>();


    public ResolvSmash() {
        int i = 0;
        while (i < 4) {
            int1.add(i + 1);
            i++;
        }
        int2.addAll(int1);
        int3.addAll(int1);
        int4.addAll(int1);

        i = 4;
        while (i < 8) {
            int5.add(i + 1);
            i++;
        }
        int6.addAll(int5);
        int7.addAll(int5);
        int8.addAll(int5);

    }

    public boolean correct(int[] results) {
        int result = results[0]+results[1]+results[2]+results[3];
        if(result==4){
            return true;
        }else {return false;}
    }



    public static void main(String[] args) {
        int a;
        int b;

        ResolvSmash rs = new ResolvSmash();
        SmashOper so = new SmashOper();
        boolean correct;

        rs.result = so.findnumber(rs.firstround,so.castinttohashset(rs.GuessSmash));
        correct = rs.correct(rs.result);
        a = rs.result[4];
        System.out.println(correct);

        if (!correct) {
            rs.result = so.findnumber(rs.secondround,so.castinttohashset(rs.GuessSmash));
            correct = rs.correct(rs.result);
            b = rs.result[4];
            System.out.println(correct);
        } else {
            System.out.println("CORRECT!Number is "+ rs.firstround);
        }

        int nextround = rs.secondround;
        while(!correct) {

        }

        System.out.println("CORRECT!Number is "+ nextround);



    }
}
