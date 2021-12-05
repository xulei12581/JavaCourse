package io.kimmking.rpcfx.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class JedisUtil {

    private static JedisPool pool = null;

    private DistributedLock lock = new DistributedLock(pool);

    int n = 500;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
    }

    public void seckill() {
        // 返回锁的value值，供释放锁时候进行判断
        String identifier = lock.lockWithTimeout("resource", 5000, 1000);
        System.out.println(Thread.currentThread().getName() + "获得了锁");
        System.out.println(--n);
        lock.releaseLock("resource", identifier);
    }
    /**
     * 对某个键的值自增
     * @param key 键
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public static long setDecr(String key, int cacheSeconds) {
        long result = 0;
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            result =jedis.decr(key);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            System.out.println("set "+ key + " = " + result);
        } catch (Exception e) {
            System.out.println("set "+ key + " = " + result);
        } finally {
            pool.returnResource(jedis);
        }
        return result;
    }
}
