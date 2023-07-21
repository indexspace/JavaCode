package org.example;

import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class JedisConnectionPoolTest {

    private static Jedis jedis;
    
    @BeforeClass
    public static void setUp() {
        jedis = JedisConnectionPool.getJedis();
    }
    
    @Test
    public void testGetJedis() {
        jedis.set("hello", "world");
        System.out.println("jedis.get(\"hello\") = " + jedis.get("hello"));
    }

    @BeforeClass
    public static void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}