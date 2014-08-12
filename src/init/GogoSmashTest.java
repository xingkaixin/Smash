package init;

import org.junit.*;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GogoSmashTest {
    @Test
    public void Test1() {
        GogoSmash gogo = new GogoSmash();
        ArrayList<ArrayList<Integer>> agrints;
        ArrayList<Integer> int1 = gogo.ints1;
        ArrayList<Integer> int2 = gogo.ints2;
        ArrayList<Integer> int3 = gogo.ints3;
        ArrayList<Integer> int4 = gogo.ints4;
        ArrayList<Integer> int5 = gogo.ints5;
        ArrayList<Integer> int6 = gogo.ints6;
        ArrayList<Integer> int7 = gogo.ints7;
        ArrayList<Integer> int8 = gogo.ints8;
        agrints = gogo.AgrAllinsts(int1,int2,int3,int4,int5,int6,int7,int8);
        int trytime=0;
        final int step1 =1234;
        final int step2 = 5678;
        System.out.println("本次竞猜的正确数字是 "+gogo.smash+" 现在开始竞猜！");
        ArrayList<Integer> a  =gogo.GetResult(step1);
        trytime++;
        //agrints = gogo.DelAgrIntsbyloc(agrints,gogo.getResultNum(step1,a));

        if(a.get(0)+a.get(1)+a.get(2)+a.get(3) <4){
            ArrayList<Integer> b  =gogo.GetResult(step2);
            trytime++;
            if(a.get(0)+a.get(1)+a.get(2)+a.get(3) ==4){
                System.out.println("竞猜成功！！！！"+"正确数字是："+step2+" 这是竞猜的第 "+trytime+" 回合");
            }else{
                ArrayList<Integer> nextguess = gogo.GetFirstandSecondStepResult(agrints,a,b);
                agrints = gogo.DelAgrInts(agrints,nextguess);
                agrints = gogo.DelAgrIntsbyloc(agrints,String.valueOf(step1));
                agrints = gogo.DelAgrIntsbyloc(agrints,String.valueOf(step2));
                System.out.println("DEBUG ag:" + nextguess);
                System.out.println("DEBUG ag:" + agrints);
                int part1 = a.get(4);
                int part2 = b.get(4);
                boolean notcorrect = true;
                int nexnums = 0;
                while(notcorrect){
                    int1 = agrints.get(0);
                    int2 = agrints.get(1);
                    int3 = agrints.get(2);
                    int4 = agrints.get(3);
                    int5 = agrints.get(4);
                    int6 = agrints.get(5);
                    int7 = agrints.get(6);
                    int8 = agrints.get(7);
                    nextguess = gogo.GenNextGuessNumsPart(int1,int2,int3,int4,nextguess,part1);
                    nextguess = gogo.GenNextGuessNumsPart(int5,int6,int7,int8,nextguess,part2);
                    System.out.println("This Turn's num is :  "+nextguess);
                    nexnums = gogo.tranArraytoint(nextguess);

                    ArrayList<Integer> lastresult = gogo.GetResult(nexnums);
                    trytime++;
                    if(lastresult.get(0)+lastresult.get(1)+lastresult.get(2)+lastresult.get(3)==2){
                        break;
                    }else{
                        agrints = gogo.DelAgrInts(agrints,nextguess);
                        agrints = gogo.DelAgrIntsbyloc(agrints,String.valueOf(nexnums));
                        int[] part = gogo.getPartNum(lastresult,part1,part2);
                        //part1 = part[0];
                        //part2 = part[1];
                        nextguess = gogo.getPreNextGuessResult(nexnums,lastresult);
                        System.out.println(agrints);
                    }
                }
                System.out.println("竞猜成功！！！！正确数字是 "+ nexnums+" 这是竞猜的第 "+trytime+" 回合");
            }
        }
        else {
            System.out.println("竞猜成功！！！！"+"正确数字是："+step1+" 这是竞猜的第 "+trytime+" 回合");
        }




    }
}