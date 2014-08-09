package init;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GogoSmashTest {
    @Test
    public void Test1() {
        GogoSmash gogo = new GogoSmash();
        gogo.GetResult(1234);
        gogo.getCorrectnums(1234,gogo.GetResult(1234));
        gogo.DelAgrIntsbyloc(gogo.AgrAllinsts(gogo.ints1,gogo.ints2,gogo.ints3,gogo.ints4, gogo.ints5,gogo.ints6,gogo.ints7,gogo.ints8),1234);



    }
}