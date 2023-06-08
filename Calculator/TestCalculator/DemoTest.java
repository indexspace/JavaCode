import org.junit.*;

public class DemoTest {
    static MyCalculator myCalculator;
    @BeforeClass
    public static void SetUp(){
        myCalculator =  new MyCalculator();
    }

    @AfterClass
    public static void TearDown(){
        myCalculator = null;
    }

    @Test
    public void Testadd() {
        Assert.assertEquals("problem",5,myCalculator.add(3, 2));
    }
    @Test
    public void Testmul(){
        Assert.assertEquals("mul err",9,myCalculator.mul(3,3));
    }

}