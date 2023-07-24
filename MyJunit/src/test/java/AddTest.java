import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AddTest {

    @Parameterized.Parameters
    public static Collection<Object []> data() {
        return Arrays.asList(new Object [][] {
                {2, 1, 1}, {3, 1, 2}, {5, 2, 3}, {6, 3, 3}, {9, 4, 5}
        });
    }

    private int expected;
    private int input1;
    private int input2;

    public AddTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void add() {
        Assert.assertEquals(expected, ALU.add(input1, input2));
    }

}