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




    }
}