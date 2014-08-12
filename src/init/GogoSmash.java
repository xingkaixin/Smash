package init;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by XingKaiXin on 2014/8/9.
 */
public class GogoSmash {
    ArrayList<Integer> smash = new ArrayList<Integer>();

    ArrayList<Integer> ints1 = new ArrayList<Integer>();
    ArrayList<Integer> ints2 = new ArrayList<Integer>();
    ArrayList<Integer> ints3 = new ArrayList<Integer>();
    ArrayList<Integer> ints4 = new ArrayList<Integer>();
    ArrayList<Integer> ints5 = new ArrayList<Integer>();
    ArrayList<Integer> ints6 = new ArrayList<Integer>();
    ArrayList<Integer> ints7 = new ArrayList<Integer>();
    ArrayList<Integer> ints8 = new ArrayList<Integer>();

    ArrayList<Integer> result = new ArrayList<Integer>();


    //初始化一个4位随机数（1-8）
    public GogoSmash() {
        int max = 8;
        int min = 1;
        int intrand;
        ArrayList<Integer> smashinit = new ArrayList<Integer>();
        for (int i = 1; i < 9; i++) {
            smashinit.add(i);
        }
        for (int i = 0; i < 4; i++) {
            intrand = (int) ((Math.random() * (max - min)) + min);
            smash.add(smashinit.get(intrand));
            smashinit.remove(intrand);
            max--;
        }
        System.out.println("GOGOSMASH is " + smash);

        for (int i = 1; i < 5; i++) {
            ints1.add(i);
        }
        ints2.addAll(ints1);
        ints3.addAll(ints1);
        ints4.addAll(ints1);
        for (int i = 5; i < 9; i++) {
            ints5.add(i);
        }
        ints6.addAll(ints5);
        ints7.addAll(ints5);
        ints8.addAll(ints5);

        for (int i = 0; i < 4; i++) {
            result.add(0);
        }
    }

    //把8个数字集统计，方便后面计算
    public ArrayList<ArrayList<Integer>> AgrAllinsts(ArrayList<Integer> ints1, ArrayList<Integer> ints2, ArrayList<Integer> ints3, ArrayList<Integer> ints4,
                                                     ArrayList<Integer> ints5, ArrayList<Integer> ints6, ArrayList<Integer> ints7, ArrayList<Integer> ints8) {
        ArrayList<ArrayList<Integer>> allints = new ArrayList<ArrayList<Integer>>();
        allints.add(ints1);
        allints.add(ints2);
        allints.add(ints3);
        allints.add(ints4);
        allints.add(ints5);
        allints.add(ints6);
        allints.add(ints7);
        allints.add(ints8);
        return allints;
    }

