package com.test.transactional;

import com.dao.OrderMapper;
import com.dao.UserMapper;
import com.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cuijixu
 */
@Component
public class TransactionalTest {
    @Autowired
    OrderMapper mapper;

    @Transactional(rollbackFor = InterruptedException.class )
    public void test(){

        Order order = new Order();
        order.setSeckillId(111);
        order.setUserPhone((long) 178);
        mapper.insert(order);
        try {
            System.out.println("开始休眠");
            Thread.sleep(30000);
            System.out.println("休眠结束");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Order order1 = new Order();
        order1.setSeckillId(222);
        order1.setUserPhone((long) 131);
        mapper.insert(order1);
    }
}
