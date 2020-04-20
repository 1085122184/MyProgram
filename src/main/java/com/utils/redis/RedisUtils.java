package com.utils.redis;

import com.entity.Goods;
import com.utils.MySchema;
import io.protostuff.runtime.RuntimeSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class RedisUtils {
    @Resource(name = "initJedisPool")
    private JedisPool jedisPool;


    private RuntimeSchema<Goods> schema = MySchema.GetSchema(Goods.class);

    public Goods getGoodsById(Integer good_id){
        Jedis jedis = jedisPool.getResource();
//        String key =
//        jedis.get()

        return null;
    }

    public String setGoods(Goods goods){
        Jedis jedis = jedisPool.getResource();
        String key = "GOODS"+goods.getGoodsId();
        String result = jedis.set(key,goods.toString());
        return result;
    }
}
