import org.junit.*;
import redis.clients.jedis.Jedis;

public class JedisTest {
    private static Jedis jedis;

    @BeforeClass
    public static void setup() {    // 连接本地的Redis
        jedis = new Jedis("127.0.0.1", 6379);  // host, port
        jedis.select(0);   // 选择库
    }

    @Test
    public void testString(){
        System.out.println("jedis.get(\"myKey\") = " + jedis.get("myKey"));     // 对jedis直接进行Redis命令
        System.out.println("jedis.set(\"myKey2\", \"czp\") = " + jedis.set("myKey2", "czp"));
        System.out.println("jedis.get(\"myKey2\") = " + jedis.get("myKey2"));
    }

    @AfterClass
    public static void teardown() {
        if (jedis != null) {
            jedis.close();    // 断开Redis连接
        }
    }
}
