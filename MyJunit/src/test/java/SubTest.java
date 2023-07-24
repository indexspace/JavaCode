import org.junit.Assert;
import org.junit.Test;

public class SubTest {

    @Test
    public void sub() {
        Assert.assertEquals(-1, ALU.sub(1, 2));
        Assert.assertEquals(-7, ALU.sub(1, 8));
    }
}
