package init;


import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class SmashOperTest {

    @Test
    public void testCastinttohashset() throws Exception {
        HashSet<Integer> aa = new SmashOper().castinttohashset(1234);
    }

    @Test
    public void testfind() throws Exception{
        SmashOper aa =new SmashOper();
        System.out.println(aa.castinttohashset(4321));
        aa.findnumber(1234,aa.castinttohashset(4321));
    }
}