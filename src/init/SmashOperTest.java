package init;


import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

public class SmashOperTest {

    @Test
    public void testCastinttohashset() throws Exception {
        Collection<Integer> aa = new SmashOper().castinttohashset(1234);
    }

    @Test
    public void testfind() throws Exception{
        SmashOper aa =new SmashOper();
        aa.findnumber(1234,aa.castinttohashset(5634));
    }
}