    //比对4位数字的结果是否正确，返回数据正确的位置和数字正确但位置不正确的数字个数
    public ArrayList<Integer> GetResult(int num) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> strnums = new ArrayList<Integer>();
        int exist = 0;
        int currect =0;
        String str = String.valueOf(num);
        for (int i = 0, length = str.length(); i < length; i++) {
            strnums.add(Integer.valueOf(str.substring(i, i + 1)));
        }
        for (int i = 0, size = smash.size(); i < size; i++) {
            if (smash.contains(strnums.get(i))) {
                exist++;
                if (smash.indexOf(strnums.get(i)) == i) {
                    result.add(1);
                    currect++;
                } else {
                    result.add(0);
                }
            } else {
                result.add(0);
            }
        }
        result.add(exist-currect);
        System.out.println(result);
        return result;
    }

    //根据猜测的结果，返回位置也正确的数字集
    public ArrayList<Integer> getCorrectnums(int lastnums, ArrayList<Integer> lastresult) {
        ArrayList<Integer> Correctnums = new ArrayList<Integer>();
        ArrayList<Integer> correctloc = new ArrayList<Integer>();
        for (int i = 0, size = lastresult.size(); i < size - 1; i++) {
            if (lastresult.get(i) == 1) {
                correctloc.add(i);
            }
        }
        String str = String.valueOf(lastnums);
        for (int i = 0, size = correctloc.size(); i < size; i++) {
            Correctnums.add(Integer.valueOf(str.substring(correctloc.get(i), correctloc.get(i) + 1)));
        }
        System.out.println(Correctnums);
        return Correctnums;
    }

    public String getResultNum(int lastnums, ArrayList<Integer> lastresult) {
        String strnum;
        int num = 0;
        String str = String.valueOf(lastnums);
        for (int i = 0, j = 1000, size = lastresult.size(); i < size - 1; i++) {
            if (lastresult.get(i) == 1) {
                System.out.println("i  " + i);
                num += Integer.valueOf(str.substring(i, i + 1)) * j;
            }
            j = j / 10;
        }
        strnum = String.valueOf(num);
        for (int i = 0, j = 0, size = 4 - Integer.valueOf(String.valueOf(num).length()); i < size; i++) {
            strnum = String.valueOf(j) + strnum;
        }
        System.out.println(strnum);
        return strnum;
    }

    //移除所有序列中的数字
    public ArrayList<ArrayList<Integer>> DelAgrInts(ArrayList<ArrayList<Integer>> agrints, ArrayList<Integer> correctnums) {
        ArrayList<ArrayList<Integer>> allints = new ArrayList<ArrayList<Integer>>();
        Iterator<ArrayList<Integer>> iter = agrints.iterator();
        while (iter.hasNext()) {
            allints.add(DelInts(iter.next(), correctnums));
        }
        System.out.println(allints);
        return allints;
    }

    //移除一个序列中的数字
    public ArrayList<Integer> DelInts(ArrayList<Integer> ints, ArrayList<Integer> correctnums) {
        System.out.println(ints);
        if (ints.size() > 0) {
            for (int i = 0, size = correctnums.size(); i < size; i++) {
                int index = ints.indexOf(correctnums.get(i));
                if (index >= 0) {
                    ints.remove(index);
                }

            }
        }
        // System.out.println(ints);
        return ints;
    }

    //按位置移除对应数字的批量
    public ArrayList<ArrayList<Integer>> DelAgrIntsbyloc(ArrayList<ArrayList<Integer>> agrints, String correctnums) {
        ArrayList<ArrayList<Integer>> allints = new ArrayList<ArrayList<Integer>>();
        Iterator<ArrayList<Integer>> iter = agrints.iterator();
        String str = correctnums;
        int a = Integer.valueOf(str.substring(0, 1));
        int b = Integer.valueOf(str.substring(1, 2));
        int c = Integer.valueOf(str.substring(2, 3));
        int d = Integer.valueOf(str.substring(3, 4));

        int i = 1;

        while (iter.hasNext()) {
            if (i == 1 || i == 5) {
                allints.add(DelIntsbyloc(iter.next(), a));
            } else if (i == 2 || i == 6) {
                allints.add(DelIntsbyloc(iter.next(), b));
            } else if (i == 3 || i == 7) {
                allints.add(DelIntsbyloc(iter.next(), c));
            } else if (i == 4 || i == 8) {
                allints.add(DelIntsbyloc(iter.next(), d));
            }
            i++;
        }
        System.out.println(allints);
        return allints;
    }

    //按位置移除对应的数字
    public ArrayList<Integer> DelIntsbyloc(ArrayList<Integer> ints, int correctnum) {
        int index = ints.indexOf(correctnum);
        if (index >= 0) {
            ints.remove(index);
        }
        return ints;
    }

    public ArrayList<Integer> GenNextGuessNumsPart(ArrayList<Integer> int1, ArrayList<Integer> int2, ArrayList<Integer> int3,
                                    ArrayList<Integer> int4, ArrayList<Integer> currentresult, int countnum) {
        int currentnum = 0;
        int newnum = 0;
        int part1 = 0;

        String cur = "";
        for (int i = 0, size = currentresult.size(); i < size; i++) {
            cur = cur + currentresult.get(i);
        }
        cur = cur.replace("0", "");
        System.out.println(cur.length());
        if(cur.length()>0){
            currentnum = Integer.parseInt((cur));
        }
        else {
            currentnum = 0;
        }



        ArrayList<ArrayList<Integer>> agr = new ArrayList<ArrayList<Integer>>();
        agr.add(int1);
        agr.add(int2);
        agr.add(int3);
        agr.add(int4);


        ArrayList<Integer> operinst = new ArrayList<Integer>();
        for (int i = 0, j = 0, size = agr.size(); i < size; i++) {
            if(j==countnum){
                break;
            }

            if (agr.get(i).size() > 0) {
                int locnum = currentresult.get(i);
                if (locnum == 0) {
                    int curloc = GetNumFromInts(agr.get(i), currentnum);
                    currentnum = Integer.valueOf(currentnum + "" + curloc);
                    currentresult.set(i, curloc);
                    j++;
                }
            }

            if (j == countnum) {
                break;
            }
        }

        System.out.println("new guess num:"+currentresult);
        return currentresult;
    }

    public int GetNumFromInts(ArrayList<Integer> ints, int currentnum) {
        Iterator<Integer> iter = ints.iterator();
        String str = String.valueOf(currentnum);

        for (int i = 0, j = 0, size = str.length(); i < 4 - size; i++) {
            str = j + str;
        }

        int a = Integer.valueOf(str.substring(0, 1));
        int b = Integer.valueOf(str.substring(1, 2));
        int c = Integer.valueOf(str.substring(2, 3));
        int d = Integer.valueOf(str.substring(3, 4));
        int newnum = 0;
        while (iter.hasNext()) {
            newnum = iter.next();
            if (a == newnum || b == newnum || c == newnum || d == newnum) {
            } else {
                break;
            }
        }
        return newnum;
    }

    public ArrayList<Integer> getPreNextGuessResult(int lastnums, ArrayList<Integer> lastresult) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String str = String.valueOf(lastnums);
        int a = Integer.valueOf(str.substring(0, 1));
        int b = Integer.valueOf(str.substring(1, 2));
        int c = Integer.valueOf(str.substring(2, 3));
        int d = Integer.valueOf(str.substring(3, 4));
        int[] nums = new int[4];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        nums[3] = d;
        for (int i = 0, size = lastresult.size(); i < size - 1; i++) {
            if (lastresult.get(i) == 1) {
                result.add(nums[i]);
            } else {
                result.add(0);
            }
        }

        System.out.println(result);
        return result;
    }

    public int[] getPartNum(ArrayList<Integer> result, int parta, int partb) {
        System.out.println(result);
        int[] partnum = new int[2];
        int partaexist = 0;
        int partbexist = 0;
        int num;
        for (int i = 0, size = result.size(); i < size - 1; i++) {
            num = result.get(i);
            if (num > 0) {
                if (num < 5) {
                    partaexist++;
                } else {
                    partbexist++;
                }
            }
        }
        partnum[0] = parta - partaexist;
        partnum[1] = parta - partbexist;
        System.out.println(partnum[0] + " " + partnum[1]);
        return partnum;
    }


}
