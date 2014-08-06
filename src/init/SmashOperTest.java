package init;


import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class SmashOperTest {

    @Test
    public void testCastinttohashset() throws Exception {
        HashSet<Integer> aa = new SmashOper().castinttohashset(1234);
    }
}