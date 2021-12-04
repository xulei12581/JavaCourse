package io.kimmking.rpcfx.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class JedisUtil {

    private static JedisPool jedisPool;

    @Autowired(required = true)
    public void setJedisPool(JedisPool jedisPool) {
        JedisUtil.jedisPool = jedisPool;
    }
    /**
     * 对某个键的值自增
     * @param key 键
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setIncr(String key, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result =jedis.incr(key);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            System.out.println("set "+ key + " = " + result);
        } catch (Exception e) {
            System.out.println("set "+ key + " = " + result);
        } finally {
            jedisPool.returnResource(jedis);
        }
        return result;
    }
}
