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
//        ArrayList<Integer> a  =gogo.GetResult(1234);
//        //gogo.getCorrectnums(1234,gogo.GetResult(1234));
//        //String aa =gogo.getResultNum(1234, gogo.GetResult(1234));
//        //System.out.println(aa);
//        //gogo.DelAgrIntsbyloc(gogo.AgrAllinsts(gogo.ints1,gogo.ints2,gogo.ints3,gogo.ints4, gogo.ints5,gogo.ints6,gogo.ints7,gogo.ints8),aa);
//        //System.out.println("111111   "+gogo.GenNextGuessNumsPart1(gogo.ints1,gogo.ints2,gogo.ints3,gogo.ints4,2));
//       //gogo.getResult(1234,gogo.GetResult(1234));
////        ArrayList<Integer> b = gogo.getPreNextGuessResult(1234,a);
////        int d = a.get(4);
////        System.out.println("dddd:"+d);
////        //gogo.getPartNum(gogo.GetResult(1234),0,0);
////        gogo.GenNextGuessNumsPart(gogo.ints1,gogo.ints2,gogo.ints3,gogo.ints4,b,d);
//
//        ArrayList<Integer> b  =gogo.GetResult(5678);
//        gogo.GetFirstandSecondStepResult(null,a,b);
        ArrayList<ArrayList<Integer>> agrints = new ArrayList<ArrayList<Integer>>();
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

        if(a.get(0)+a.get(1)+a.get(2)+a.get(3) <4){
            ArrayList<Integer> b  =gogo.GetResult(step2);
            trytime++;
            if(a.get(0)+a.get(1)+a.get(2)+a.get(3) ==4){
                System.out.println("竞猜成功！！！！"+"正确数字是："+step2+" 这是竞猜的第 "+trytime+" 回合");
            }else{
                ArrayList<Integer> nextguess = gogo.GetFirstandSecondStepResult(agrints,a,b);
            }
        }
        else {
            System.out.println("竞猜成功！！！！"+"正确数字是："+step1+" 这是竞猜的第 "+trytime+" 回合");
        }




    }
}