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
        ArrayList<Integer> a  =gogo.GetResult(1234);
        //gogo.getCorrectnums(1234,gogo.GetResult(1234));
        //String aa =gogo.getResultNum(1234, gogo.GetResult(1234));
        //System.out.println(aa);
        //gogo.DelAgrIntsbyloc(gogo.AgrAllinsts(gogo.ints1,gogo.ints2,gogo.ints3,gogo.ints4, gogo.ints5,gogo.ints6,gogo.ints7,gogo.ints8),aa);
        //System.out.println("111111   "+gogo.GenNextGuessNumsPart1(gogo.ints1,gogo.ints2,gogo.ints3,gogo.ints4,2));
       //gogo.getResult(1234,gogo.GetResult(1234));
//        ArrayList<Integer> b = gogo.getPreNextGuessResult(1234,a);
//        int d = a.get(4);
//        System.out.println("dddd:"+d);
//        //gogo.getPartNum(gogo.GetResult(1234),0,0);
//        gogo.GenNextGuessNumsPart(gogo.ints1,gogo.ints2,gogo.ints3,gogo.ints4,b,d);

        ArrayList<Integer> b  =gogo.GetResult(5678);
        gogo.GetFirstandSecondStepResult(null,a,b);

    }
}