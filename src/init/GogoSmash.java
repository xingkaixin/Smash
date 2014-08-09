package init;

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
        System.out.println("GOGOSMASH is "+smash);

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


    }

    //把8个数字集统计，方便后面计算
    public ArrayList<ArrayList<Integer>> AgrAllinsts(ArrayList<Integer> ints1,ArrayList<Integer> ints2,ArrayList<Integer> ints3,ArrayList<Integer> ints4,
                                                     ArrayList<Integer> ints5,ArrayList<Integer> ints6,ArrayList<Integer> ints7,ArrayList<Integer> ints8) {
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
        String str = String.valueOf(num);
        for (int i = 0, length = str.length(); i < length; i++) {
            strnums.add(Integer.valueOf(str.substring(i, i + 1)));
        }
        for (int i = 0, size = smash.size(); i < size; i++) {
            if (smash.contains(strnums.get(i))) {
                exist++;
                if (smash.indexOf(strnums.get(i)) == i) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            } else {
                result.add(0);
            }
        }
        result.add(exist);
        System.out.println(result);
        return result;
    }

    //根据猜测的结果，返回位置也正确的数字集
    public ArrayList<Integer> getCorrectnums(int lastnums,ArrayList<Integer> lastresult){
        ArrayList<Integer> Correctnums = new ArrayList<Integer>();
        ArrayList<Integer> correctloc = new ArrayList<Integer>();
        for(int i=0,size=lastresult.size();i<size-1;i++){
            if(lastresult.get(i)==1){
                correctloc.add(i);
            }
        }
        String str= String.valueOf(lastnums);
        for(int i =0,size=correctloc.size();i<size;i++){
            Correctnums.add(Integer.valueOf(str.substring(correctloc.get(i), correctloc.get(i)+1)));
        }
        System.out.println(Correctnums);
        return Correctnums;
    }

    //移除所有序列中的数字
    public  ArrayList<ArrayList<Integer>> DelAgrInts( ArrayList<ArrayList<Integer>> agrints,ArrayList<Integer> correctnums){
        ArrayList<ArrayList<Integer>> allints = new ArrayList<ArrayList<Integer>>();
        Iterator<ArrayList<Integer>> iter = agrints.iterator();
        while(iter.hasNext()){
            allints.add(DelInts(iter.next(),correctnums));
        }
        System.out.println(allints);
        return allints;
    }

    //移除一个序列中的数字
    public  ArrayList<Integer> DelInts(ArrayList<Integer> ints,ArrayList<Integer> correctnums){
        System.out.println(ints);
        if(ints.size()>0){
            for(int i=0,size=correctnums.size();i<size;i++){
                int index =ints.indexOf(correctnums.get(i));
                if(index>0){
                    ints.remove(ints.indexOf(correctnums.get(i)));
                }

            }
        }
       // System.out.println(ints);
        return ints;
    }


}
