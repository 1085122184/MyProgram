package com.utils.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MqProducerTest {

    @Autowired
    MqProducer mqProducer;
    @Test
    public void send() {
        mqProducer.send("崔吉旭大吉大利顺顺利利！！！！！");
    }
}