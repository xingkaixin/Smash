package init;

import java.util.*;

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
        int result = results[0] + results[1] + results[2] + results[3];
        if (result == 4) {
            return true;
        } else {
            return false;
        }
    }


    public Collection<Collection<Integer>> AgrCollection(Collection<Integer> int1, Collection<Integer> int2, Collection<Integer> int3, Collection<Integer> int4,
                                                         Collection<Integer> int5, Collection<Integer> int6, Collection<Integer> int7, Collection<Integer> int8) {
        Collection<Collection<Integer>> agr = new ArrayList<Collection<Integer>>();
        agr.add(int1);
        agr.add(int2);
        agr.add(int3);
        agr.add(int4);

        agr.add(int5);
        agr.add(int6);
        agr.add(int7);
        agr.add(int8);

        return agr;
    }

    public Collection<Integer> ResizeGuessLib2(Collection<Integer> ints, int[] removenums) {
        Collection<Integer> resize = new HashSet<Integer>();
        ArrayList<Integer> redef;
        redef = (ArrayList<Integer>) ints;
        int size = removenums.length;
        int removenum;
        for (int i = 0; i < size; i++) {
            removenum = removenums[i];
            redef.remove(redef.indexOf(removenum));
        }
        Iterator<Integer> iter = redef.iterator();
        while (iter.hasNext()) {
            resize.add(iter.next());
        }
        return resize;
    }

    public int GuessNext(Collection<Collection<Integer>> guessgroup, int[] lastresult) {
        int guessnext = 0;
        return guessnext;
    }


    public Collection<Collection<Integer>> ResizeGuessLib1(Collection<Collection<Integer>> ints, int[] removenums) {
        Collection<Collection<Integer>> resize = new ArrayList<Collection<Integer>>();

        Iterator<Collection<Integer>> iter = ints.iterator();
        while (iter.hasNext()) {
            resize.add(ResizeGuessLib2(iter.next(), removenums));
        }

        return resize;
    }


    public Collection<Integer> ResizeGuessFirstSetp(Collection<Integer> ints, int sernum, int lastguessnum, int[] lastresult) {
        int removenumis = Integer.parseInt(String.valueOf(lastguessnum).substring(sernum - 1, sernum));
        int result = lastresult[sernum - 1];
        if (ints.isEmpty()) {
        } else {
            if (result == 1) {
                ints.clear();
            } else {
                if (ints.contains(removenumis)) {
                    ints.remove(removenumis);
                }
            }
        }
        return ints;
    }

    public int[] getRemoveNums(int lastguessnum, int[] lastresult) {
        int[] removenums = new int[4];
        int j = 0;
        String str = String.valueOf(lastguessnum);
        int tmpremove;
        for (int i = 0; i < 4; i++) {
            if (lastresult[i] == 1) {
                tmpremove = Integer.parseInt(str.substring(i - 1, i));
                removenums[j] = tmpremove;
                j++;
            }

        }

        return removenums;
    }

    public int GenGuessNum(int n1, int n2, int n3, int n4) {
        return n1 * 1000 + n2 * 100 + n3 * 10 + n4;
    }


    public static void main(String[] args) {
        int a;
        int b;

        ResolvSmash rs = new ResolvSmash();
        SmashOper so = new SmashOper();
        boolean correct;

        rs.result = so.findnumber(rs.firstround, so.castinttohashset(rs.GuessSmash));
        correct = rs.correct(rs.result);
        a = rs.result[4];
        System.out.println(correct);

        if (!correct) {
            rs.result = so.findnumber(rs.secondround, so.castinttohashset(rs.GuessSmash));
            correct = rs.correct(rs.result);
            b = rs.result[4];
            System.out.println(correct);
        } else {
            System.out.println("CORRECT!Number is " + rs.firstround);
        }

        int nextround = rs.secondround;
        int trytimes = 10;
        while (!correct) {

            trytimes--;
            if (trytimes == 0) {
                break;
            }
        }

        if (correct) {
            System.out.println("CORRECT!Number is " + nextround);
        } else {
            System.out.println("GAME OVER!");
        }


    }
}
