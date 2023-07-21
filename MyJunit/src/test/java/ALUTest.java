import org.junit.Assert;
import org.junit.Test;

public class ALUTest {

    @Test
    public void add() {
        Assert.assertEquals(3, ALU.add(1, 2));
    }

    @Test
    public void sub() {
    }
}