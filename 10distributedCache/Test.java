package io.kimmking.rpcfx.redis;


import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {
    public static void main(String[] args) {
        //简单的分布式锁
        JedisUtil jedisUtil = new JedisUtil();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(jedisUtil);
            threadA.start();
        }
        //分布式计数器
        JedisUtil.setDecr("kucun",0);
    }
}

