package com.random.test.old;

import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * Created by prajeeva on 9/30/17.
 */
public class RedisTest {
    public static void main(String[] args) {
        //this is how you connect to a redis instance that you have somewhere on the network
        //or the interwebzz
        //first add the redis client java
        //connects to the instance on the same box by default.
        Jedis j = new Jedis();
        System.out.println(j);
        j.set("something", "isUp");
        System.out.println(j.get("something"));

        j.lpush("work" , "1","2","3");
        System.out.println(j.rpop("work"));


    }
}
