package com.utils.redis;

import com.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTest {

    @Autowired
    RedisUtils redisUtils;
    @Test
    public void setGoods() {
        Goods goods = new Goods();
        for (int i=0;i<100;i++){
            goods.setGoodsId(i);
            redisUtils.setGoods(goods);
        }
    }

}